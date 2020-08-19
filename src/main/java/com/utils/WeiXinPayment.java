package com.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/31 17:27
 */
public class WeiXinPayment {

    private static final Logger log = LoggerFactory.getLogger(WeiXinPayment.class);

    public static TreeMap<String, String> getH5PayArgs(HttpServletRequest req, String orderId, String openId, String money, String desc, String attach) {
        TreeMap<String, String> h5PayArgs = null;
        try {
            String ip = RequestUtils.getIpAddr(req);
            if (StringUtils.isEmpty(ip)) {
                ip = "127.0.0.1";
            }
            String rsXml = WxUtils.JsApiPayUnifiedOrder(orderId, money, ip, openId, desc, attach);
            Map<String, String> rs = WxUtils.parserJsApiPayUnifiedOrderResult(rsXml);
            String prepay_id = rs.get("prepay_id");
            if (prepay_id != null) {
                h5PayArgs = new TreeMap<String, String>();
                h5PayArgs.put("appId", WxUtils.AppID);
                h5PayArgs.put("timeStamp", String.valueOf(System.currentTimeMillis()));
                h5PayArgs.put("nonceStr", UUIDUtils.generate());
                h5PayArgs.put("package", "prepay_id=" + prepay_id);
                h5PayArgs.put("signType", "MD5");
                h5PayArgs = WxUtils.argSign(h5PayArgs);
                h5PayArgs.put("paySign", h5PayArgs.get("sign"));
                h5PayArgs.remove("sign");
            }
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf("WeiXinPayment") > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return h5PayArgs;
    }

    @SuppressWarnings("unchecked")
    public void getPaymentArgs(HttpServletRequest req, HttpServletResponse resp) {
        //getH5PayArgs(req, orderId, price, attach);
        //JSONUtils.newJsonMap().put("state", h5PayArgs != null).put("h5PayArgs", h5PayArgs).writeJsonString(resp);
    }

    public void agreeRefund(HttpServletRequest req, HttpServletResponse resp) {
/*		boolean state = false;
		String msg = "";
		try {
			TreeMap<String, String> map = WxUtils.refundAll(out_trade_no, out_refund_no, trade_fee);
			if("SUCCESS".equals(map.get("return_code"))){
				if("SUCCESS".equals(map.get("result_code"))){
					//todo
					state = true;
				}else{
					msg = new String(map.get("err_code_des").getBytes("ISO8859-1"), "UTF-8");
				}
			}
			JSONUtils.newJsonMap().put("state", state).put("msg", msg).writeJsonString(resp);
		} catch (Exception e) {
			for (StackTraceElement ele : e.getStackTrace()) {if (ele.toString().indexOf(this.getClass().getName()) > -1) {log.error(ele.toString());}}log.error(e.toString());
		}*/
    }

    public void agreeRefundPartial(HttpServletRequest req, HttpServletResponse resp) {
    }

}
