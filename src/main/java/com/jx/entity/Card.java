package com.jx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 银行卡
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/1 14:55
 */

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "card")
public class Card extends Model<Card> implements Serializable {
    public static final String COL_ID = "ID";
    public static final String COL_CREATED_TIME = "CREATED_TIME";
    public static final String COL_CREATOR = "CREATOR";
    public static final String COL_CREATOR_ID = "CREATOR_ID";
    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";
    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    public static final String COL_LAST_UPDATER = "LAST_UPDATER";
    public static final String COL_NAME = "NAME";
    public static final String COL_MEMBER_NORMAL = "MEMBER_NORMAL";
    public static final String COL_MEMBER_GOLD = "MEMBER_GOLD";
    public static final String COL_MEMBER_DIAMOND = "MEMBER_DIAMOND";
    public static final String COL_SERVICE = "SERVICE";
    public static final String COL_ODDS = "ODDS";
    public static final String COL_LIMIT_LINE = "LIMIT_LINE";
    public static final String COL_EXCHANGE_TYPE = "EXCHANGE_TYPE";
    public static final String COL_EXCHANGE_COUNT = "EXCHANGE_COUNT";
    public static final String COL_DETAIL_CONTENT = "DETAIL_CONTENT";
    public static final String COL_COMPANY_ID = "COMPANY_ID";
    public static final String COL_BANK_NAME = "BANK_NAME";
    public static final String COL_BANK_ID = "BANK_ID";
    public static final String COL_PHONE_QUERY_POINT = "PHONE_QUERY_POINT";
    public static final String COL_SMS_QUERY_POINT = "SMS_QUERY_POINT";
    public static final String COL_PLATFORM_FLOOR_PRICE = "PLATFORM_FLOOR_PRICE";
    public static final String COL_NORMAL_COMPANY_FLOOR_PRICE = "NORMAL_COMPANY_FLOOR_PRICE";
    public static final String COL_ADVANCED_COMPANY_FLOOR_PRICE = "ADVANCED_COMPANY_FLOOR_PRICE";
    public static final String COL_SUPER_COMPANY_FLOOR_PRICE = "SUPER_COMPANY_FLOOR_PRICE";
    public static final String COL_DELETED = "DELETED";
    public static final String COL_SPARE1 = "SPARE1";
    public static final String COL_SPARE2 = "SPARE2";
    public static final String COL_SPARE3 = "SPARE3";
    public static final String COL_SPARE4 = "SPARE4";
    public static final String COL_SPARE5 = "SPARE5";
    private static final long serialVersionUID = -63202976208821694L;
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
     * 普通会员价格(元/万积分)
     */
    @TableField(value = "MEMBER_NORMAL")
    private BigDecimal memberNormal;
    /**
     * 黄金会员价格(元/万积分)
     */
    @TableField(value = "MEMBER_GOLD")
    private BigDecimal memberGold;
    /**
     * 钻石会员价格(元/万积分)
     */
    @TableField(value = "MEMBER_DIAMOND")
    private BigDecimal memberDiamond;
    /**
     * 客服 0虚拟 1实物
     */
    @TableField(value = "SERVICE")
    private Integer service;
    /**
     * 优势
     */
    @TableField(value = "ODDS")
    private String odds;
    /**
     * 启兑单位
     */
    @TableField(value = "LIMIT_LINE")
    private BigDecimal limitLine;
    /**
     * 兑换步骤详情
     */
    @TableField(value = "DETAIL_CONTENT")
    private String detailContent;
    /**
     * 盟主ID
     */
    @TableField(value = "COMPANY_ID")
    private String companyId;
    /**
     * 银行名称
     */
    @TableField(value = "BANK_NAME")
    private String bankName;
    /**
     * 银行ID
     */
    @TableField(value = "BANK_ID")
    private String bankId;
    /**
     * 电话查积分
     */
    @TableField(value = "PHONE_QUERY_POINT")
    private String phoneQueryPoint;
    /**
     * 短信查积分
     */
    @TableField(value = "SMS_QUERY_POINT")
    private String smsQueryPoint;
    /**
     * 平台底价
     */
    @TableField(value = "PLATFORM_FLOOR_PRICE")
    private BigDecimal platformFloorPrice;
    /**
     * 初级盟主底价
     */
    @TableField(value = "NORMAL_COMPANY_FLOOR_PRICE")
    private BigDecimal normalCompanyFloorPrice;
    /**
     * 高级盟主底价
     */
    @TableField(value = "ADVANCED_COMPANY_FLOOR_PRICE")
    private BigDecimal advancedCompanyFloorPrice;
    /**
     * 特级盟主底价
     */
    @TableField(value = "SUPER_COMPANY_FLOOR_PRICE")
    private BigDecimal superCompanyFloorPrice;
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
    /**
     * 兑换限制: 0不限制 1次/每天 2 次/月 3 次/年 4 次/人
     */
    @TableField(value = "EXCHANGE_TYPE")
    private Integer exchangeType;
    /**
     * 限制次数
     */
    @TableField(value = "EXCHANGE_COUNT")
    private Integer exchangeCount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdater() {
        return lastUpdater;
    }

