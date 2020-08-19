package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.jx.service.WxBaseService;
import com.utils.WxGetUserInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/21 15:16
 */
@RestController
@RequestMapping("wxBase")
public class WxBase {
    @Resource
    private WxBaseService wxBaseService;
    @Resource
    private HttpServletRequest request;

    /**
     * 微信绑定
     *
     * @param params {"code"}
     * @return result
     */
    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    public Map<String, Object> wxBind(@RequestBody JSONObject params) {
        String token = request.getHeader("Authorization");
        String code = params.getString("code");
        JSONObject userInfo = WxGetUserInfo.getUserInfo(code);
        return wxBaseService.wxBind(token, userInfo);
    }

    /**
     * 微信绑定
     *
     * @param params {"code"}
     * @return result
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> wxLogin(@RequestBody JSONObject params) {
        String code = params.getString("code");
        System.out.println(code);
        JSONObject userInfo = WxGetUserInfo.getUserInfo(code);
        System.out.println(userInfo);
        String openId = Objects.requireNonNull(userInfo).getString("openid");
        return wxBaseService.wxLogin(openId);
    }

    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    public void getCode(String code, String state) {
        System.out.println("code:" + code);
        System.out.println("state" + state);
    }
}
