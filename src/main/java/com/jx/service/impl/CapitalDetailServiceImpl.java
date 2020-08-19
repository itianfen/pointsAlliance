package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jx.dao.CapitalDetailDao;
import com.jx.entity.CapitalDetail;
import com.jx.entity.Token;
import com.jx.service.CapitalDetailService;
import com.jx.service.SysUserService;
import com.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 资金明细表(CapitalDetail)表服务实现类
 *
 * @author makejava
 * @since 2020-07-24 10:55:51
 */
@Service
public class CapitalDetailServiceImpl extends ServiceImpl<CapitalDetailDao, CapitalDetail> implements CapitalDetailService {
    @Resource
    private CapitalDetailDao capitalDetailDao;
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
        CapitalDetail capitalDetail = this.capitalDetailDao.queryById(id);
        if (capitalDetail == null) {
            return Response.fail(ErrorItem.NO_RESULT_ERROR);
        }
        return Response.success(capitalDetail);
    }

    /**
     * 查询多条数据
     *
     * @param capitalDetail  实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    @Override
    public Map<String, Object> queryAllByLimit(CapitalDetail capitalDetail, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea) {
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
        if (capitalDetail == null) {
            capitalDetail = new CapitalDetail();
        }
        capitalDetail.setDeleted(0);
        //列表
        List<CapitalDetail> list = this.capitalDetailDao.queryAllByLimit(capitalDetail, offset, limit, preciseOrFuzzy, begin, end);
        //总条数
        long count = this.capitalDetailDao.countByParam(capitalDetail, preciseOrFuzzy, begin, end);
        return Response.success(list, count);
    }

    /**
     * 新增数据
     *
     * @param capitalDetail 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> insert(String token, CapitalDetail capitalDetail) {
        if (StringUtils.isEmpty(token)) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        Date now = DateFormatUtils.getCurrentDate();
        capitalDetail.setId(UUIDUtils.generate());
        capitalDetail.setCreatedTime(now);
        capitalDetail.setLastUpdateTime(now);
        capitalDetail.setCreator(tokenObj.getUserName());
        capitalDetail.setCreatorId(tokenObj.getUserId());
        capitalDetail.setLastUpdater(tokenObj.getUserName());
        capitalDetail.setLastUpdateId(tokenObj.getUserId());
        capitalDetail.setDeleted(0);
        if (this.capitalDetailDao.insert(capitalDetail) > 0) {
            return Response.success(capitalDetail);
        }
        return Response.fail(ErrorItem.INSERT_ERROR);
    }

    /**
     * 修改数据
     *
     * @param capitalDetail 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> update(String token, CapitalDetail capitalDetail) {
        if (StringUtils.isEmpty(token, capitalDetail.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        capitalDetail.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        capitalDetail.setLastUpdater(tokenObj.getUserName());
        capitalDetail.setLastUpdateId(tokenObj.getUserId());
        capitalDetail.setDeleted(0);
        if (this.capitalDetailDao.update(capitalDetail) > 0) {
            return this.queryById(capitalDetail.getId());
        }
        return Response.fail(ErrorItem.UPDATE_ERROR);
    }

    /**
     * 修改数据（全部字段）
     *
     * @param capitalDetail 实例对象
     * @return 实例对象
     */
    @Override
    public Map<String, Object> updateAllColumn(String token, CapitalDetail capitalDetail) {
        if (StringUtils.isEmpty(token, capitalDetail.getId())) {
            return Response.fail(ErrorItem.MAST_PARAM_NOT_SET);
        }
        Token tokenObj = TokenUtils.getTokenObj(token);
        if (tokenObj == null) {
            return Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR);
        }
        capitalDetail.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        capitalDetail.setLastUpdater(tokenObj.getUserName());
        capitalDetail.setLastUpdateId(tokenObj.getUserId());
        capitalDetail.setDeleted(0);
        if (this.capitalDetailDao.updateAllColumn(capitalDetail) > 0) {
            return Response.success(this.queryById(capitalDetail.getId()));
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
        if (this.capitalDetailDao.deleteByIdNotTrue(idList, DateFormatUtils.getCurrentDate(), tokenObj.getUserName(), tokenObj.getUserId()) > 0) {
            return Response.success();
        }
        return Response.fail(ErrorItem.DELETE_ERROR);
    }

    /**
     * 获取收益流水
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    @Override
    public List<CapitalDetail> getProfitCapital(String token, Integer currentPage, Integer pageSize) {
        //流水类型
        // 1直推会员升级收益 2间推会员升级收益 3积分兑换 4会员积分兑换直接推荐 5会员积分兑换间接推荐 
        // 6盟主永久收益 7盟主差价收益 8盟主团队奖 9盟主同级兑换奖 10第一次推荐盟主直接奖励 11盟主二次升级奖励
        // 12会员升级 13盟主升级 14每日签到 15提现
        Integer[] profitTypes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        return getCapitalByType(token, currentPage, pageSize, profitTypes);
    }

    /**
     * 获取签到流水
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    @Override
    public List<CapitalDetail> getSignInCapital(String token, Integer currentPage, Integer pageSize) {
        //流水类型
        // 1直推会员升级收益 2间推会员升级收益 3积分兑换 4会员积分兑换直接推荐 5会员积分兑换间接推荐
        // 6盟主永久收益 7盟主差价收益 8盟主团队奖 9盟主同级兑换奖 10第一次推荐盟主直接奖励 11盟主二次升级奖励
        // 12会员升级 13盟主升级 14每日签到 15提现
        Integer[] profitTypes = {14};
        return getCapitalByType(token, currentPage, pageSize, profitTypes);
    }

    /**
     * 获取提现流水
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    @Override
    public List<CapitalDetail> getWithdrawCapital(String token, Integer currentPage, Integer pageSize) {
        //流水类型
        // 1直推会员升级收益 2间推会员升级收益 3积分兑换 4会员积分兑换直接推荐 5会员积分兑换间接推荐
        // 6盟主永久收益 7盟主差价收益 8盟主团队奖 9盟主同级兑换奖 10第一次推荐盟主直接奖励 11盟主二次升级奖励
        // 12会员升级 13盟主升级 14每日签到 15提现
        Integer[] profitTypes = {15};
        return getCapitalByType(token, currentPage, pageSize, profitTypes);
    }

    /**
     * 获取充值流水
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    @Override
    public List<CapitalDetail> getRechargeCapital(String token, Integer currentPage, Integer pageSize) {
        //流水类型
        // 1直推会员升级收益 2间推会员升级收益 3积分兑换 4会员积分兑换直接推荐 5会员积分兑换间接推荐
        // 6盟主永久收益 7盟主差价收益 8盟主团队奖 9盟主同级兑换奖 10第一次推荐盟主直接奖励 11盟主二次升级奖励
        // 12会员升级 13盟主升级 14每日签到 15提现
        Integer[] profitTypes = {12, 13};
        return getCapitalByType(token, currentPage, pageSize, profitTypes);
    }

    /**
     * 根据类型获取流水 使用in
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param types       流水类型数组
     * @return 流水列表
     */
    private List<CapitalDetail> getCapitalByType(String token, Integer currentPage, Integer pageSize, Integer[] types) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        List<Integer> capitalTypes = Arrays.asList(types);
        QueryWrapper<CapitalDetail> capitalDetailQueryWrapper = new QueryWrapper<>();
        capitalDetailQueryWrapper.eq(CapitalDetail.COL_USER_ID, Objects.requireNonNull(tokenObj).getUserId());
        capitalDetailQueryWrapper.in(CapitalDetail.COL_CAPITAL_TYPE, capitalTypes);
        capitalDetailQueryWrapper.orderByDesc(CapitalDetail.COL_CREATED_TIME);
        List<CapitalDetail> result = list(capitalDetailQueryWrapper);
        ListPageUtil<CapitalDetail> listPageUtil = new ListPageUtil<>();
        return listPageUtil.startPage(result, currentPage, pageSize);
    }
}