    public void setLastUpdater(String lastUpdater) {
        this.lastUpdater = lastUpdater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMemberNormal() {
        return memberNormal;
    }

    public void setMemberNormal(BigDecimal memberNormal) {
        this.memberNormal = memberNormal;
    }

    public BigDecimal getMemberGold() {
        return memberGold;
    }

    public void setMemberGold(BigDecimal memberGold) {
        this.memberGold = memberGold;
    }

    public BigDecimal getMemberDiamond() {
        return memberDiamond;
    }

    public void setMemberDiamond(BigDecimal memberDiamond) {
        this.memberDiamond = memberDiamond;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public BigDecimal getLimitLine() {
        return limitLine;
    }

    public void setLimitLine(BigDecimal limitLine) {
        this.limitLine = limitLine;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getPhoneQueryPoint() {
        return phoneQueryPoint;
    }

    public void setPhoneQueryPoint(String phoneQueryPoint) {
        this.phoneQueryPoint = phoneQueryPoint;
    }

    public String getSmsQueryPoint() {
        return smsQueryPoint;
    }

    public void setSmsQueryPoint(String smsQueryPoint) {
        this.smsQueryPoint = smsQueryPoint;
    }

    public BigDecimal getPlatformFloorPrice() {
        return platformFloorPrice;
    }

    public void setPlatformFloorPrice(BigDecimal platformFloorPrice) {
        this.platformFloorPrice = platformFloorPrice;
    }

    public BigDecimal getNormalCompanyFloorPrice() {
        return normalCompanyFloorPrice;
    }

    public void setNormalCompanyFloorPrice(BigDecimal normalCompanyFloorPrice) {
        this.normalCompanyFloorPrice = normalCompanyFloorPrice;
    }

    public BigDecimal getAdvancedCompanyFloorPrice() {
        return advancedCompanyFloorPrice;
    }

    public void setAdvancedCompanyFloorPrice(BigDecimal advancedCompanyFloorPrice) {
        this.advancedCompanyFloorPrice = advancedCompanyFloorPrice;
    }

    public BigDecimal getSuperCompanyFloorPrice() {
        return superCompanyFloorPrice;
    }

    public void setSuperCompanyFloorPrice(BigDecimal superCompanyFloorPrice) {
        this.superCompanyFloorPrice = superCompanyFloorPrice;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4;
    }

    public String getSpare5() {
        return spare5;
    }

    public void setSpare5(String spare5) {
        this.spare5 = spare5;
    }

    public Integer getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Integer exchangeType) {
        this.exchangeType = exchangeType;
    }

    public Integer getExchangeCount() {
        return exchangeCount;
    }

    public void setExchangeCount(Integer exchangeCount) {
        this.exchangeCount = exchangeCount;
    }
}