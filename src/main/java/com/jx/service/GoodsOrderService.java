package com.jx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.GoodsOrder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单表(GoodsOrder)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 16:07:55
 */
@Service
public interface GoodsOrderService extends IService<GoodsOrder> {

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
     * @param goodsOrder     实体对象条件类
     * @param page           页数
     * @param limit          每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 对象列表
     */
    Map<String, Object> queryAllByLimit(GoodsOrder goodsOrder, Integer page, Integer limit, Integer preciseOrFuzzy, String timeArea);

    /**
     * 新增数据
     *
     * @param token      token
     * @param goodsOrder 实例对象
     * @return 实例对象
     */
    Map<String, Object> insert(String token, GoodsOrder goodsOrder);

    /**
     * 修改数据
     *
     * @param token      token
     * @param goodsOrder 实例对象
     * @return 实例对象
     */
    Map<String, Object> update(String token, GoodsOrder goodsOrder);

    /**
     * 修改数据（全部字段）
     *
     * @param token      token
     * @param goodsOrder 实例对象
     * @return 实例对象
     */
    Map<String, Object> updateAllColumn(String token, GoodsOrder goodsOrder);

    /**
     * 通过主键删除数据
     *
     * @param token token
     * @param id    主键列表 字符串根据,分隔
     * @return 是否成功
     */
    Map<String, Object> deleteById(String token, String id);

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
    Map<String, Object> createGoodsOrder(String token, String realName, String realPhone, String idCardNumber, String goodsId);


    /**
     * 通过审核
     *
     * @param goodsOrderId 订单ID
     * @return result
     */
    Map<String, Object> goodsApplySuccess(String goodsOrderId);

    /**
     * 根据id获取购买个数
     * @param goodsId 商品ID
     * @return 购买个数
     */
    long countByGoodsId(String goodsId);
}
