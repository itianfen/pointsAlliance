package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.jx.entity.Sign;
import com.jx.service.SignService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * (Sign)表控制层
 *
 * @author makejava
 * @since 2020-07-20 15:01:40
 */
@RestController
@RequestMapping("sign")
public class SignController {
    /**
     * 服务对象
     */
    @Resource
    private SignService signService;

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
        return this.signService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param sign           实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Sign sign, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.signService.queryAllByLimit(sign, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param sign 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Sign sign) {
        return this.signService.insert(request.getHeader("Authorization"), sign);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param sign 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Sign sign) {
        return this.signService.update(request.getHeader("Authorization"), sign);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param sign 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Sign sign) {
        return this.signService.updateAllColumn(request.getHeader("Authorization"), sign);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.signService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 签到
     *
     * @return 结果
     */
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public Map<String, Object> sign() {
        String token = request.getHeader("Authorization");
        return this.signService.sign(token);
    }
}