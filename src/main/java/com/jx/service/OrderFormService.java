package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.OrderForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 订单表(OrderForm)表服务接口
 *
 * @author makejava
 * @since 2020-07-24 14:50:58
 */
@Service
public interface OrderFormService extends IService<OrderForm> {

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
     * @param orderForm      实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimit(OrderForm orderForm, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token     token
     * @param orderForm 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, OrderForm orderForm);

    /**
     * 修改数据
     *
     * @param token     token
     * @param orderForm 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, OrderForm orderForm);

    /**
     * 修改数据（全部字段）
     *
     * @param token     token
     * @param orderForm 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, OrderForm orderForm);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

    /**
     * 根据token和type查询订单
     *
     * @param token       token
     * @param type        type
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return list
     */
    List<OrderForm> queryByTypeAndToken(String token, Integer type, Integer currentPage, Integer pageSize);

    /**
     * 根据type获取订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param types       类型
     * @return list
     */
    List<OrderForm> getOderByType(String token, Integer currentPage, Integer pageSize, Integer[] types);

    /**
     * 获取全部订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return list
     */
    List<OrderForm> getAllOrder(String token, Integer currentPage, Integer pageSize);

    /**
     * 获取待审核订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return list
     */
    List<OrderForm> getWaitReviewOrder(String token, Integer currentPage, Integer pageSize);

    /**
     * 获取审核成功订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return list
     */
    List<OrderForm> getReviewSuccessOrder(String token, Integer currentPage, Integer pageSize);

    /**
     * 获取审核失败订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return list
     */
    List<OrderForm> getReviewFailOrder(String token, Integer currentPage, Integer pageSize);

    /**
     * 获取提现订单
     *
     * @param token       token
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return list
     */
    List<OrderForm> getWithdrawOrder(String token, Integer currentPage, Integer pageSize);
}
