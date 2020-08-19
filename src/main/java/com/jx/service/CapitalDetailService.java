package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.CapitalDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 资金明细表(CapitalDetail)表服务接口
 *
 * @author makejava
 * @since 2020-07-24 10:55:51
 */
@Service
public interface CapitalDetailService extends IService<CapitalDetail> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Map<String, Object> queryById(String id);

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
    Map<String, Object> queryAllByLimit(CapitalDetail capitalDetail, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token         token
     * @param capitalDetail 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, CapitalDetail capitalDetail);

    /**
     * 修改数据
     *
     * @param token         token
     * @param capitalDetail 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, CapitalDetail capitalDetail);

    /**
     * 修改数据（全部字段）
     *
     * @param token         token
     * @param capitalDetail 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, CapitalDetail capitalDetail);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 获取收益流水
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    List<CapitalDetail> getProfitCapital(String token, Integer currentPage, Integer pageSize);

    /**
     * 获取签到流水
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    List<CapitalDetail> getSignInCapital(String token, Integer currentPage, Integer pageSize);

    /**
     * 获取提现流水
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    List<CapitalDetail> getWithdrawCapital(String token, Integer currentPage, Integer pageSize);

    /**
     * 获取充值流水
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    List<CapitalDetail> getRechargeCapital(String token, Integer currentPage, Integer pageSize);
}

