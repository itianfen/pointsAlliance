package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.intercept.Auth;
import com.jx.entity.Notice;
import com.jx.service.NoticeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 公告表(Notice)表控制层
 *
 * @author makejava
 * @since 2020-07-20 11:33:41
 */
@RestController
@Auth(user="admin,company")
@RequestMapping("notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

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
        return this.noticeService.queryById(param.getString("id"));
    }

    /**
     * 根据条件 分页查询列表
     *
     * @param notice         实体对象条件类
     * @param currentPage    页数
     * @param pageSize       每页条数
     * @param preciseOrFuzzy 精确 1/模糊 0
     * @param timeArea       时间范围 以 ~ 分隔
     * @return 列表结果/总条数
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(Notice notice, Integer currentPage, Integer pageSize, Integer preciseOrFuzzy, String timeArea) {
        return this.noticeService.queryAllByLimit(notice, currentPage, pageSize, preciseOrFuzzy, timeArea);
    }

    /**
     * 新增数据
     *
     * @param notice 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Notice notice) {
        return this.noticeService.insert(request.getHeader("Authorization"), notice);
    }

    /**
     * 修改数据(部分字段)
     *
     * @param notice 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Notice notice) {
        return this.noticeService.update(request.getHeader("Authorization"), notice);
    }

    /**
     * 修改数据(全部字段)
     *
     * @param notice 实体类
     * @return 结果集
     */
    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public Map<String, Object> updateAll(@RequestBody Notice notice) {
        return this.noticeService.updateAllColumn(request.getHeader("Authorization"), notice);
    }

    /**
     * 删除数据
     *
     * @param param{id:主键列表 ,分隔}
     * @return 结果集
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody JSONObject param) {
        return this.noticeService.deleteById(request.getHeader("Authorization"), param.getString("id"));
    }
}