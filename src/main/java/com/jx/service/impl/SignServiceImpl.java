package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.SignDao;
import com.jx.entity.*;
import com.jx.service.CapitalDetailService;
import com.jx.service.SignService;
import com.jx.service.SysUserService;
import com.jx.service.SystemSetService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * (Sign)表服务实现类
 *
 * @author makejava
 * @since 2020-07-20 15:01:40
 */
@Service
public class SignServiceImpl extends ServiceImpl<SignDao, Sign> implements SignService {
    @Resource
    private SignDao signDao;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SystemSetService systemSetService;
    @Resource
    private CapitalDetailService capitalDetailService;

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
        Sign sign = this.signDao.queryById(id);
        if (sign == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(sign);
    }

    /**
     * 查询多条数据
     *
     * @param sign           实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(Sign sign, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (sign == null) {
            sign = new Sign();
        }
        sign.setDeleted(0);
        //列表
        List<Sign> list = this.signDao.queryAllByLimit(sign, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.signDao.countByParam(sign, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param sign 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, Sign sign) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        sign.setId(UUIDUtils.generate());
        sign.setCreatedTime(now);
        sign.setLastUpdateTime(now);
        sign.setCreator(tokenObj.getUserName());
        sign.setCreatorId(tokenObj.getUserId());
        sign.setLastUpdater(tokenObj.getUserName());
        sign.setLastUpdateId(tokenObj.getUserId());
        sign.setDeleted(0);
        if (this.signDao.insert(sign) > 0) {
            return Response.success(sign);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param sign 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, Sign sign) {
        if (StringUtils.isEmpty(token, sign.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        sign.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        sign.setLastUpdater(tokenObj.getUserName());
        sign.setLastUpdateId(tokenObj.getUserId());
        sign.setDeleted(0);
        if (this.signDao.update(sign) > 0) {
            return this.queryById(sign.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param sign 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, Sign sign) {
        if (StringUtils.isEmpty(token, sign.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        sign.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        sign.setLastUpdater(tokenObj.getUserName());
        sign.setLastUpdateId(tokenObj.getUserId());
        sign.setDeleted(0);
        if (this.signDao.updateAllColumn(sign) > 0) {
            return Response.success(this.queryById(sign.getId()));
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
        if (this.signDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    @Override
    public boolean checkSign(String token) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        String userId = Objects.requireNonNull(tokenObj).getUserId();
        List<Sign> list = list(new QueryWrapper<Sign>().gt(Sign.COL_CREATED_TIME, DateFormatUtils.getTodayBegin()).eq(Sign.COL_USER_ID, userId));
        return !list.isEmpty();
    }

    @Override
    public Map<String, Object> sign(String token) {
        if (checkSign(token)) {
            return Response.fail(ErrorItem.DONT_SIGN_AGAIN);
        } else {
            Token tokenObj = TokenUtils.getTokenObj(token);
            SysUser sysUser = sysUserService.getById(Objects.requireNonNull(tokenObj).getUserId());
            Sign sign = new Sign();
            sign.setDeleted(0);
            sign.setId(UUIDUtils.generate());
            sign.setCreatorId(sysUser.getId());
            sign.setCreator(sysUser.getName());
            sign.setCreatedTime(DateFormatUtils.getCurrentDate());
            sign.setLastUpdateId(sysUser.getId());
            sign.setLastUpdater(sysUser.getName());
            sign.setLastUpdateTime(DateFormatUtils.getCurrentDate());
            sign.setUserId(sysUser.getId());
            SystemSet systemSet = systemSetService.getOne(new QueryWrapper<SystemSet>().eq(SystemSet.COL_COMPANY_ID, ConstantPool.PLATFORM_COMPANY_ID));
            Random random = new Random();
            String min = systemSet.getSpare1();
            String max = systemSet.getSpare2();
            BigDecimal minProfit = new BigDecimal(min).setScale(2, BigDecimal.ROUND_DOWN);
            BigDecimal maxProfit = new BigDecimal(max).setScale(2, BigDecimal.ROUND_DOWN);
            float minF = minProfit.floatValue();
            float maxF = maxProfit.floatValue();
            BigDecimal signProfit = new BigDecimal(Math.random() * (maxF - minF) + minF).setScale(2, BigDecimal.ROUND_DOWN);
            sign.setGetMoney(signProfit);
            sysUser.setBalance(sysUser.getBalance().add(signProfit));
            sysUser.setCumulativeProfit(sysUser.getCumulativeProfit().add(signProfit));
            sysUser.updateById();
            sign.insertOrUpdate();

            //发送签到公众号消息
            if (!StringUtils.isEmpty(sysUser.getOpenId())) {
                WeiXinSendMsg.signMsg(sysUser.getName(), signProfit.toString(), sysUser.getOpenId());
            }

            //增加签到流水
            //---------------add by zhaos begin 2020-08-08----------------//
            CapitalDetail capitalDetail = new CapitalDetail();
            capitalDetail.setCapitalContent("签到增加流水");
            capitalDetail.setUserId(sysUser.getId());
            capitalDetail.setCapitalType(14);
            capitalDetail.setPointsDetail(BigDecimal.ZERO);
            capitalDetail.setMoneyDetail(signProfit);
            capitalDetail.setOrderId(sign.getId());
            //插入收益记录
            capitalDetailService.insert(token, capitalDetail);

            //---------------add by zhaos end 2020-08-08----------------//
            return Response.success(ErrorItem.SIGN_SUCCESS + "收益+" + signProfit);

        }
    }
}