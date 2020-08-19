package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.jx.service.SysUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zhaos 2020/6/23
 */
@RestController
@RequestMapping("/Login")
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 后台账号登录
     *
     * @param param {"account","password"}
     * @return token
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody JSONObject param) {
        return sysUserService.login(param);
    }

    /**
     * 找回密码
     *
     * @param param {"account","password","phoneCode"}
     * @return 返回参数
     */
    @RequestMapping(value = "/findPassword", method = RequestMethod.POST)
    public Map<String, Object> findPassword(@RequestBody JSONObject param) {
        return sysUserService.findPassword(param);
    }
}
