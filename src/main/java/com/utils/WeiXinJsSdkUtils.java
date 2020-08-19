package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.fluent.Request;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/*****
 *
 * @author zhaos
 *
 */
@Slf4j
public class WeiXinJsSdkUtils {
    private static final long refreshInterval = 7200 * 1000;
    public static String accessToken = "";
    public static String accessTokenBusiness = "";
    public static String jsApiTicket = "";
    private static long refreshTimeStamp = 0;
    private static long refreshTimeStamp1 = 0;

    static {
        refresh();
    }

    private static synchronized void refresh() {
        long ts = System.currentTimeMillis();
        if ((ts - refreshTimeStamp) >= refreshInterval) {
            try {
                // 此部分代码需要到:公众号-安全中心-ip白名单，配置服务器的外网ip
                String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WxUtils.AppID + "&secret=" + WxUtils.AppSecret;
                JSONObject tokenRs = JSON.parseObject(Request.Get(tokenUrl).execute().returnContent().asString(StandardCharsets.UTF_8));
                log.info("tokenRs:" + tokenRs);
                accessToken = tokenRs.getString("access_token");
                String ticketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";
                JSONObject ticketRs = JSON.parseObject(Request.Get(ticketUrl).execute().returnContent().asString(StandardCharsets.UTF_8));
                jsApiTicket = ticketRs.getString("ticket");
                refreshTimeStamp = ts;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static synchronized void refreshBusiness() {
        long ts = System.currentTimeMillis();
        if ((ts - refreshTimeStamp1) >= refreshInterval) {
            try {
                // 此部分代码需要到:公众号-安全中心-ip白名单，配置服务器的外网ip
                JSONObject tokenRs = JSON.parseObject(Request.Get(WxUtils.ACCESS_TOKEN).execute().returnContent().asString(StandardCharsets.UTF_8));
                accessTokenBusiness = tokenRs.getString("access_token");
                refreshTimeStamp1 = ts;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getAccessToken() {
        refresh();
        return accessToken;

    }

    public static String getBusinessAccessToken() {
        refreshBusiness();
        return accessTokenBusiness;
    }

    public static String getJsApiTicket() {
        refresh();
        return jsApiTicket;
    }

    public static Map<Object, Object> getJsApiConfigArgs(String url) {
        String jsapi_ticket = getJsApiTicket();
        String noncestr = UUIDUtils.generate();
        long timestamp = System.currentTimeMillis() / 1000;
        String signStr = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url;
        String signature = DigestUtils.sha1Hex(signStr.getBytes(StandardCharsets.UTF_8));
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("appId", WxUtils.AppID);
        map.put("timestamp", timestamp);
        map.put("nonceStr", noncestr);
        map.put("signature", signature);
        return map;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
    }
}
