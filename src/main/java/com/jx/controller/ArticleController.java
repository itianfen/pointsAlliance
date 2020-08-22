package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.intercept.Auth;
import com.jx.entity.Article;
import com.jx.service.ArticleService;
import com.utils.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 文章表(Article)表控制层
 *
 * @author makejava
 * @since 2020-07-31 17:31:20
 */
@RestController
@Auth(user = "admin,company")
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

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
        return this.articleService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param article        实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @Auth(user = "admin,member,company")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Article article, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.articleService.queryAllByLimit(article, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param article 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Article article) {
        return this.articleService.insert(request.getHeader("Authorization"), article);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param article 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Article article) {
        return this.articleService.update(request.getHeader("Authorization"), article);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param article 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Article article) {
        return this.articleService.updateAllColumn(request.getHeader("Authorization"), article);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.articleService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }

    /**
     * 查询所有文章
     *
     * @return 文章
     */
    @Auth(user = "admin")
    @PostMapping("/queryAll")
    public Map<String, Object> queryAll() {
        return Response.success(articleService.list(new QueryWrapper<Article>().eq("DELETED", "0")));
    }
}