package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jx.entity.Goods;
import com.jx.service.GoodsService;
import com.utils.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 商品表(Goods)表控制层
 *
 * @author makejava
 * @since 2020-07-29 18:44:51
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

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
        return this.goodsService.queryById(param.getString("id"));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param param {id:主键}
     * @return 单条数据
     */
    @RequestMapping(value = "/selectData", method = RequestMethod.POST)
    public Map<String, Object> selectData(@RequestBody JSONObject param) {
        return this.goodsService.selectData(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param goods          实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Goods goods, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.goodsService.queryAllByLimit(goods, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param goods 实例对象
     * @return 对象列表
     */
    @RequestMapping(value = "/allList", method = RequestMethod.GET)
    public Map<String, Object> queryAll(Goods goods) {
        return this.goodsService.queryAll(goods);
    }

    /**
     * 新增数据
     *
     * @param goods 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Goods goods) {
        return this.goodsService.insert(request.getHeader("Authorization"), goods);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param goods 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Goods goods) {
        return this.goodsService.update(request.getHeader("Authorization"), goods);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param goods 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Goods goods) {
        return this.goodsService.updateAllColumn(request.getHeader("Authorization"), goods);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.goodsService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 根据类型查询goods
     *
     * @param param {"type"}
     * @return 结果
     */
    @RequestMapping(value = "/queryByType", method = RequestMethod.POST)
    public Map<String, Object> queryByType(@RequestBody JSONObject param) {
        String type = param.getString("type");
        List<Goods> list = goodsService.list(new QueryWrapper<Goods>().eq(Goods.COL_TYPE, type));
        return Response.success(list);
    }
}