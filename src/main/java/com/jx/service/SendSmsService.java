package com.jx.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jx.entity.SendSms;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yangyantong
 */
@Service
public interface SendSmsService extends IService<SendSms> {
    /**
     * 验证手机短信验证码
     *
     * @param params 前台参数{"phoneNumber","phoneState","phoneCode"}
     * @return 结果集
     */
    Map<String, Object> verificationCode(JSONObject params);

    /**
     * 获取短信验证码
     *
     * @param params 前台参数{"phoneNumber","phoneState","phoneCode"}
     * @return 返回参数
     */
    Map<String, Object> getPhoneCode(JSONObject params);
}