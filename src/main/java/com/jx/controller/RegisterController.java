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
 * 银行卡(Card)表控制层
 *
 * @author yangyantong
 * @since 2020-07-13 09:30:24
 */
@RestController
@RequestMapping("/Register")
public class RegisterController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;


    /**
     * 注册方法
     *
     * @param param {"phoneNumber","password","parentId","phoneCode"}
     * @return 结果
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(@RequestBody JSONObject param) {
        return sysUserService.register(param);
    }


}
