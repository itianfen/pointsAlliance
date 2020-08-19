package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.intercept.Auth;
import com.jx.entity.RoleMenu;
import com.jx.service.RoleMenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 角色菜单对应表(RoleMenu)表控制层
 *
 * @author makejava
 * @since 2020-06-30 10:17:55
 */
@RestController
@Auth(user = "admin")
@RequestMapping("roleMenu")
public class RoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private RoleMenuService roleMenuService;

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
        return this.roleMenuService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param roleMenu       实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(RoleMenu roleMenu, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.roleMenuService.queryAllByLimit(roleMenu, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param roleMenu 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody RoleMenu roleMenu) {
        return this.roleMenuService.insert(request.getHeader("Authorization"), roleMenu);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param roleMenu 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody RoleMenu roleMenu) {
        return this.roleMenuService.update(request.getHeader("Authorization"), roleMenu);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param roleMenu 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody RoleMenu roleMenu) {
        return this.roleMenuService.updateAllColumn(request.getHeader("Authorization"), roleMenu);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.roleMenuService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 删除数据
     *
     * @param param{menuId:菜单ID,roleId:角色ID}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteRoleMenu", method = RequestMethod.POST)
    public Map<String, Object> deleteRoleMenu(@RequestBody JSONObject param) {
        return this.roleMenuService.deleteRoleMenu(param.getString("menuId"), param.getString("roleId"));
    }

    /**
     * 树形菜单查询
     *
     * @param param {roleId:角色ID}
     * @return 树形菜单
     */
    @RequestMapping(value = "/treeList", method = RequestMethod.POST)
    public Map<String, Object> treeList(@RequestBody JSONObject param) {
        return this.roleMenuService.treeList(param.getString("roleId"));
    }
}