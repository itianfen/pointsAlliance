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
 * 商品表
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/5 10:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "goods")
public class Goods extends Model<Goods> implements Serializable {
    public static final String COL_ID = "ID";
    public static final String COL_CREATED_TIME = "CREATED_TIME";
    public static final String COL_CREATOR = "CREATOR";
    public static final String COL_CREATOR_ID = "CREATOR_ID";
    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";
    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    public static final String COL_LAST_UPDATER = "LAST_UPDATER";
    public static final String COL_NAME = "NAME";
    public static final String COL_ICON = "ICON";
    public static final String COL_REWARD = "REWARD";
    public static final String COL_TYPE = "TYPE";
    public static final String COL_RATE_MONTH = "RATE_MONTH";
    public static final String COL_DATE_LIMIT_MAX = "DATE_LIMIT_MAX";
    public static final String COL_DATE_LIMIT_MIN = "DATE_LIMIT_MIN";
    public static final String COL_RATE_SUCCESS = "RATE_SUCCESS";
    public static final String COL_APPLY_COUNT = "APPLY_COUNT";
    public static final String COL_NEED_DATA = "NEED_DATA";
    public static final String COL_APPLY_CONDITION = "APPLY_CONDITION";
    public static final String COL_MAX_LOAN_CARD = "MAX_LOAN_CARD";
    public static final String COL_MAX_LOAN = "MAX_LOAN";
    public static final String COL_TARGET_LINK = "TARGET_LINK";
    public static final String COL_CARD_IMAGE = "CARD_IMAGE";
    public static final String COL_DELETED = "DELETED";
    public static final String COL_SPARE1 = "SPARE1";
    public static final String COL_SPARE2 = "SPARE2";
    public static final String COL_SPARE3 = "SPARE3";
    public static final String COL_SPARE4 = "SPARE4";
    public static final String COL_SPARE5 = "SPARE5";
    private static final long serialVersionUID = 179425678833622444L;
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
     * 名称
     */
    @TableField(value = "NAME")
    private String name;
    /**
     * 图片
     */
    @TableField(value = "ICON")
    private String icon;
    /**
     * 奖励金
     */
    @TableField(value = "REWARD")
    private BigDecimal reward;
    /**
     * 类型 0借款产品 1信用卡产品
     */
    @TableField(value = "TYPE")
    private Integer type;
    /**
     * 月利率
     */
    @TableField(value = "RATE_MONTH")
    private BigDecimal rateMonth;
    /**
     * 借贷周期(最高)
     */
    @TableField(value = "DATE_LIMIT_MAX")
    private Integer dateLimitMax;
    /**
     * 借贷周期(最低)
     */
    @TableField(value = "DATE_LIMIT_MIN")
    private Integer dateLimitMin;
    /**
     * 通过率
     */
    @TableField(value = "RATE_SUCCESS")
    private BigDecimal rateSuccess;
    /**
     * 已申请人数(虚拟)
     */
    @TableField(value = "APPLY_COUNT")
    private Integer applyCount;
    /**
     * 需要资料
     */
    @TableField(value = "NEED_DATA")
    private String needData;
    /**
     * 申请条件
     */
    @TableField(value = "APPLY_CONDITION")
    private String applyCondition;
    /**
     * 信用卡借款额度
     */
    @TableField(value = "MAX_LOAN_CARD")
    private Integer maxLoanCard;
    /**
     * 最高额度
     */
    @TableField(value = "MAX_LOAN")
    private Integer maxLoan;
    /**
     * 目标链接
     */
    @TableField(value = "TARGET_LINK")
    private String targetLink;
    /**
     * 信用卡图片
     */
    @TableField(value = "CARD_IMAGE")
    private String cardImage;
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