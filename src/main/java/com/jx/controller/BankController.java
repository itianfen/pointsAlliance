package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intercept.Auth;
import com.jx.entity.Bank;
import com.jx.service.BankService;
import com.utils.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * (Bank)表控制层
 *
 * @author makejava
 * @since 2020-07-14 17:07:26
 */
@RestController
@RequestMapping("bank")
public class BankController {
    /**
     * 服务对象
     */
    @Resource
    private BankService bankService;

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
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public Map<String, Object> selectById(@RequestBody JSONObject param) {
        return this.bankService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param bank           实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Bank bank, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.bankService.queryAllByLimit(bank, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param bank 实体类
     * @return 结果集
     */
    @Auth(user = "admin")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Bank bank) {
        return this.bankService.insert(request.getHeader("Authorization"), bank);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param bank 实体类
     * @return 结果集
     */
    @Auth(user = "admin")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Bank bank) {
        return this.bankService.update(request.getHeader("Authorization"), bank);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param bank 实体类
     * @return 结果集
     */
    @Auth(user = "admin")
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Bank bank) {
        return this.bankService.updateAllColumn(request.getHeader("Authorization"), bank);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @Auth(user = "admin")
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.bankService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 查询所有未删除银行
     *
     * @return 结果
     */
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public Map<String, Object> queryAll() {
        return Response.success(bankService.list(new QueryWrapper<Bank>().eq("DELETED", "0")));
    }
}