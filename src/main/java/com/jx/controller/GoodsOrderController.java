package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.jx.entity.GoodsOrder;
import com.jx.service.GoodsOrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 订单表(GoodsOrder)表控制层
 *
 * @author makejava
 * @since 2020-08-05 16:07:55
 */
@RestController
@RequestMapping("goodsOrder")
public class GoodsOrderController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsOrderService goodsOrderService;

    /**
     * 请求对象
     */
    @Resource
    private HttpServletRequest request;

    /**
     * 通过主键查询单条数据
     *
     * @param param {id:主键}
     * @return 单条数据
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public Map<String, Object> selectById(@RequestBody JSONObject param) {
        return this.goodsOrderService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param goodsOrder     实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(GoodsOrder goodsOrder, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.goodsOrderService.queryAllByLimit(goodsOrder, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param goodsOrder 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody GoodsOrder goodsOrder) {
        return this.goodsOrderService.insert(request.getHeader("Authorization"), goodsOrder);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param goodsOrder 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody GoodsOrder goodsOrder) {
        return this.goodsOrderService.update(request.getHeader("Authorization"), goodsOrder);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param goodsOrder 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody GoodsOrder goodsOrder) {
        return this.goodsOrderService.updateAllColumn(request.getHeader("Authorization"), goodsOrder);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.goodsOrderService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 创建goodsOrder
     *
     * @param params{"realName","realPhone","idCardNumber","goodsId"}
     * @return
     */
    @RequestMapping(value = "/createGoodsOrder", method = RequestMethod.POST)
    public Map<String, Object> createGoodsOrder(@RequestBody JSONObject params) {
        String token = request.getHeader("Authorization");
        String realName = params.getString("realName");
        String realPhone = params.getString("realPhone");
        String idCardNumber = params.getString("idCardNumber");
        String goodsId = params.getString("goodsId");
        return this.goodsOrderService.createGoodsOrder(token, realName, realPhone, idCardNumber, goodsId);
    }

    /**
     * 通过审核
     *
     * @param params {"goodsOrderId"}
     * @return result
     */
    @RequestMapping(value = "/goodsApplySuccess", method = RequestMethod.POST)
    public Map<String, Object> goodsApplySuccess(@RequestBody JSONObject params) {
        String goodsOrderId = params.getString("goodsOrderId");
        return this.goodsOrderService.goodsApplySuccess(goodsOrderId);
    }
}