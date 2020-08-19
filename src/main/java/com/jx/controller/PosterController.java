package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.intercept.Auth;
import com.jx.entity.Poster;
import com.jx.service.PosterService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 海报管理表(Poster)表控制层
 *
 * @author makejava
 * @since 2020-08-04 18:10:23
 */
@RestController
@Auth(user = "admin")
@RequestMapping("poster")
public class PosterController {
    /**
     * 服务对象
     */
    @Resource
    private PosterService posterService;

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
        return this.posterService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param poster         实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Poster poster, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.posterService.queryAllByLimit(poster, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param poster 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Poster poster) {
        return this.posterService.insert(request.getHeader("Authorization"), poster);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param poster 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Poster poster) {
        return this.posterService.update(request.getHeader("Authorization"), poster);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param poster 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Poster poster) {
        return this.posterService.updateAllColumn(request.getHeader("Authorization"), poster);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.posterService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @Auth(user = "admin,member,company")
    public Map<String, Object> findAll() {
        return this.posterService.queryAll();
    }
}