package com.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yangyantong
 */
@Slf4j
public class AliyunSmsUtil {

    private static final String OK = "OK";
    private static final String MESSAGE = "Message";

    public static boolean sendSms(String phone, String code, String smsTemplate) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ConstantPool.ACCESSKEY, ConstantPool.SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "久益积分同盟");
        request.putQueryParameter("TemplateCode", smsTemplate);
        JSONObject codeJson = new JSONObject();
        codeJson.put("code", code);
        request.putQueryParameter("TemplateParam", codeJson.toString());
        try {
            CommonResponse response = client.getCommonResponse(request);
            JSONObject parse = (JSONObject) JSONObject.parse(response.getData());
            return OK.equals(parse.getString(MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送短信错误[{}]", e);
        }
        return false;
    }
}
