package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.dom4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.*;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/21 15:20
 */
public class WxUtils {
    private static final Logger log = LoggerFactory.getLogger(WxUtils.class);
    public static String AppID = "";
    public static String AppSecret = "";
    public static String LoginUrl = "";
    public static String RedirectUrl = "";
    public static String AccessTokenUrl = "";
    public static String UserInfoUrl = "";
    public static String MchId = "";
    public static String Key = "";
    public static String PaymentCallBack = "";
    public static String SendTemplateMsgUrl = "";
    public static String ACCESS_TOKEN = "";
    public static String QR_CODE_URL = "";

    static {
        try {
            ResourceBundle wxrb = ResourceBundle.getBundle("weixin");
            AppID = wxrb.getString("AppID");
            AppSecret = wxrb.getString("AppSecret");
            MchId = wxrb.getString("MchId");
            Key = wxrb.getString("Key");

            QR_CODE_URL = wxrb.getString("qrCodeUrl");


            LoginUrl = wxrb.getString("LoginUrl");
            RedirectUrl = wxrb.getString("RedirectUrl");
            AccessTokenUrl = wxrb.getString("AccessTokenUrl");
            UserInfoUrl = wxrb.getString("UserInfoUrl");
            PaymentCallBack = wxrb.getString("PaymentCallBack");

            RedirectUrl = URLEncoder.encode(RedirectUrl, "UTF-8");
            LoginUrl = LoginUrl.replace("{AppID}", AppID).replace("{RedirectUrl}", RedirectUrl);
            AccessTokenUrl = AccessTokenUrl.replace("{AppID}", AppID).replace("{AppSecret}", AppSecret);

            //推送消息使用
            ACCESS_TOKEN = wxrb.getString("ACCESS_TOKEN");
            SendTemplateMsgUrl = wxrb.getString("SendTemplateMsgUrl");
            ACCESS_TOKEN = ACCESS_TOKEN.replace("{AppID}", AppID).replace("{AppSecret}", AppSecret);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 部分退款
     *
     * @param out_trade_no  需要退款的订单号
     * @param out_refund_no 退款单号，可以使用 订单号_refund 来生成
     * @param trade_fee     订单总金额，单位是：分
     * @param refund_fee    退款金额，单位是：分
     * @return 结果xml解析后的map，返回内容项请参考：https://pay.weixin.qq.com/wiki/doc/api/jsapi
     * .php?chapter=9_4
     * @throws Exception
     */
    public static TreeMap<String, String> refundPartial(String out_trade_no, String out_refund_no, String trade_fee, String refund_fee) {
        TreeMap<String, String> rm = new TreeMap<String, String>();
        try {
            InputStream is = WxUtils.class.getResourceAsStream("apiclient_cert.p12");
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(is, WxUtils.MchId.toCharArray());
            is.close();
            SSLContext sc = SSLContexts.custom().loadKeyMaterial(ks, WxUtils.MchId.toCharArray()).build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sc);
            // CloseableHttpClient hc =
            // HttpClients.custom().setSSLContext(sc).build();
            CloseableHttpClient hc = HttpClients.custom().setSSLSocketFactory(scsf).build();

            TreeMap<String, String> m = new TreeMap<String, String>();
            m.put("appid", WxUtils.AppID);
            m.put("mch_id", WxUtils.MchId);
            m.put("nonce_str", UUIDUtils.generate());
            m.put("out_refund_no", out_refund_no);
            m.put("out_trade_no", out_trade_no);
            m.put("refund_fee", refund_fee);
            m.put("total_fee", trade_fee);
            // m.put("sign_type", "MD5");
            // m.put("refund_fee_type", "CNY");
            // m.put("refund_account", "REFUND_SOURCE_UNSETTLED_FUNDS");//未结算退款
            // m.put("refund_account", "REFUND_SOURCE_RECHARGE_FUNDS");//余额退款

            m = WxUtils.argSign(m);
            Document dom = DocumentHelper.createDocument();
            Element rootElement = dom.addElement("xml");
            Iterator<Map.Entry<String, String>> iter = m.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> ent = iter.next();
                rootElement.addElement(ent.getKey()).addCDATA(ent.getValue());
            }

            String reqXml = dom.asXML();

            log.info(" refund req xml = " + reqXml);
            HttpPost post = new HttpPost("https://api.mch.weixin.qq.com/secapi/pay/refund");
            StringEntity se = new StringEntity(reqXml, ContentType.create("application/xml", Consts.UTF_8));
            post.setEntity(se);
            CloseableHttpResponse chr = hc.execute(post);
            int statusCode = chr.getStatusLine().getStatusCode();
            log.info(" refund req status = " + statusCode);
            if (statusCode == 200) {
                String respXml = EntityUtils.toString(chr.getEntity());
                log.info(" refund respXml = " + respXml);

                Document rdom = DocumentHelper.parseText(respXml);
                Iterator niter = rdom.getRootElement().elements().iterator();
                while (niter.hasNext()) {
                    Node node = (Node) niter.next();
                    rm.put(node.getName(), node.getText());
                }
            }
            chr.close();

        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return rm;
    }

    /**
     * 全额退款
     *
     * @param out_trade_no  需要退款的订单号
     * @param out_refund_no 退款单号，可以使用 订单号_refund 来生成
     * @param trade_fee     订单总金额，单位是：分
     * @return 结果xml解析后的map，返回内容项请参考：https://pay.weixin.qq.com/wiki/doc/api/jsapi
     * .php?chapter=9_4
     * @throws Exception
     */
    public static TreeMap<String, String> refundAll(String out_trade_no, String out_refund_no, String trade_fee) throws Exception {
        return refundPartial(out_trade_no, out_refund_no, trade_fee, trade_fee);
    }

    /**
     * 生成微信回调后的响应信息
     *
     * @param checkOk
     * @param return_msg
     * @return
     */
    public static String paymentCallBackResponse(boolean checkOk, String return_msg) {
        Document dom = DocumentHelper.createDocument();
        Element rootElement = dom.addElement("xml");
        if (checkOk) {
            rootElement.addElement("return_code").addCDATA("SUCCESS");
        } else {
            rootElement.addElement("return_code").addCDATA("FAIL");
        }
        rootElement.addElement("return_msg").addCDATA(StringUtils.empty2DefaultValue(return_msg, ""));
        return dom.asXML();
    }

    /**
     * 支付结果通知的xml解析成map，便于使用
     *
     * @param xml
     * @return 返回项内容请参考：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=
     * 9_7
     */
    public static TreeMap<String, String> parserPaymentCallBack(String xml) {
        TreeMap<String, String> m = new TreeMap<String, String>();
        try {
            Document dom = DocumentHelper2.parseText(xml);
            Iterator niter = dom.getRootElement().elements().iterator();
            while (niter.hasNext()) {
                Node node = (Node) niter.next();
                m.put(node.getName(), node.getText());
            }
        } catch (DocumentException e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return m;
    }

    /**
     * 对需要进行签名的参数进行签名，并将签名结果sign放入map中
     *
     * @param m
     * @return
     */
    public static TreeMap<String, String> argSign(TreeMap<String, String> m) {
        StringBuilder signStrBuilder = new StringBuilder();
        Iterator<Map.Entry<String, String>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> ent = iter.next();
            signStrBuilder.append(ent.getKey()).append("=").append(ent.getValue()).append("&");
        }
        signStrBuilder.append("key").append("=").append(Key);
        String signStr = signStrBuilder.toString();
        log.info("signStr = " + signStr);
        try {

            // m.put("sign", CipherUtils.hexMd5Digest(signStr).toUpperCase());
            m.put("sign", CipherUtils.hexMd5Digest(signStr, "UTF-8").toUpperCase());

        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return m;
    }

    /**
     * 校验签名是否正确
     *
     * @param m
     * @return
     */
    public static boolean checkSign(TreeMap<String, String> m) {
        boolean state = false;
        String oldSign = m.remove("sign");
        StringBuilder signStrBuilder = new StringBuilder();
        Iterator<Map.Entry<String, String>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> ent = iter.next();
            signStrBuilder.append(ent.getKey()).append("=").append(ent.getValue()).append("&");
        }
        signStrBuilder.append("key").append("=").append(Key);
        String signStr = signStrBuilder.toString();
        log.info("checkSign = " + signStr);
        try {
            String newSign = CipherUtils.hexMd5Digest(signStr).toUpperCase();
            m.put("sign", oldSign);
            m.put("calcSign", newSign);
            if (newSign.equals(oldSign)) {
                state = true;
            }
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return state;
    }

    /**
     * @param orderID  本系统产生的订单号
     * @param money    单位为：分
     * @param clientIp 支付端IP地址
     * @param openid   客户微信登录后的openid
     * @param desc     订单内容描述，不能超过128个字符,必须使用一个： - 字符，例如：HYXT平台-知识
     * @return xmlString 下单结果xml
     * @throws Exception
     */
    public static String JsApiPayUnifiedOrder(String orderID, String money, String clientIp, String openid, String desc, String attach) throws Exception {
        TreeMap<String, String> m = new TreeMap<String, String>();
        m.put("appid", AppID);
        m.put("mch_id", MchId);
        m.put("nonce_str", UUIDUtils.generate());
        m.put("body", desc);
        m.put("attach", attach);
        m.put("out_trade_no", orderID);
        m.put("total_fee", StringUtils.multiplyStr(money,"100",0,1));
        m.put("spbill_create_ip", clientIp);
        m.put("notify_url", PaymentCallBack);
        m.put("trade_type", "JSAPI");
        m.put("openid", openid);
        m.put("time_start", DateFormatUtils.getCurrentDateString("yyyyMMddHHmmss"));
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.DAY_OF_YEAR, 2);
        Date date = rightNow.getTime();
        m.put("time_expire", DateFormatUtils.getDateString(date, "yyyyMMddHHmmss"));

        m = argSign(m);

        Document dom = DocumentHelper.createDocument();
        Element rootElement = dom.addElement("xml");
        Iterator<Map.Entry<String, String>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> ent = iter.next();
            rootElement.addElement(ent.getKey()).addCDATA(ent.getValue());
        }

        String reqXml = dom.asXML();
        log.info("reqXml = " + reqXml);
        String rsXml = Request.Post("https://api.mch.weixin.qq.com/pay/unifiedorder").bodyString(reqXml, ContentType.create("application/xml", Consts.UTF_8)).execute().returnContent().asString(StandardCharsets.UTF_8);
        log.info("rsXml = " + rsXml);
        return rsXml;
    }

