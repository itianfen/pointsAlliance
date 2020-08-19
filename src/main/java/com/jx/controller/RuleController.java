package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.intercept.Auth;
import com.jx.entity.Rule;
import com.jx.service.RuleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 规则表(Rule)表控制层
 *
 * @author makejava
 * @since 2020-08-08 10:34:55
 */
@RestController
@RequestMapping("rule")
public class RuleController {
    /**
     * 服务对象
     */
    @Resource
    private RuleService ruleService;

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
        return this.ruleService.queryById(param.getString("id"));
    }

    /**
     * 通过type查询Content
     *
     * @param param 类型{typeId = ""}ID
     * @return content
     */
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/getContentByTypeId", method = RequestMethod.POST)
    public Map<String, Object> getContentByType(@RequestBody JSONObject param) {
        return this.ruleService.getContentByType(param.getInteger("typeId"));
    }
    
    /**
     * 根据条件 分页查询列表
     *
     * @param rule           实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Rule rule, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.ruleService.queryAllByLimit(rule, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param rule 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Rule rule) {
        return this.ruleService.insert(request.getHeader("Authorization"), rule);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param rule 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Rule rule) {
        return this.ruleService.update(request.getHeader("Authorization"), rule);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param rule 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Rule rule) {
        return this.ruleService.updateAllColumn(request.getHeader("Authorization"), rule);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.ruleService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }
}