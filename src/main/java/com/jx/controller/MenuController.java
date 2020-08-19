package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.intercept.Auth;
import com.jx.entity.Menu;
import com.jx.service.MenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 菜单表(Menu)表控制层
 *
 * @author makejava
 * @since 2020-06-24 12:29:05
 */
@RestController
@Auth(user = "admin,company")
@RequestMapping("/menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    @Resource
    private HttpServletRequest request;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public Map<String, Object> selectById() {
        String id = request.getParameter("id");
        return this.menuService.queryById(id);
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param menu  实体对象条件类
     * @param page  页数
     * @param limit 每页条数
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Map<String, Object> list(Menu menu, int page, int limit) {
        return this.menuService.queryAllByLimit(menu, page, limit);
    }

    /**
     * 树形菜单查询
     *
     * @return 树形菜单
     */
    @RequestMapping(value = "/treeList", method = RequestMethod.POST)
    public Map<String, Object> treeList() {
        return this.menuService.treeList();
    }

    /**
     * 新增数据
     *
     * @param menu 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Menu menu) {
        return this.menuService.insert(request.getHeader("Authorization"), menu);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param menu 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Menu menu) {
        return this.menuService.update(request.getHeader("Authorization"), menu);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param menu 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Menu menu) {
        return this.menuService.updateAllColumn(request.getHeader("Authorization"), menu);
    }

    /**
     * 删除数据
     *
     * @param param{id}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.menuService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 根据token获取菜单
     *
     * @return 结果集
     */
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST)
    public Map<String, Object> getMenu() {
        return this.menuService.getMenuByToken(request.getHeader("Authorization"));
    }
}