    /**
     * @desc: 企业付款至个人
     * @author: Weise Ann
     * @date: 2018年2月28日 上午10:52:41
     * 文档：			https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2
     */
    public static TreeMap<String, String> transfers(String orderID, String money, String clientIp, String openid, String desc) {
        TreeMap<String, String> rm = new TreeMap<String, String>();
        try {
            InputStream is = WxUtils.class.getResourceAsStream("apiclient_cert.p12");
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(is, WxUtils.MchId.toCharArray());
            is.close();
            SSLContext sc = SSLContexts.custom().loadKeyMaterial(ks, WxUtils.MchId.toCharArray()).build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sc);
            CloseableHttpClient hc = HttpClients.custom().setSSLSocketFactory(scsf).build();
            TreeMap<String, String> m = new TreeMap<String, String>();
            m.put("mch_appid", AppID);
            m.put("mchid", MchId);
            m.put("nonce_str", UUIDUtils.generate());
            m.put("partner_trade_no", orderID);
            m.put("openid", openid);
            m.put("check_name", "NO_CHECK");
            m.put("amount", money);
            m.put("desc", desc);
            m.put("spbill_create_ip", clientIp);
            m = WxUtils.argSign(m);
            Document dom = DocumentHelper.createDocument();
            Element rootElement = dom.addElement("xml");
            Iterator<Map.Entry<String, String>> iter = m.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> ent = iter.next();
                rootElement.addElement(ent.getKey()).addCDATA(ent.getValue());
            }
            String reqXml = dom.asXML();
            log.info(" refund req xml = " + reqXml);
            HttpPost post = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers");
            StringEntity se = new StringEntity(reqXml, ContentType.create("application/xml", Consts.UTF_8));
            post.setEntity(se);
            CloseableHttpResponse chr = hc.execute(post);
            int statusCode = chr.getStatusLine().getStatusCode();
            log.info("refund response status = " + statusCode);
            if (statusCode == 200) {
                String respXml = EntityUtils.toString(chr.getEntity());
                log.info(" refund respXml = " + respXml);
                Document rdom = DocumentHelper.parseText(respXml);
                Iterator niter = rdom.getRootElement().elements().iterator();
                while (niter.hasNext()) {
                    Node node = (Node) niter.next();
                    rm.put(node.getName(), node.getText());
                }
            }
            chr.close();
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return rm;
    }

    /**
     * 解析统一下单接口返回的xml为map，便于使用
     *
     * @param xml
     * @return 内容项请参考：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_
     * 1
     */
    public static Map<String, String> parserJsApiPayUnifiedOrderResult(String xml) {
        TreeMap<String, String> m = new TreeMap<String, String>();
        try {
            Document dom = DocumentHelper.parseText(xml);
            Iterator niter = dom.getRootElement().elements().iterator();
            while (niter.hasNext()) {
                Node node = (Node) niter.next();
                m.put(node.getName(), node.getText());
            }
        } catch (DocumentException e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
        return m;
    }


    public static void main(String[] arguments) throws Exception {
//		TreeMap<String, String> refundAll = refundPartial("5a9daae25e3c43eb015e3c86ad400028", "5a9daae25e3c43eb015e3c86ad400028_refund111111", "20", "5");
        TreeMap<String, String> refundAll = refundAll("2c91d82b64ca831a0164ca844e1f0000", "2c91d82b64ca831a0164ca844e1f0000_refund", "1");
        if (refundAll.get("err_code_des") != null) {
            System.out.print(new String(refundAll.get("err_code_des").getBytes("ISO8859-1"), StandardCharsets.UTF_8));
        }

    }

    /**
     * @Title WxUtils.java
     * @Description 消息推送测试
     * @author maozhidong
     * @date 2017年9月28日
     */
    public static void sendTemplateMsg() {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        Map<String, Object> firstMap = new HashMap<String, Object>();
        firstMap.put("value", "尊敬的会员，XX项目已购买成功！");
        dataMap.put("first", firstMap);
        Map<String, Object> keywordMap1 = new HashMap<String, Object>();
        keywordMap1.put("value", "2017年9月25日");
        dataMap.put("keyword1", keywordMap1);
        Map<String, Object> keywordMap2 = new HashMap<String, Object>();
        keywordMap2.put("value", "积木乐园年卡");
        dataMap.put("keyword2", keywordMap2);
        Map<String, Object> keywordMap3 = new HashMap<String, Object>();
        keywordMap3.put("value", "500元");
        dataMap.put("keyword3", keywordMap3);
        Map<String, Object> keywordMap4 = new HashMap<String, Object>();
        keywordMap4.put("value", "微信扫码");
        dataMap.put("keyword4", keywordMap4);
        Map<String, Object> keywordMap5 = new HashMap<String, Object>();
        keywordMap5.put("value", "北京-龙旗(玩塾乐园)");
        dataMap.put("keyword5", keywordMap5);

        Map<String, Object> remarkMap = new HashMap<String, Object>();
        remarkMap.put("value", "多谢惠顾，欢迎再次光临！");
        dataMap.put("remark", remarkMap);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("touser", "oiw8R005Uve14imigTB0HWmnQ8RE");
        map.put("template_id", "LcoMIhe97Crm6LHDXCfE6llvuZ4DlRqsQ9a8nTbLi_k");
        map.put("data", dataMap);

        String respContent = HttpClientUtils.doPostJson(WxUtils.SendTemplateMsgUrl, JSON.toJSONString(map));
        System.out.println(respContent);
    }

    /***
     * @param @param fileName   图片的文件名称，不包含路径（不需要写其他路径）
     * @param @param page  		必须是已经发布的小程序存在的页面（否则报错），例如 pages/index/index, 根路径前不要填加 /,不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
     * @param @param scene  	最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     * @param @param width  	二维码的宽度，默认为 430px，最小 280px，最大 1280px
     * @date 2018年10月19日
     * @author Weise Ann
     * 官方文档：					https://developers.weixin.qq.com/miniprogram/dev/api/open-api/qr-code/getWXACodeUnlimit.html
     */

    public static void saveMiniProgramQRCode(String rootPath, String fileName, String page, String scene, int width) {
        // 目标路径
        try {
            String AccessToken = WeiXinJsSdkUtils.getAccessToken();// 获取token
            String qrCodeUrl = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + AccessToken;
            //rootPath = RubbishClearUtil.class.getResource("/").getPath().replaceAll("/WEB-INF/classes/", "") + "/miniProgramImg";
            File qrcodeFile = new File(rootPath);
            if (!qrcodeFile.exists() && !qrcodeFile.isDirectory()) {
                qrcodeFile.mkdirs();
            }
            File qrCode = new File(rootPath + "/" + fileName + ".jpeg");
            if (!qrCode.exists()) {
                qrCode.createNewFile();
                JSONObject reqObj = new JSONObject();
                // 色值
                JSONObject colorObj = new JSONObject();
                colorObj.put("r", "2");
                colorObj.put("g", "167");
                colorObj.put("b", "168");

                reqObj.put("page", page);
                reqObj.put("width", width);
                reqObj.put("scene", scene);
                reqObj.put("auto_color", false);// false 可以自定义颜色
                reqObj.put("line_color", colorObj);

                Request.Post(qrCodeUrl).bodyString(reqObj.toJSONString(), ContentType.APPLICATION_JSON).execute().saveContent(qrCode);
            }
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        }
    }

    /**
     * 全额退款
     *
     * @param id       订单ID
     * @param returnId 退款ID
     * @param money    退款金额
     * @return 成功/失败
     */
    public static boolean returnAll(String id, String returnId, String money) {
        try {
            TreeMap<String, String> refundPartial = refundAll(id, returnId, money);
            if ("SUCCESS".equals(refundPartial.get("return_code"))) {//退款接口通讯成功
                if ("SUCCESS".equals(refundPartial.get("result_code"))) {//退款申请成功
                    return true;
                } else if ("FAIL".equals(refundPartial.get("result_code"))) {
                    return false;
                }
            } else if ("FAIL".equals(refundPartial.get("return_code"))) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 取消部分订单金额
     *
     * @param id          微信订单ID
     * @param returnId    退款订单
     * @param orderMoney  订单总金额
     * @param returnMoney 退款金额
     * @return 成功/失败
     */
    public static boolean refundSectionOrder(String id, String returnId, String orderMoney, String returnMoney) {
        //用户取消订单退款
        try {
            TreeMap<String, String> refundPartial = WxUtils.refundPartial(id, returnId, orderMoney, returnMoney);
            //退款接口通讯成功
            if ("SUCCESS".equals(refundPartial.get("return_code"))) {
                //退款申请成功
                if ("SUCCESS".equals(refundPartial.get("result_code"))) {
                    return true;
                } else if ("FAIL".equals(refundPartial.get("result_code"))) {
                    return false;
                }
            } else if ("FAIL".equals(refundPartial.get("return_code"))) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
