package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.fluent.Request;

import java.nio.charset.StandardCharsets;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/21 15:48
 */
public class WxGetUserInfo {

    public static JSONObject getUserInfo(String code) {
        try {
            String tokenUrl = WxUtils.AccessTokenUrl.replace("{code}", code);
            JSONObject tokenRs = JSON.parseObject(Request.Get(tokenUrl).execute().returnContent().asString(StandardCharsets.UTF_8));
            String accessToken = tokenRs.getString("access_token");
            String openid = tokenRs.getString("openid");
            String userInfoUrl = WxUtils.UserInfoUrl.replace("{access_token}", accessToken).replace("{openid}", openid);
            return JSON.parseObject(Request.Get(userInfoUrl).execute().returnContent().asString(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
