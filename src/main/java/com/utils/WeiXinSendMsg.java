package com.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/18 9:38
 */
@Slf4j
public class WeiXinSendMsg {
    /**
     * 签到成功模板
     *
     * @param userName 用户名
     * @param profit   收益金额
     * @param openId   接收消息openId
     */
    public static void signMsg(String userName, String profit, String... openId) {
        String first = "恭喜您,签到成功!";
        String remark = "坚持签到，更多奖励等着您!";
        String[] keywords = {userName, DateFormatUtils.formatDate(new Date()), profit + "元"};
        String[] templates = new String[openId.length];
        for (int i = 0; i < openId.length; i++) {
            templates[i] = createTemplate(openId[i], ConstantPool.WEI_XIN_SIGN_TEMPLATE, ConstantPool.OFFICIAL_SITE, first, remark, keywords);
        }
        sendWeiXinTemplate(templates);
    }


    /**
     * 注册消息模板
     *
     * @param newUserName 新会员名称
     * @param openId      接收消息的openId
     */
    public static void registerMsgBatch(String newUserName, String... openId) {
        String first = "恭喜您，有新的会员加入您的团队！";
        String remark = "您的团队越来越强大了哦，请再接再厉！";
        String[] keywords = {newUserName, DateFormatUtils.formatDate(new Date()), "推荐码注册"};
        String[] templates = new String[openId.length];
        for (int i = 0; i < openId.length; i++) {
            templates[i] = createTemplate(openId[i], ConstantPool.WEI_XIN_REGISTER_TEMPLATE, ConstantPool.OFFICIAL_SITE, first, remark, keywords);
        }
        sendWeiXinTemplate(templates);
    }

    /**
     * 积分兑换审核中模板
     *
     * @param openId 被发送人的openId
     */
    public static void exchangeInReviewMsg(String userName, String... openId) {
        String first = "您的积分兑换订单处理结果如下：";
        String remark = "您的订单正在审核中，审核成功将会通过公众号提醒您！";
        String[] keywords = {userName, "正在审核中", DateFormatUtils.formatDate(new Date())};
        String[] templates = new String[openId.length];
        for (int i = 0; i < openId.length; i++) {
            templates[i] = createTemplate(openId[i], ConstantPool.WEI_XIN_REVIEW_RESULT_TEMPLATE, ConstantPool.OFFICIAL_SITE, first, remark, keywords);
        }
        sendWeiXinTemplate(templates);
    }

    /**
     * 积分兑换审核成功模板
     *
     * @param openId 被发送人的openId
     */
    public static void exchangeReviewSuccessMsg(String userName, String... openId) {
        String first = "您的积分兑换订单处理结果如下：";
        String remark = "您的订单已经审核成功！";
        String[] keywords = {userName, "审核成功", DateFormatUtils.formatDate(new Date())};
        String[] templates = new String[openId.length];
        for (int i = 0; i < openId.length; i++) {
            templates[i] = createTemplate(openId[i], ConstantPool.WEI_XIN_REVIEW_RESULT_TEMPLATE, ConstantPool.OFFICIAL_SITE, first, remark, keywords);
        }
        sendWeiXinTemplate(templates);
    }

    /**
     * 微信登陆通知模板
     *
     * @param phone  登陆账号
     * @param openId 接收人openId
     */
    public static void loginMsg(String phone, String... openId) {
        String first = "您好，您已经成功登陆您的账号！";
        String remark = "感谢使用，请注意账号安全！\n若非本人操作，请尽快修改密码！";
        String[] keywords = {phone, DateFormatUtils.formatDate(new Date())};
        String[] templates = new String[openId.length];
        for (int i = 0; i < openId.length; i++) {
            templates[i] = createTemplate(openId[i], ConstantPool.WEI_XIN_LOGIN_TEMPLATE, ConstantPool.OFFICIAL_SITE, first, remark, keywords);
        }
        sendWeiXinTemplate(templates);
    }


    /**
     * 发送模板
     *
     * @param templates 通过创建方法创建的模板数据
     */
    public static void sendWeiXinTemplate(String... templates) {
        String sendUrl = WxUtils.SendTemplateMsgUrl.replace("{access_token}", WeiXinJsSdkUtils.accessToken);
        for (String template : templates) {
            HttpClientUtils.doPostJson(sendUrl, template);
        }

    }

    /**
     * 创建消息模板
     *
     * @param openId     被发送人的openId
     * @param templateId 模板Id
     * @param url        点击跳转地址
     * @param first      消息头
     * @param remark     消息尾
     * @param keywords   关键字
     * @return JSON template
     */
    public static String createTemplate(String openId, String templateId, String url, String first, String remark, String... keywords) {
        Map<String, Object> dataMap = new HashMap<String, Object>(keywords.length + 2);
        Map<String, Object> firstMap = new HashMap<String, Object>(1);
        firstMap.put("value", first);
        dataMap.put("first", firstMap);
        Map<String, Object> remarkMap = new HashMap<String, Object>(1);
        remarkMap.put("value", remark);
        dataMap.put("remark", remarkMap);
        for (int i = 0; i < keywords.length; i++) {
            Map<String, Object> keyword = new HashMap<>(1);
            keyword.put("value", keywords[i]);
            dataMap.put("keyword" + (i + 1), keyword);
        }
        Map<String, Object> map = new HashMap<>(4);
        map.put("touser", openId);
        map.put("template_id", templateId);
        map.put("url", url);
        map.put("data", dataMap);
        return JSONObject.toJSONString(map);
    }

    public static void main(String[] args) {
        String[] ids = {"asdasd", "asdqwd", "asdj", "asdolasd"};
        registerMsgBatch("张三", ids);
    }
}
