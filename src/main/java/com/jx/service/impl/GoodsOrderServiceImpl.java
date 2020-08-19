package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.GoodsOrderDao;
import com.jx.entity.Goods;
import com.jx.entity.GoodsOrder;
import com.jx.entity.SysUser;
import com.jx.entity.Token;
import com.jx.service.GoodsOrderService;
import com.jx.service.GoodsService;
import com.jx.service.SysUserService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 订单表(GoodsOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 16:07:55
 */
@Service
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderDao, GoodsOrder> implements GoodsOrderService {
    @Resource
    private GoodsOrderDao goodsOrderDao;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private GoodsService goodsService;

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
        GoodsOrder goodsOrder = this.goodsOrderDao.queryById(id);
        if (goodsOrder == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(goodsOrder);
    }

    /**
     * 查询多条数据
     *
     * @param goodsOrder     实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(GoodsOrder goodsOrder, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
        if (page == null || limit == null) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
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
        if (goodsOrder == null) {
            goodsOrder = new GoodsOrder();
        }
        goodsOrder.setDeleted(0);
        //列表
        List<GoodsOrder> list = this.goodsOrderDao.queryAllByLimit(goodsOrder, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.goodsOrderDao.countByParam(goodsOrder, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param goodsOrder 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, GoodsOrder goodsOrder) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        goodsOrder.setId(UUIDUtils.generate());
        goodsOrder.setCreatedTime(now);
        goodsOrder.setLastUpdateTime(now);
        goodsOrder.setCreator(tokenObj.getUserName());
        goodsOrder.setCreatorId(tokenObj.getUserId());
        goodsOrder.setLastUpdater(tokenObj.getUserName());
        goodsOrder.setLastUpdateId(tokenObj.getUserId());
        goodsOrder.setDeleted(0);
        if (this.goodsOrderDao.insert(goodsOrder) > 0) {
            return Response.success(goodsOrder);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param goodsOrder 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, GoodsOrder goodsOrder) {
        if (StringUtils.isEmpty(token, goodsOrder.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        goodsOrder.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        goodsOrder.setLastUpdater(tokenObj.getUserName());
        goodsOrder.setLastUpdateId(tokenObj.getUserId());
        goodsOrder.setDeleted(0);
        if (this.goodsOrderDao.update(goodsOrder) > 0) {
            return this.queryById(goodsOrder.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param goodsOrder 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, GoodsOrder goodsOrder) {
        if (StringUtils.isEmpty(token, goodsOrder.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        goodsOrder.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        goodsOrder.setLastUpdater(tokenObj.getUserName());
        goodsOrder.setLastUpdateId(tokenObj.getUserId());
        goodsOrder.setDeleted(0);
        if (this.goodsOrderDao.updateAllColumn(goodsOrder) > 0) {
            return Response.success(this.queryById(goodsOrder.getId()));
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
        if (this.goodsOrderDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 创建goodsOrder
     *
     * @param token        token
     * @param realName     真实姓名
     * @param realPhone    真实手机号
     * @param idCardNumber 身份证号码
     * @param goodsId      银行卡ID
     * @return 结果
     */
    @Override
    public Map<String, Object> createGoodsOrder(String token, String realName, String realPhone, String idCardNumber, String goodsId) {
        SysUser correctUser = sysUserService.getById(Objects.requireNonNull(TokenUtils.getTokenObj(token)).getUserId());
        List<GoodsOrder> list = list(new QueryWrapper<GoodsOrder>().eq(GoodsOrder.COL_APPLY_ID_CARD_NUMBER, idCardNumber).eq(GoodsOrder.COL_GOODS_ID, goodsId));
        if (!list.isEmpty()) {
            list.forEach(goodsOrder -> {
                goodsOrder.setLastUpdateId(correctUser.getId());
                goodsOrder.setLastUpdateTime(DateFormatUtils.getCurrentDate());
                goodsOrder.setLastUpdater(correctUser.getName());
                goodsOrder.setApplyName(realName);
                goodsOrder.setApplyPhone(realPhone);
                goodsOrder.insertOrUpdate();
            });
            return Response.success(ErrorItem.GOODS_INFORMATION_UPDATE_SUCCESS);
        } else {
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setId(UUIDUtils.generate());
            goodsOrder.setCreatedTime(DateFormatUtils.getCurrentDate());
            goodsOrder.setCreator(correctUser.getName());
            goodsOrder.setCreatorId(correctUser.getId());
            goodsOrder.setLastUpdateId(correctUser.getId());
            goodsOrder.setLastUpdateTime(DateFormatUtils.getCurrentDate());
            goodsOrder.setLastUpdater(correctUser.getName());
            goodsOrder.setUserId(correctUser.getId());
            goodsOrder.setUserName(correctUser.getName());
            goodsOrder.setUserPhone(correctUser.getPhone());
            goodsOrder.setApplyName(realName);
            goodsOrder.setApplyPhone(realPhone);
            goodsOrder.setApplyIdCardNumber(idCardNumber);
            goodsOrder.setAuditState(Integer.parseInt(ConstantPool.GOODS_ORDER_IN_REVIEW));
            Goods goods = goodsService.getById(goodsId);
            goodsOrder.setGoodsId(goods.getId());
            goodsOrder.setGoodsName(goods.getName());
            goodsOrder.setGoodsImg(goods.getCardImage());
            goodsOrder.setReward(goods.getReward());
            goodsOrder.setDeleted(0);
            goodsOrder.setAuditState(1);
            goodsOrder.insert();
            return Response.success(ErrorItem.GOODS_INFORMATION_SUBMIT_SUCCESS);
        }
    }

    /**
     * 通过审核
     *
     * @param goodsOrderId 订单ID
     * @return result
     */
    @Override
    public Map<String, Object> goodsApplySuccess(String goodsOrderId) {
        GoodsOrder goodsOrder = getById(goodsOrderId);
        SysUser sysUser = sysUserService.getById(goodsOrder.getUserId());
        goodsOrder.setAuditState(2);
        sysUser.setBalance(sysUser.getBalance().add(goodsOrder.getReward()));
        sysUser.setCumulativeProfit(sysUser.getCumulativeProfit().add(goodsOrder.getReward()));
        goodsOrder.updateById();
        sysUser.updateById();
        return Response.success();
    }

    /**
     * 根据id获取购买个数
     * @param goodsId 商品ID
     * @return 购买个数
     */
    @Override
    public long countByGoodsId(String goodsId) {
        GoodsOrder goodsOrder = new GoodsOrder();
        goodsOrder.setId(goodsId);
        goodsOrder.setDeleted(0);
        return goodsOrderDao.countByParam(goodsOrder,1,null,null);
    }
}
