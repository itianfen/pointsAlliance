package com.jx.controller;

import com.intercept.Auth;
import com.jx.service.PersonalCenterService;
import com.utils.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/29 10:00
 */
@RestController
public class PersonalCenterController {

    @Resource
    private HttpServletRequest request;
    @Resource
    private PersonalCenterService personalCenterService;

    /**
     * 获取个人中心
     *
     * @return 个人信息
     */
    @Auth(user = "member,admin,company")
    @RequestMapping(value = "getPersonalCenter", method = RequestMethod.GET)
    public Map<String, Object> getPersonalCenter() {
        String token = request.getHeader("Authorization");
        return Response.success(personalCenterService.getPersonalCenter(token));
    }

}
