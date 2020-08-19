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
 * 订单表
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/5 16:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "goods_order")
public class GoodsOrder extends Model<GoodsOrder> implements Serializable {
    public static final String COL_ID = "ID";
    public static final String COL_CREATED_TIME = "CREATED_TIME";
    public static final String COL_CREATOR = "CREATOR";
    public static final String COL_CREATOR_ID = "CREATOR_ID";
    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";
    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    public static final String COL_LAST_UPDATER = "LAST_UPDATER";
    public static final String COL_USER_ID = "USER_ID";
    public static final String COL_USER_NAME = "USER_NAME";
    public static final String COL_USER_PHONE = "USER_PHONE";
    public static final String COL_APPLY_NAME = "APPLY_NAME";
    public static final String COL_APPLY_PHONE = "APPLY_PHONE";
    public static final String COL_APPLY_ID_CARD_NUMBER = "APPLY_ID_CARD_NUMBER";
    public static final String COL_AUDIT_STATE = "AUDIT_STATE";
    public static final String COL_AUDIT_CONTENT = "AUDIT_CONTENT";
    public static final String COL_GOODS_ID = "GOODS_ID";
    public static final String COL_GOODS_NAME = "GOODS_NAME";
    public static final String COL_GOODS_IMG = "GOODS_IMG";
    public static final String COL_REWARD = "REWARD";
    public static final String COL_ODER_DETAIL = "ODER_DETAIL";
    public static final String COL_DELETED = "DELETED";
    public static final String COL_SPARE1 = "SPARE1";
    public static final String COL_SPARE2 = "SPARE2";
    public static final String COL_SPARE3 = "SPARE3";
    public static final String COL_SPARE4 = "SPARE4";
    public static final String COL_SPARE5 = "SPARE5";
    private static final long serialVersionUID = 424022299504193675L;
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
     * 用户ID
     */
    @TableField(value = "USER_ID")
    private String userId;
    /**
     * 用户姓名
     */
    @TableField(value = "USER_NAME")
    private String userName;
    /**
     * 用户手机号
     */
    @TableField(value = "USER_PHONE")
    private String userPhone;
    /**
     * 申请人姓名
     */
    @TableField(value = "APPLY_NAME")
    private String applyName;
    /**
     * 申请人手机号
     */
    @TableField(value = "APPLY_PHONE")
    private String applyPhone;
    /**
     * 申请人身份证号
     */
    @TableField(value = "APPLY_ID_CARD_NUMBER")
    private String applyIdCardNumber;
    /**
     * 审核状态 1申请中 2申请成功
     */
    @TableField(value = "AUDIT_STATE")
    private Integer auditState;
    /**
     * 审核详细说明
     */
    @TableField(value = "AUDIT_CONTENT")
    private String auditContent;
    /**
     * 银行卡ID
     */
    @TableField(value = "GOODS_ID")
    private String goodsId;
    /**
     * 银行卡名字
     */
    @TableField(value = "GOODS_NAME")
    private String goodsName;
    /**
     * 银行卡图片
     */
    @TableField(value = "GOODS_IMG")
    private String goodsImg;
    /**
     * 奖励金
     */
    @TableField(value = "REWARD")
    private BigDecimal reward;
    /**
     * 订单备注
     */
    @TableField(value = "ODER_DETAIL")
    private String oderDetail;
    /**
     * 逻辑删除 0未删除 1 已删除
     */
    @TableField(value = "DELETED")
    private Integer deleted;
    /**
     * 备用字段1
     */
    @TableField(value = "SPARE1")
    private String spare1;
    /**
     * 备用字段1
     */
    @TableField(value = "SPARE2")
    private String spare2;
    /**
     * 备用字段1
     */
    @TableField(value = "SPARE3")
    private String spare3;
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
}