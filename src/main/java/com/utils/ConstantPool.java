package com.utils;

/**
 * @author yangyantong
 */
public class ConstantPool {
    /**
     * 阿里云AccessKey
     */
    public static final String ACCESSKEY = "LTAI4G2eZ6MTfbBscDXFEqfY";
    /**
     * 阿里云Secret
     */
    public static final String SECRET = "6XD6daIR0iaOTaWuHSXr3SFHdDuZ1I";
    /**
     * 状态
     */
    public static final String RESPONSE_STATE = "state";
    /**
     * 消息
     */
    public static final String RESPONSE_MSG = "msg";
    /**
     * 账户名
     */
    public static final String ACCOUNT = "account";
    /**
     * 密码
     */
    public static final String PASSWORD = "password";
    /**
     * 手机
     */
    public static final String PHONE_NUMBER = "phoneNumber";

    /**
     * 手机短信验证码
     */
    public static final String PHONE_CODE = "phoneCode";

    /**
     * 手机验证码类别
     */
    public static final String PHONE_CODE_STATE = "phoneCodeState";

    /**
     * 上级账户
     */
    public static final String PARENT_ID = "parentId";
    /**
     * 角色ID
     */
    public static final String ROLE_ID = "roleId";
    /**
     * 盟主身份
     */
    public static final String COMPANY_ROLE_ID = "3";
    /**
     * 平台管理员身份
     */
    public static final String PLATFORM_ROLE_ID = "1";
    /**
     * 会员身份
     */
    public static final String MEMBER_ROLE_ID = "2";
    /**
     * 平台默认盟主ID为999
     */
    public static final String PLATFORM_COMPANY_ID = "999";
    /**
     * 默认平台ID为999
     */
    public static final String PLATFORM_PLATFORM_ID = "999";
    /**
     * 升级黄金会员需要300万
     */
    public static final String UPGRADE_GOLD_POINT = "3000000";
    /**
     * 升级钻石会员需要500万
     */
    public static final String UPGRADE_DIAMOND_POINT = "5000000";
    /**
     * 微信绑定
     */
    public static final String WX_BIND = "wxBind";
    /**
     * 微信登陆
     */
    public static final String WX_LOGIN = "wxLogin";
    /**
     * 初级盟主等级Id
     */
    public static final String COMPANY_NORMAL_LEVEL = "1";
    /**
     * 高级盟主等级Id
     */
    public static final String COMPANY_ADVANCED_LEVEL = "2";
    /**
     * 特级盟主等级Id
     */
    public static final String COMPANY_SUPER_LEVEL = "3";
    /**
     * 普通会员等级Id
     */
    public static final String MEMBER_NORMAL_LEVEL = "1";
    /**
     * 黄金会员等级Id
     */
    public static final String MEMBER_GOLD_LEVEL = "2";
    /**
     * 钻石会员等级Id
     */
    public static final String MEMBER_DIAMOND_LEVEL = "3";
    /**
     * 直推会员升级流水类型
     */
    public static final String MONEY_UPGRADE_DIRECT = "1";
    /**
     * 间推会员升级流水类型
     */
    public static final String MONEY_UPGRADE_INDIRECT = "2";
    /**
     * 积分兑换流水类型
     */
    public static final String POINT_EXCHANGE = "3";
    /**
     * 会员积分兑换直接推荐
     */
    public static final String MEMBER_EXCHANGE_RECOMMEND_DIRECT = "4";
    /**
     * 会员积分兑换间接推荐
     */
    public static final String MEMBER_EXCHANGE_RECOMMEND_INDIRECT = "5";
    /**
     * 盟主永久收益
     */
    public static final String COMPANY_FOREVER_PROFIT = "6";
    /**
     * 盟主差价收益
     */
    public static final String COMPANY_PRICE_DIFFERENT_PROFIT = "7";
    /**
     * 盟主团队奖
     */
    public static final String COMPANY_TEAM_PROFIT = "8";
    /**
     * 盟主同级兑换奖
     */
    public static final String COMPANY_PEER_EXCHANGE_PROFIT = "9";
    /**
     * 第一次推荐盟主直接奖励
     */
    public static final String FIRST_RECOMMEND_COMPANY = "10";
    /**
     * 盟主二次升级奖励
     */
    public static final String TWICE_RECOMMEND_COMPANY = "11";
    /**
     * 会员升级
     */
    public static final String MEMBER_UPGRADE = "12";
    /**
     * 盟主升级
     */
    public static final String COMPANY_UPGRADE = "13";
    /**
     * 每日签到
     */
    public static final String SIGN_IN = "14";
    /**
     * 提现
     */
    public static final String WITHDRAW = "15";
    /**
     * 订单未支付
     */
    public static final String ORDER_WAIT_PAY = "0";
    /**
     * 订单待审核
     */
    public static final String ORDER_FORM_WAIT_REVIEW = "1";
    /**
     * 订单审核中
     */
    public static final String ORDER_FORM_IN_REVIEW = "2";
    /**
     * 订单审核成功
     */
    public static final String ORDER_FORM_REVIEW_SUCCESS = "3";
    /**
     * 订单审核失败
     */
    public static final String ORDER_FORM_REVIEW_FAIL = "4";
    /**
     * 订单兑换类型
     */
    public static final String ORDER_EXCHANGE_TYPE = "1";
    /**
     * 订单会员升级类型
     */
    public static final String ORDER_MEMBER_UPGRADE_TYPE = "2";
    /**
     * 订单盟主升级类型
     */
    public static final String ORDER_COMPANY_UPGRADE_TYPE = "3";
    /**
     * 订单提现类型
     */
    public static final String ORDER_WITHDRAW_TYPE = "4";
    /**
     * 商品订单审核中
     */
    public static final String GOODS_ORDER_IN_REVIEW = "1";
    /**
     * 商品订单审核成功
     */
    public static final String GOODS_ORDER_REVIEW_SUCCESS = "2";
    /**
     * 官网地址
     */
    public static final String OFFICIAL_SITE = "https://jf.jiangxingnet.com/h5";
    /**
     * 微信注册模板
     */
    public static final String WEI_XIN_REGISTER_TEMPLATE = "blSt2xHp6Q4i50n1z4AKTv1vgYTfi9-pNhyh_qiEo-g";
    /**
     * 微信审核结果模板
     */
    public static final String WEI_XIN_REVIEW_RESULT_TEMPLATE = "zUey5E5PepduK4zEcuf5QDwuW-x7rSCOeET5HPbS468";
    /**
     * 微信登陆模板
     */
    public static final String WEI_XIN_LOGIN_TEMPLATE = "gDgVcvqg3t8c0KtnxivJOoYv8l84SEG4ow_IMal-owo";
    /**
     * 签到消息模板
     */
    public static final String WEI_XIN_SIGN_TEMPLATE = "35TX-JsuNIw1uerTh8ondgoY2LMvPJqfhFASJlKfQ0Q";
}
