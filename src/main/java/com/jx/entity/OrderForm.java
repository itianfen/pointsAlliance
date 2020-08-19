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
 * @date 2020/7/24 14:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order_form")
public class OrderForm extends Model<OrderForm> implements Serializable {
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
    public static final String COL_SPEND_POINT = "SPEND_POINT";
    public static final String COL_AUDIT_STATE = "AUDIT_STATE";
    public static final String COL_AUDIT_CONTENT = "AUDIT_CONTENT";
    public static final String COL_BANK_ID = "BANK_ID";
    public static final String COL_BANK_NAME = "BANK_NAME";
    public static final String COL_BANK_IMG = "BANK_IMG";
    public static final String COL_CARD_ID = "CARD_ID";
    public static final String COL_CARD_NAME = "CARD_NAME";
    public static final String COL_ITEM_TYPE = "ITEM_TYPE";
    public static final String COL_ITEM_CONTENT = "ITEM_CONTENT";
    public static final String COL_GET_MONEY = "GET_MONEY";
    public static final String COL_UNIT_PRICE = "UNIT_PRICE";
    public static final String COL_SERVICE_ID = "SERVICE_ID";
    public static final String COL_SERVICE_NAME = "SERVICE_NAME";
    public static final String COL_SERVICE_NUMBER = "SERVICE_NUMBER";
    public static final String COL_SERVICE_IMG = "SERVICE_IMG";
    public static final String COL_ODER_DETAIL = "ODER_DETAIL";
    public static final String COL_WX_PAYMENT_ID = "WX_PAYMENT_ID";
    public static final String COL_WX_PAYMENT_AMOUNT = "WX_PAYMENT_AMOUNT";
    public static final String COL_DELETED = "DELETED";
    public static final String COL_ORDER_TYPE = "ORDER_TYPE";
    public static final String COL_SPARE2 = "SPARE2";
    public static final String COL_SPARE3 = "SPARE3";
    public static final String COL_SPARE4 = "SPARE4";
    public static final String COL_SPARE5 = "SPARE5";
    private static final long serialVersionUID = -43113127174819353L;
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
     * 花费积分
     */
    @TableField(value = "SPEND_POINT")
    private BigDecimal spendPoint;
    /**
     * 审核详细说明
     */
    @TableField(value = "AUDIT_CONTENT")
    private String auditContent;
    /**
     * 审核状态 1待审核 2审核成功 3审核失败
     */
    @TableField(value = "AUDIT_STATE")
    private Integer auditState;
    /**
     * 银行ID
     */
    @TableField(value = "BANK_ID")
    private String bankId;
    /**
     * 银行名称
     */
    @TableField(value = "BANK_NAME")
    private String bankName;
    /**
     * 银行图片
     */
    @TableField(value = "BANK_IMG")
    private String bankImg;
    /**
     * 银行卡ID
     */
    @TableField(value = "CARD_ID")
    private String cardId;
    /**
     * 银行卡名字
     */
    @TableField(value = "CARD_NAME")
    private String cardName;
    /**
     * 兑换物品类型 1虚拟 2实物
     */
    @TableField(value = "ITEM_TYPE")
    private Integer itemType;
    /**
     * 物品具体内容，卡券密码或实物名称
     */
    @TableField(value = "ITEM_CONTENT")
    private String itemContent;
    /**
     * 获得金钱
     */
    @TableField(value = "GET_MONEY")
    private BigDecimal getMoney;
    /**
     * 兑换时 物品单价 /元万分
     */
    @TableField(value = "UNIT_PRICE")
    private BigDecimal unitPrice;
    /**
     * 客服ID
     */
    @TableField(value = "SERVICE_ID")
    private String serviceId;
    /**
     * 客服名字
     */
    @TableField(value = "SERVICE_NAME")
    private String serviceName;
    /**
     * 客服微信号
     */
    @TableField(value = "SERVICE_NUMBER")
    private String serviceNumber;
    /**
     * 客服二维码
     */
    @TableField(value = "SERVICE_IMG")
    private String serviceImg;
    /**
     * 订单具体牵扯受益人
     */
    @TableField(value = "ODER_DETAIL")
    private String oderDetail;
    /**
     * 微信订单ID
     */
    @TableField(value = "WX_PAYMENT_ID")
    private String wxPaymentId;
    /**
     * 微信支付金额
     */
    @TableField(value = "WX_PAYMENT_AMOUNT")
    private BigDecimal wxPaymentAmount;
    /**
     * 逻辑删除 0未删除 1 已删除
     */
    @TableField(value = "DELETED")
    private Integer deleted;
    /**
     * 备用字段1
     */
    @TableField(value = "ORDER_TYPE")
    private Integer orderType;
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