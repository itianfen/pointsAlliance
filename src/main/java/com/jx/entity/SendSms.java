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
import java.util.Date;

/**
 * 短信验证码表
 *
 * @author yangyantong
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "send_sms")
public class SendSms extends Model<SendSms> implements Serializable {
    private static final long serialVersionUID = -83960384031024728L;
    /**
     * 短信验证码表
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 验证码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 状态1登录2注册3修改登录密码4修改交易密码5设置交易密码6申请成为队长7申请成为经理8申请成为代驾司机9app登陆
     */
    @TableField(value = "state")
    private String state;

    /**
     * 过期时间
     */
    @TableField(value = "end_time")
    private String endTime;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private Date createdTime;
}