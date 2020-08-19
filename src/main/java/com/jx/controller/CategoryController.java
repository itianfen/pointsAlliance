package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intercept.Auth;
import com.jx.entity.Category;
import com.jx.service.CategoryService;
import com.utils.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * (Category)表控制层
 *
 * @author makejava
 * @since 2020-07-16 15:39:51
 */
@RestController
@RequestMapping("category")
@Auth(user="admin,company")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

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
        return this.categoryService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param category       实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Category category, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.categoryService.queryAllByLimit(category, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param params params
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody JSONObject params) {
        return this.categoryService.addCategory(request.getHeader("Authorization"), params.getString("name"));
    }

    /**
     * 修改数据(部分字段)
     *
     * @param category 实体类
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Category category) {
        return this.categoryService.update(request.getHeader("Authorization"), category);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param category 实体类
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Category category) {
        return this.categoryService.updateAllColumn(request.getHeader("Authorization"), category);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @Auth(user = "admin,company")
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.categoryService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 查分类带固定五项
     *
     * @return list
     */
    @Auth(user="admin,member,company")
    @RequestMapping(value = "/queryAllCategoryMore", method = RequestMethod.POST)
    public Map<String, Object> queryAllCategoryMore() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Category.COL_DELETED, 0);
        List<Category> list = categoryService.list(queryWrapper);
        queryWrapper.clear();
        queryWrapper.eq(Category.COL_SPARE1, 1);
        queryWrapper.orderByAsc(Category.COL_CREATED_TIME);
        List<Category> list1 = categoryService.list(queryWrapper);
        list1.addAll(list);
        return Response.success(list1);
    }

    /**
     * 查分类不带固定五项
     *
     * @return list
     */
    @RequestMapping(value = "/queryAllCategoryLess", method = RequestMethod.POST)
    public Map<String, Object> queryAllCategoryLess() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Category.COL_DELETED, 0);
        List<Category> list = categoryService.list(queryWrapper);
        return Response.success(list);
    }
}