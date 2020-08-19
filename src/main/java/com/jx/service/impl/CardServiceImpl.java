package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.CardDao;
import com.jx.entity.Card;
import com.jx.entity.SysUser;
import com.jx.entity.Token;
import com.jx.service.CardService;
import com.jx.service.SysUserService;
import com.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 银行卡(Card)表服务实现类
 *
 * @author makejava
 * @since 2020-07-27 16:31:26
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardDao, Card> implements CardService {
    @Resource
    private CardDao cardDao;
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Map<String, Object> queryById(String id) {
        if (StringUtils.isEmpty(id)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Card card = this.cardDao.queryById(id);
        if (card == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(card);
    }

    /**
     * 查询多条数据
     *
     * @param card           实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @param token          根据用户登陆的信息查询
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(String token, Card card, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
        if (page == null || limit == null) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        if (card == null) {
            card = new Card();
        }
        //如果是盟主 就查盟主自己的
        if (StringUtils.isNotEmpty(token) && TokenUtils.getTokenObj(token) != null && ConstantPool.COMPANY_ROLE_ID.equals(TokenUtils.getTokenObj(token).getRoleId())) {
            card.setCompanyId(TokenUtils.getTokenObj(token).getUserId());
        } else if (StringUtils.isNotEmpty(token) && TokenUtils.getTokenObj(token) != null && ConstantPool.MEMBER_ROLE_ID.equals(TokenUtils.getTokenObj(token).getRoleId())) {
            card.setCompanyId(StringUtils.isNotEmpty(TokenUtils.getTokenObj(token).getCompanyId()) ? TokenUtils.getTokenObj(token).getCompanyId() : ConstantPool.PLATFORM_COMPANY_ID);
        } else {
            card.setCompanyId(ConstantPool.PLATFORM_COMPANY_ID);
        }
        if (preciseOrFuzzy == null) {
            preciseOrFuzzy = 1;
        }
        if (page < 1) {
            page = 1;
        }
        long offset = (page - 1) * limit;
        //时间范围
        Date begin = null, end = null;
        if (StringUtils.isNotEmpty(timeArea)) {
            String[] times = timeArea.split("~");
            begin = DateFormatUtils.parseDateString(times[0], DateFormatUtils.defaultFormat);
            end = DateFormatUtils.parseDateString(times[1], DateFormatUtils.defaultFormat);
        }

        card.setDeleted(0);
        //列表
        List<Card> list = this.cardDao.queryAllByLimit(card, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.cardDao.countByParam(card, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param card 实例对象
     * @return 实例对象
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @Override
    public Map<String, Object> insert(String token, Card card) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        //平台的卡
        Date now = DateFormatUtils.getCurrentDate();
        card.setId(UUIDUtils.generate());
        card.setCreatedTime(now);
        card.setLastUpdateTime(now);
        card.setCreator(tokenObj.getUserName());
        card.setCreatorId(tokenObj.getUserId());
        card.setLastUpdater(tokenObj.getUserName());
        card.setLastUpdateId(tokenObj.getUserId());
        card.setCompanyId(tokenObj.getUserId());
        card.setSpare1(UUIDUtils.generate());
        card.setDeleted(0);
        //复制一份给盟主
        List<Card> newList = new ArrayList<>();
        newList.add(card);
        List<SysUser> list = sysUserService.list(new QueryWrapper<SysUser>().eq(SysUser.COL_ROLE_ID, ConstantPool.COMPANY_ROLE_ID));
        list.forEach(sysUser -> {
            Card temp = new Card();
            BeanUtils.copyProperties(card, temp);
            temp.setCompanyId(sysUser.getId());
            temp.setId(UUIDUtils.generate());
            newList.add(temp);
        });
        saveOrUpdateBatch(newList);
        return Response.success();
    }

    /**
     * 修改数据
     *
     * @param card 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Card card) {
        if (StringUtils.isEmpty(token, card.getSpare1())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        //判断是盟主还是管理员
        //如果是管理员
        String userId = tokenObj.getUserId();
        if (ConstantPool.PLATFORM_ROLE_ID.equals(tokenObj.getRoleId())) {
            String cardId = card.getSpare1();
            List<Card> list = list(new QueryWrapper<Card>().eq(Card.COL_SPARE1, cardId));
            List<Card> newList = new ArrayList<>();
            list.forEach(card1 -> {
                Card temp = new Card();
                BeanUtils.copyProperties(card, temp);
                temp.setId(card1.getId());
                temp.setLastUpdateTime(DateFormatUtils.getCurrentDate());
                temp.setLastUpdater(tokenObj.getUserName());
                temp.setLastUpdateId(userId);
                temp.setCompanyId(card1.getCompanyId());
                newList.add(temp);
            });
            updateBatchById(newList);
        } else {
            //获取盟主等级
            SysUser user = sysUserService.getById(userId);
            Integer companyLevel = user.getCompanyLevel();
            String cardId = card.getId();
            Card temp = getById(cardId);
            //黄金会员价格低于普通会员价格
            if (card.getMemberGold().compareTo(temp.getMemberNormal()) < 0) {
                return Response.fail("黄金会员价格不得低于普通会员价格");
            }
            //钻石会员价格低于普通会员价格
            if (card.getMemberDiamond().compareTo(temp.getMemberNormal()) < 0) {
                return Response.fail("钻石会员价格不得低于普通会员价格");
            }
            //根据盟主等级获取平台最低价
            BigDecimal price = BigDecimal.ZERO;
            switch (companyLevel) {
                case 1:
                    price = temp.getNormalCompanyFloorPrice();
                    break;
                case 2:
                    price = temp.getAdvancedCompanyFloorPrice();
                    break;
                case 3:
                    price = temp.getSuperCompanyFloorPrice();
                    break;
                default:
                    throw new RuntimeException("非法等级");
            }
            //黄金价格大于平台设置的盟主底价
            if (card.getMemberGold().compareTo(price) > 0) {
                return Response.fail("黄金会员价格不得高于平台价格");
            }
            if (card.getMemberDiamond().compareTo(price) > 0) {
                return Response.fail("钻石会员价格不得高于平台价格");
            }
            card.updateById();
        }
        return Response.success();
    }

    /**
     * 修改数据（全部字段）
     *
     * @param card 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Card card) {
        if (StringUtils.isEmpty(token, card.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        card.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        card.setLastUpdater(tokenObj.getUserName());
        card.setLastUpdateId(tokenObj.getUserId());
        card.setDeleted(0);
        if (this.cardDao.updateAllColumn(card) > 0) {
            return Response.success(this.queryById(card.getId()));
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键列表 字符串根据,分隔
     * @return 是否成功
     */
    @Override
    public Map<String, Object> deleteById(String token, String id) {
        if (StringUtils.isEmpty(token, id)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        //转为换维数组格式
        String[] idArr = id.split(",");
        List<String> idList = new ArrayList<>();
        Collections.addAll(idList, idArr);
        //逻辑删除
        if (this.cardDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 根据token查询card分页
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param token       token
     * @return list
     */
    @Override
    public List<Card> getListPage(Integer currentPage, Integer pageSize, String token) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        String companyId;
        //如果是盟主
        if (ConstantPool.COMPANY_ROLE_ID.equals(Objects.requireNonNull(tokenObj).getRoleId())) {
            companyId = tokenObj.getUserId();
        } else if (!StringUtils.isEmpty(tokenObj.getCompanyId())) {
            companyId = tokenObj.getCompanyId();
        } else {
            companyId = ConstantPool.PLATFORM_COMPANY_ID;
        }
        //根据盟主ID查card
        QueryWrapper<Card> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Card.COL_COMPANY_ID, companyId);
        queryWrapper.eq(Card.COL_DELETED, 0);
        List<Card> result = list(queryWrapper);
        ListPageUtil<Card> listPageUtil = new ListPageUtil<>();
        return listPageUtil.startPage(result, currentPage, pageSize);

    }
}
