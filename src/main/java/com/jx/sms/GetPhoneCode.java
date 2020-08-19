package com.jx.sms;

import com.alibaba.fastjson.JSONObject;
import com.jx.service.SendSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yangyantong
 */
@RestController
@Slf4j
public class GetPhoneCode {
    @Resource
    private SendSmsService sendSmsService;

    /**
     * 获取短信验证码
     *
     * @param params {"phoneNumber","phoneState"}
     * @return 验证码
     */
    @RequestMapping(value = "/GetPhoneCode", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> getPhoneCode(@RequestBody JSONObject params) {
        return sendSmsService.getPhoneCode(params);
    }
}
