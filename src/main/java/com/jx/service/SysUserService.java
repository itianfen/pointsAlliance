package com.jx.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.OrderForm;
import com.jx.entity.SysUser;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 系统用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-07-17 11:50:41
 */
@Service
public interface SysUserService extends IService<SysUser> {

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
     * @param sysUser        实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimit(SysUser sysUser, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 查询多条数据
     *
     * @param sysUser        实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimitNot(SysUser sysUser, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token   token
     * @param sysUser 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, SysUser sysUser);

    /**
     * 修改数据
     *
     * @param token   token
     * @param sysUser 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, SysUser sysUser);

    /**
     * 修改数据（全部字段）
     *
     * @param token   token
     * @param sysUser 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 根据账号查询
     *
     * @param account 账号
     * @return 对象
     */
    SysUser queryByAccount(String account);

    /**
     * 注册
     *
     * @param param 前台数据
     * @return 返回参数
     */
    Map<String, Object> register(JSONObject param);

    /**
     * 登陆
     *
     * @param param {"phoneNumber","password","parentId","phoneCode"}
     * @return 返回参数
     */
    Map<String, Object> login(JSONObject param);

    /**
     * 通过实体封装登陆token
     *
     * @param sysUser 实体
     * @return token
     */
    Map<String, Object> loginUtil(SysUser sysUser);

    /**
     * 找回密码
     *
     * @param param {"account","password","phoneCode"}
     * @return 返回参数
     */
    Map<String, Object> findPassword(JSONObject param);

    /**
     * 累计积分兑换升级
     *
     * @param token token
     * @return 升级结果
     */
    Map<String, Object> pointUpgrade(String token);

    /**
     * 会员充值升级 假定已经支付成功
     *
     * @param orderForm       不完整的订单
     * @param wxPaymentId     微信支付订单号
     * @param wxPaymentAmount 支付钱数
     * @param token           token
     * @param level           要到达的等级
     * @return 升级结果
     */
    Map<String, Object> moneyUpgradeMember(OrderForm orderForm, String wxPaymentId, BigDecimal wxPaymentAmount, String token, String level);

    /**
     * 盟主充值升级 假定已经支付成功
     *
     * @param orderForm       不完整的订单
     * @param wxPaymentId     微信支付订单号
     * @param wxPaymentAmount 支付钱数
     * @param token           token
     * @param level           要到达的等级
     * @return 升级结果
     */
    Map<String, Object> moneyUpgradeCompany(OrderForm orderForm, String wxPaymentId, BigDecimal wxPaymentAmount, String token, String level);

    /**
     * 根据token获取下级
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    List<SysUser> getLowLevelByPage(String token, Integer currentPage, Integer pageSize);

    /**
     * 根据token获取间接下级
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 列表
     */
    List<SysUser> getSubLowLevelByPage(String token, Integer currentPage, Integer pageSize);

    /**
     * 用户升级微信回调接口
     *
     * @param pcbrs 微信支付结果
     * @return 结果
     */
    void memberUpgradeWxCallback(TreeMap<String, String> pcbrs);

    /**
     * 用户升级微信回调接口
     *
     * @param pcbrs 微信支付结果
     * @return 结果
     */
    void companyUpgradeWxCallback(TreeMap<String, String> pcbrs);

    /**
     * 重置密码
     *
     * @param userId   用户ID
     * @param password 新密码
     * @return 结果
     */
    Map<String, Object> resetPass(String userId, String password);

    /**
     * 获取我的推荐码
     *
     * @param token token
     * @return 二维码地址以及 推荐码
     */
    Map<String, Object> getMyQrCode(String token);

    /**
     * 创建升级订单
     *
     * @param order       订单对象
     * @param targetLevel 目标等级
     * @param type        1会员 2盟主
     * @return 订单对象
     */
    OrderForm createdUpGrade(OrderForm order, String targetLevel, Integer type);
}




