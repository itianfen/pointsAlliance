package com.jx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 系统用户表
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/28 15:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class SysUser extends Model<SysUser> implements Serializable {
    public static final String COL_ID = "ID";
    public static final String COL_CREATED_TIME = "CREATED_TIME";
    public static final String COL_CREATOR = "CREATOR";
    public static final String COL_CREATOR_ID = "CREATOR_ID";
    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";
    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    public static final String COL_LAST_UPDATER = "LAST_UPDATER";
    public static final String COL_NAME = "NAME";
    public static final String COL_PHONE = "PHONE";
    public static final String COL_ACCOUNT = "ACCOUNT";
    public static final String COL_PASSWORD = "PASSWORD";
    public static final String COL_USER_STATE = "USER_STATE";
    public static final String COL_ROLE_ID = "ROLE_ID";
    public static final String COL_ROLE_NAME = "ROLE_NAME";
    public static final String COL_PARENT_ID = "PARENT_ID";
    public static final String COL_COMPANY_ID = "COMPANY_ID";
    public static final String COL_MEMBER_LEVEL = "MEMBER_LEVEL";
    public static final String COL_COMPANY_LEVEL = "COMPANY_LEVEL";
    public static final String COL_BALANCE = "BALANCE";
    public static final String COL_CUMULATIVE_PROFIT = "CUMULATIVE_PROFIT";
    public static final String COL_CUMULATIVE_POINT = "CUMULATIVE_POINT";
    public static final String COL_DELETED = "DELETED";
    public static final String COL_OPEN_ID = "OPEN_ID";
    public static final String COL_INVITE_CODE = "INVITE_CODE";
    public static final String COL_HEAD_URL = "HEAD_URL";
    public static final String COL_SPARE4 = "SPARE4";
    public static final String COL_SPARE5 = "SPARE5";
    private static final long serialVersionUID = -93216816613727738L;
    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private String id;
    /**
     * 创建时间
     */
    @TableField(value = "CREATED_TIME")
    private Date createdTime;
    /**
     * 创建人
     */
    @TableField(value = "CREATOR")
    private String creator;
    /**
     * 创建人ID
     */
    @TableField(value = "CREATOR_ID")
    private String creatorId;
    /**
     * 修改人ID
     */
    @TableField(value = "LAST_UPDATE_ID")
    private String lastUpdateId;
    /**
     * 最后修改时间
     */
    @TableField(value = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;
    /**
     * 最后修改人
     */
    @TableField(value = "LAST_UPDATER")
    private String lastUpdater;
    /**
     * 姓名
     */
    @TableField(value = "NAME")
    private String name;
    /**
     * 手机号
     */
    @TableField(value = "PHONE")
    private String phone;
    /**
     * 登录账号
     */
    @TableField(value = "ACCOUNT")
    private String account;
    /**
     * 登录密码
     */
    @TableField(value = "PASSWORD")
    private String password;
    /**
     * 用户状态 1可用 0锁定
     */
    @TableField(value = "USER_STATE")
    private Integer userState;
    /**
     * 角色ID
     */
    @TableField(value = "ROLE_ID")
    private String roleId;
    /**
     * 角色名称(随角色名称修改而修改）
     */
    @TableField(value = "ROLE_NAME")
    private String roleName;
    /**
     * 上级ID
     */
    @TableField(value = "PARENT_ID")
    private String parentId;
    /**
     * 盟主ID
     */
    @TableField(value = "COMPANY_ID")
    private String companyId;
    /**
     * 会员等级 1 普通 2 黄金 3钻石
     */
    @TableField(value = "MEMBER_LEVEL")
    private Integer memberLevel;
    /**
     * 盟主等级 1初级 2高级 3特级
     */
    @TableField(value = "COMPANY_LEVEL")
    private Integer companyLevel;
    /**
     * 会员余额
     */
    @TableField(value = "BALANCE")
    private BigDecimal balance;
    /**
     * 累计收益
     */
    @TableField(value = "CUMULATIVE_PROFIT")
    private BigDecimal cumulativeProfit;
    /**
     * 累计兑换积分 万为单位
     */
    @TableField(value = "CUMULATIVE_POINT")
    private BigDecimal cumulativePoint;
    /**
     * 逻辑删除 0未删除 1 已删除
     */
    @TableField(value = "DELETED")
    private Integer deleted;
    /**
     * 微信ID
     */
    @TableField(value = "OPEN_ID")
    private String openId;
    /**
     * 推荐码
     */
    @TableField(value = "INVITE_CODE")
    private String inviteCode;
    /**
     * 备用字段1
     */
    @TableField(value = "SPARE4")
    private String spare4;
    /**
     * 备用字段1
     */
    @TableField(value = "SPARE5")
    private String spare5;
    /**
     * 用户头像
     */
    @TableField(value = "HEAD_URL")
    private String headUrl;
}