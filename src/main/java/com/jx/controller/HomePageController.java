package com.jx.controller;

import com.jx.service.HomePageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/20 10:04
 */
@RestController
@RequestMapping("Home")
public class HomePageController {
    /**
     * 服务对象
     */
    @Resource
    private HomePageService homePageService;

    /**
     * 请求对象
     */
    @Resource
    private HttpServletRequest request;

    /**
     * 通过token获取首页信息
     *
     * @return 首页信息
     */
    @RequestMapping(value = "/getHome", method = RequestMethod.GET)
    public Map<String, Object> getHome() {
        return homePageService.getHome(request.getHeader("Authorization"));
    }

    /**
     * 通过token获取首页信息
     *
     * @return 首页信息
     */
    @RequestMapping(value = "/tan", method = RequestMethod.GET)
    public Map<String, Object> tan() {
        return homePageService.tan(request.getHeader("Authorization"));
    }

}
