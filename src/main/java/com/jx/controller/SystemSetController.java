package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.intercept.Auth;
import com.jx.entity.SystemSet;
import com.jx.service.SystemSetService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 系统价格设置表(SystemSet)表控制层
 *
 * @author makejava
 * @since 2020-07-24 14:14:32
 */
@RestController
@Auth(user = "admin")
@RequestMapping("systemSet")
public class SystemSetController {
    /**
     * 服务对象
     */
    @Resource
    private SystemSetService systemSetService;

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
        return this.systemSetService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param systemSet      实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(SystemSet systemSet, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.systemSetService.queryAllByLimit(systemSet, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param systemSet 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody SystemSet systemSet) {
        return this.systemSetService.insert(request.getHeader("Authorization"), systemSet);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param systemSet 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody SystemSet systemSet) {
        return this.systemSetService.update(request.getHeader("Authorization"), systemSet);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param systemSet 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody SystemSet systemSet) {
        return this.systemSetService.updateAllColumn(request.getHeader("Authorization"), systemSet);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.systemSetService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }
}