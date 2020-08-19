package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intercept.Auth;
import com.jx.entity.Role;
import com.jx.service.RoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 角色表(Role)表控制层
 *
 * @author makejava
 * @since 2020-06-29 16:16:38
 */
@RestController
@Auth(user = "admin")
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

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
        return this.roleService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param role           实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Role role, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.roleService.queryAllByLimit(role, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 查询全部角色
     *
     * @return 全部角色
     */
    @RequestMapping(value = "/allRole", method = RequestMethod.POST)
    public Map<String, Object> allRole() {
        return this.roleService.allRole();
    }

    /**
     * 新增数据
     *
     * @param role 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Role role) {
        return this.roleService.insert(request.getHeader("Authorization"), role);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param role 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Role role) {
        return this.roleService.update(request.getHeader("Authorization"), role);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param role 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Role role) {
        return this.roleService.updateAllColumn(request.getHeader("Authorization"), role);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.roleService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 不包括盟主与会员
     *
     * @return list
     */
    @RequestMapping(value = "/getRole", method = RequestMethod.POST)
    public List<Role> getRole() {
        return roleService.list(new QueryWrapper<Role>().notIn(Role.COL_ID, "2", "3"));
    }
}