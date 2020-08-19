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
 * 资金明细表 流水表
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/29 16:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "capital_detail")
public class CapitalDetail extends Model<CapitalDetail> implements Serializable {
    public static final String COL_ID = "ID";
    public static final String COL_CREATED_TIME = "CREATED_TIME";
    public static final String COL_CREATOR = "CREATOR";
    public static final String COL_CREATOR_ID = "CREATOR_ID";
    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";
    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    public static final String COL_LAST_UPDATER = "LAST_UPDATER";
    public static final String COL_USER_ID = "USER_ID";
    public static final String COL_CAPITAL_TYPE = "CAPITAL_TYPE";
    public static final String COL_POINTS_DETAIL = "POINTS_DETAIL";
    public static final String COL_MONEY_DETAIL = "MONEY_DETAIL";
    public static final String COL_ORDER_ID = "ORDER_ID";
    public static final String COL_CAPITAL_CONTENT = "CAPITAL_CONTENT";
    public static final String COL_DELETED = "DELETED";
    public static final String COL_SPARE1 = "SPARE1";
    public static final String COL_SPARE2 = "SPARE2";
    public static final String COL_SPARE3 = "SPARE3";
    public static final String COL_SPARE4 = "SPARE4";
    public static final String COL_SPARE5 = "SPARE5";
    private static final long serialVersionUID = -84309410952405924L;
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
     * 流水类型 1直推会员升级收益 2间推会员升级收益
     */
    @TableField(value = "CAPITAL_TYPE")
    private Integer capitalType;
    /**
     * 积分变动
     */
    @TableField(value = "POINTS_DETAIL")
    private BigDecimal pointsDetail;
    /**
     * 金钱变动
     */
    @TableField(value = "MONEY_DETAIL")
    private BigDecimal moneyDetail;
    /**
     * 所关联的订单
     */
    @TableField(value = "ORDER_ID")
    private String orderId;
    /**
     * 流水详细说明
     */
    @TableField(value = "CAPITAL_CONTENT")
    private String capitalContent;
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