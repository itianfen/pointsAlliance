package com.utils;

/**
 * 常见异常定义
 *
 * @author zhaos
 */
public interface ErrorItem {

    /**
     * 验证码错误
     */
    String VALIDATE_CODE_ERROR = "验证码错误";

    /**
     * 验证码超时
     */
    String VALIDATE_CODE_TIME_OUT = "验证码超时";
    /**
     * 验证码错误
     */
    String VALIDATE_CODE_SUCCESS = "验证码正确";

    /**
     * 验证码发送频繁
     */
    String VALIDATE_CODE_FREQUENTLY = "验证码发送频繁";

    /**
     * 文件大小超过限制
     */
    String FILE_TO_LARGE = "文件大小超过限制";

    /**
     * 该账号已到期
     */
    String TIME_OUT = "该账号已到期";
    /**
     * 权限不足
     */
    String AUTH_TRANSCEND_ERROR = "访问权限不足";

    /**
     * 用户需要登录后访问
     */
    String AUTH_NEED_LOGIN = "用户需要登录后访问";

    /**
     * 账号密码错误
     */
    String LOGIN_ERROR = "错误的登录密码";

    /**
     * 参数不足错误
     */
    String PARAM_ERROR = "错误的请求参数格式";

    /**
     * 删除失败
     */
    String DELETE_ERROR = "删除失败";

    /**
     * 新增失败
     */
    String INSERT_ERROR = "新增失败";

    /**
     * 修改失败
     */
    String UPDATE_ERROR = "修改失败";

    /**
     * 原始密码错误
     */
    String OLD_PASSWORD_ERROR = "原始密码错误";

    /**
     * 该账号已存在
     */
    String SYSTEM_ACCOUNT_IS_USED = "该账号已存在";

    /**
     * 该账号不存在
     */
    String SYSTEM_ACCOUNT_CANNOT_USE = "该账号不存在";

    /**
     * 找不到记录
     */
    String NO_RESULT_ERROR = "找不到记录";

    /**
     * 该会员不存在
     */
    String USER_NOT_EXISTENCE = "该会员不存在";

    /**
     * 必要参数未设置
     */
    String MAST_PARAM_NOT_SET = "必要参数未设置";

    /**
     * 比例超过取值范围
     */
    String RATE_OUT_OF_RANGE = "比例超过取值范围";

    /**
     * 密码错误
     */
    String PASSWORD_ERROR = "密码错误";

    /**
     * 系统错误请重新尝试
     */
    String SYSTEM_ERROR_MSG = "系统错误请重新尝试";

    /**
     * 读取文件失败
     */
    String READ_FILE_FAIL = "读取文件失败";

    /**
     * 账号已被锁定
     */
    String ACCOUNT_HAS_BEEN_LOCK = "账号已被锁定";

    /**
     * 每次导出不可超过1万条记录
     */
    String DATA_TOO_LARGE = "每次导出不可超过1万条记录";

    /**
     * 角色尚未分配菜单
     */
    String ROLE_MENU_NO_SET = "角色尚未分配菜单";

    /**
     * 重复的记录
     */
    String REPEATED_RECORD = "重复的记录";
    /**
     * 该记录无法删除
     */
    String CANT_NOT_BE_DELETED = "该记录无法删除";

    /**
     * 推荐人不存在
     */
    String PARENT_ID_NOT_FOUND = "推荐人不存在";
    /**
     * 获取短信状态错误
     */
    String GET_PHONE_CODE_ERROR = "获取短信状态错误";

    /**
     * 获取短信验证码成功
     */
    String GET_PHONE_CODE_SUCCESS = "获取短信验证码成功";

    /**
     * 积分不足
     */
    String POINT_NOT_ENOUGH = "积分不足";

    /**
     * 升级成功
     */
    String UPGRADE_SUCCESS = "升级成功";

    /**
     * 已经到达最高等级
     */
    String ARRIVE_HIGHEST_LEVEL = "已经到达最高等级";

    /**
     * 微信号已经存在
     */
    String WX_IS_USED = "微信号已经存在";

    /**
     * 您还未绑定微信账号
     */
    String USER_NOT_BIND_WX = "您还未绑定微信账号";

    /**
     * 身份验证错误 请重新登陆
     */
    String PLEASE_LOGIN_AGAIN = "身份验证错误 请重新登陆";

    /**
     * 卡片兑换次数已达上限
     */
    String CARD_EXCHANGE_COUNT_MAX = "卡片兑换次数已达上限";

    /**
     * 信息成功更新
     */
    String GOODS_INFORMATION_UPDATE_SUCCESS = "信息成功更新";

    /**
     * 信息提交成功
     */
    String GOODS_INFORMATION_SUBMIT_SUCCESS = "信息提交成功";

    /**
     * 今日已签到
     */
    String DONT_SIGN_AGAIN = "今日已签到";

    /**
     * 签到成功
     */
    String SIGN_SUCCESS = "签到成功";

    /**
     * 提现申请提交成功
     */
    String WITHDRAW_APPLY_SUCCESS = "提现申请提交成功";

    /**
     * 余额不足 提现失败
     */
    String WITHDRAW_BALANCE_NOT_ENOUGH = "余额不足 提现失败";

    /**
     * TOKEN无效
     */
    String TOKEN_INVALID = "TOKEN无效";

    /**
     * 请先删除该银行下的商品
     */
    String DELETE_CARD_FIRST = "请先删除该银行下的商品";
}
