package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.intercept.Auth;
import com.jx.entity.CapitalDetail;
import com.jx.service.CapitalDetailService;
import com.utils.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 资金明细表(CapitalDetail)表控制层
 *
 * @author makejava
 * @since 2020-07-24 10:55:52
 */
@RestController
@Auth(user = "admin,member,company")
@RequestMapping("capitalDetail")
public class CapitalDetailController {
    /**
     * 服务对象
     */
    @Resource
    private CapitalDetailService capitalDetailService;

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
        return this.capitalDetailService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param capitalDetail  实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(CapitalDetail capitalDetail, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.capitalDetailService.queryAllByLimit(capitalDetail, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param capitalDetail 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody CapitalDetail capitalDetail) {
        return this.capitalDetailService.insert(request.getHeader("Authorization"), capitalDetail);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param capitalDetail 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody CapitalDetail capitalDetail) {
        return this.capitalDetailService.update(request.getHeader("Authorization"), capitalDetail);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param capitalDetail 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody CapitalDetail capitalDetail) {
        return this.capitalDetailService.updateAllColumn(request.getHeader("Authorization"), capitalDetail);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.capitalDetailService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 获得收益流水带翻页
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @RequestMapping(value = "/getProfitCapital", method = RequestMethod.POST)
    public Map<String, Object> getProfitCapital(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(capitalDetailService.getProfitCapital(token, currentPage, pageSize));
    }

    /**
     * 获得签到流水带翻页
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @RequestMapping(value = "/getSignInCapital", method = RequestMethod.POST)
    public Map<String, Object> getSignInCapital(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(capitalDetailService.getSignInCapital(token, currentPage, pageSize));
    }

    /**
     * 获得提现流水带翻页
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @RequestMapping(value = "/getWithdrawCapital", method = RequestMethod.POST)
    public Map<String, Object> getWithdrawCapital(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(capitalDetailService.getWithdrawCapital(token, currentPage, pageSize));
    }

    /**
     * 获得充值流水带翻页(充钱升级)
     *
     * @param param {currentPage,pageSize}
     * @return 列表
     */
    @RequestMapping(value = "/getRechargeCapital", method = RequestMethod.POST)
    public Map<String, Object> getRechargeCapital(@RequestBody JSONObject param) {
        String token = request.getHeader("Authorization");
        Integer currentPage = param.getInteger("currentPage");
        Integer pageSize = param.getInteger("pageSize");
        return Response.success(capitalDetailService.getRechargeCapital(token, currentPage, pageSize));
    }
}