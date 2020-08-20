package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intercept.Auth;
import com.jx.entity.CustomerService;
import com.jx.service.CustomerServiceService;
import com.utils.ErrorItem;
import com.utils.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 客服表(CustomerService)表控制层
 *
 * @author makejava
 * @since 2020-07-21 14:47:00
 */
@RestController
@RequestMapping("customerService")
public class CustomerServiceController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerServiceService customerServiceService;

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
        return this.customerServiceService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param customerService 实体对象条件类
     * @param currentPage     页数
     * @param pageSize        每页条数
     * @param preciseOrFuzzy  精确 1/模糊 0
     * @param timeArea        时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(CustomerService customerService, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.customerServiceService.queryAllByLimit(customerService, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param customerService 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody CustomerService customerService) {
        return this.customerServiceService.insert(request.getHeader("Authorization"), customerService);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param customerService 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody CustomerService customerService) {
        return this.customerServiceService.update(request.getHeader("Authorization"), customerService);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param customerService 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody CustomerService customerService) {
        return this.customerServiceService.updateAllColumn(request.getHeader("Authorization"), customerService);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.customerServiceService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    @Auth(user = "admin")
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public Map<String, Object> queryAll() {
        QueryWrapper<CustomerService> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DELETED", "0");
        List<CustomerService> list = customerServiceService.list(queryWrapper);
        return list == null ? Response.fail(ErrorItem.SYSTEM_ERROR_MSG) : Response.success(list);
    }

    @PostMapping("/getRandomService")
    public CustomerService getRandomService() {
        List<CustomerService> list = customerServiceService.list(new QueryWrapper<CustomerService>().eq("DELETED", 0));
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}