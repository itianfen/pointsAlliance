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
 * 系统价格设置表
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/24 14:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "system_set")
public class SystemSet extends Model<SystemSet> implements Serializable {
    private static final long serialVersionUID = -73526245684494232L;
    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private String id;

    /**
     * 盟主ID
     */
    @TableId(value = "COMPANY_ID", type = IdType.INPUT)
    private String companyId;

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
     * 黄金会员价格
     */
    @TableField(value = "MEMBER_UPGRADE_GOLD_PRICE")
    private BigDecimal memberUpgradeGoldPrice;

    /**
     * 钻石会员价格
     */
    @TableField(value = "MEMBER_UPGRADE_DIAMOND_PRICE")
    private BigDecimal memberUpgradeDiamondPrice;

    /**
     * 普通会员金钱升级直推
     */
    @TableField(value = "MEMBER_NORMAL_MONEY_UPGRADE_DIRECT")
    private BigDecimal memberNormalMoneyUpgradeDirect;

    /**
     * 普通会员金钱升级间推
     */
    @TableField(value = "MEMBER_NORMAL_MONEY_UPGRADE_INDIRECT")
    private BigDecimal memberNormalMoneyUpgradeIndirect;

    /**
     * 普通会员积分消费直推
     */
    @TableField(value = "MEMBER_NORMAL_EXCHANGE_POINT_DIRECT")
    private BigDecimal memberNormalExchangePointDirect;

    /**
     * 普通会员积分消费间推
     */
    @TableField(value = "MEMBER_NORMAL_EXCHANGE_POINT_INDIRECT")
    private BigDecimal memberNormalExchangePointIndirect;

    /**
     * 黄金会员金钱升级直推
     */
    @TableField(value = "MEMBER_GOLD_MONEY_UPGRADE_DIRECT")
    private BigDecimal memberGoldMoneyUpgradeDirect;

    /**
     * 黄金会员金钱升级间推
     */
    @TableField(value = "MEMBER_GOLD_MONEY_UPGRADE_INDIRECT")
    private BigDecimal memberGoldMoneyUpgradeIndirect;

    /**
     * 黄金会员积分消费直推
     */
    @TableField(value = "MEMBER_GOLD_EXCHANGE_POINT_DIRECT")
    private BigDecimal memberGoldExchangePointDirect;

    /**
     * 黄金会员积分消费间推
     */
    @TableField(value = "MEMBER_GOLD_EXCHANGE_POINT_INDIRECT")
    private BigDecimal memberGoldExchangePointIndirect;

    /**
     * 钻石会员金钱升级直推
     */
    @TableField(value = "MEMBER_DIAMOND_MONEY_UPGRADE_DIRECT")
    private BigDecimal memberDiamondMoneyUpgradeDirect;

    /**
     * 钻石会员金钱升级间推
     */
    @TableField(value = "MEMBER_DIAMOND_MONEY_UPGRADE_INDIRECT")
    private BigDecimal memberDiamondMoneyUpgradeIndirect;

    /**
     * 钻石会员积分消费直推
     */
    @TableField(value = "MEMBER_DIAMOND_EXCHANGE_POINT_DIRECT")
    private BigDecimal memberDiamondExchangePointDirect;

    /**
     * 钻石会员积分消费间推
     */
    @TableField(value = "MEMBER_DIAMOND_EXCHANGE_POINT_INDIRECT")
    private BigDecimal memberDiamondExchangePointIndirect;

    /**
     * 普通会员兑换价格 元/万积分
     */
    @TableField(value = "MEMBER_NORMAL_EXCHANGE_UNIT_PRICE")
    private BigDecimal memberNormalExchangeUnitPrice;

    /**
     * 黄金会员兑换价格 元/万积分
     */
    @TableField(value = "MEMBER_GOLD_EXCHANGE_UNIT_PRICE")
    private BigDecimal memberGoldExchangeUnitPrice;

    /**
     * 钻石会员兑换价格 元/万积分
     */
    @TableField(value = "MEMBER_DIAMOND_EXCHANGE_UNIT_PRICE")
    private BigDecimal memberDiamondExchangeUnitPrice;

    /**
     * 初级盟主价格
     */
    @TableField(value = "COMPANY_NORMAL_UPGRADE_PRICE")
    private BigDecimal companyNormalUpgradePrice;

    /**
     * 高级盟主价格
     */
    @TableField(value = "COMPANY_ADVANCED_UPGRADE_PRICE")
    private BigDecimal companyAdvancedUpgradePrice;

    /**
     * 特级盟主价格
     */
    @TableField(value = "COMPANY_SUPER_UPGRADE_PRICE")
    private BigDecimal companySuperUpgradePrice;

    /**
     * 初级盟主会员金钱升级直推收益
     */
    @TableField(value = "COMPANY_NORMAL_MONEY_UPGRADE_DIRECT")
    private BigDecimal companyNormalMoneyUpgradeDirect;

    /**
     * 高级盟主会员金钱升级直推收益
     */
    @TableField(value = "COMPANY_ADVANCED_MONEY_UPGRADE_DIRECT")
    private BigDecimal companyAdvancedMoneyUpgradeDirect;

    /**
     * 特级盟主会员金钱升级直推收益
     */
    @TableField(value = "COMPANY_SUPER_MONEY_UPGRADE_DIRECT")
    private BigDecimal companySuperMoneyUpgradeDirect;

    /**
     * 初级盟主会员金钱升级间推收益
     */
    @TableField(value = "COMPANY_NORMAL_MONEY_UPGRADE_INDIRECT")
    private BigDecimal companyNormalMoneyUpgradeIndirect;

    /**
     * 高级盟主会员金钱升级间推收益
     */
    @TableField(value = "COMPANY_ADVANCED_MONEY_UPGRADE_INDIRECT")
    private BigDecimal companyAdvancedMoneyUpgradeIndirect;

    /**
     * 特级盟主会员金钱升级间推收益
     */
    @TableField(value = "COMPANY_SUPER_MONEY_UPGRADE_INDIRECT")
    private BigDecimal companySuperMoneyUpgradeIndirect;

    /**
     * 初级盟主收益比
     */
    @TableField(value = "COMPANY_NORMAL_PROFIT_RATE")
    private BigDecimal companyNormalProfitRate;

    /**
     * 高级盟主收益比
     */
    @TableField(value = "COMPANY_ADVANCED_PROFIT_RATE")
    private BigDecimal companyAdvancedProfitRate;

    /**
     * 特级盟主收益比
     */
    @TableField(value = "COMPANY_SUPER_PROFIT_RATE")
    private BigDecimal companySuperProfitRate;

    /**
     * 初级盟主同级兑换奖
     */
    @TableField(value = "COMPANY_NORMAL_PEER_EXCHANGE")
    private BigDecimal companyNormalPeerExchange;

    /**
     * 高级盟主同级兑换奖
     */
    @TableField(value = "COMPANY_ADVANCED_PEER_EXCHANGE")
    private BigDecimal companyAdvancedPeerExchange;

    /**
     * 特级盟主同级兑换奖
     */
    @TableField(value = "COMPANY_SUPER_PEER_EXCHANGE")
    private BigDecimal companySuperPeerExchange;

    /**
     * 初级盟主团队奖
     */
    @TableField(value = "COMPANY_NORMAL_TEAM_PROFIT")
    private BigDecimal companyNormalTeamProfit;

    /**
     * 高级盟主团队奖
     */
    @TableField(value = "COMPANY_ADVANCED_TEAM_PROFIT")
    private BigDecimal companyAdvancedTeamProfit;

    /**
     * 特级盟主团队奖
     */
    @TableField(value = "COMPANY_SUPER_TEAM_PROFIT")
    private BigDecimal companySuperTeamProfit;

    /**
     * 初级盟主最高价
     */
    @TableField(value = "COMPANY_NORMAL_HIGHEST_PRICE")
    private BigDecimal companyNormalHighestPrice;

    /**
     * 高级盟主最高价
     */
    @TableField(value = "COMPANY_ADVANCED_HIGHEST_PRICE")
    private BigDecimal companyAdvancedHighestPrice;

    /**
     * 特级盟主最高价
     */
    @TableField(value = "COMPANY_SUPER_HIGHEST_PRICE")
    private BigDecimal companySuperHighestPrice;

    /**
     * 推荐初级盟主奖励
     */
    @TableField(value = "RECOMMEND_NORMAL_COMPANY_REWARD")
    private BigDecimal recommendNormalCompanyReward;

    /**
     * 推荐高级盟主奖励
     */
    @TableField(value = "RECOMMEND_ADVANCED_COMPANY_REWARD")
    private BigDecimal recommendAdvancedCompanyReward;

    /**
     * 推荐特级盟主奖励
     */
    @TableField(value = "RECOMMEND_SUPER_COMPANY_REWARD")
    private BigDecimal recommendSuperCompanyReward;

    /**
     * 初级盟主二次升级奖励
     */
    @TableField(value = "NORMAL_COMPANY_TWICE_UPGRADE_REWARD")
    private BigDecimal normalCompanyTwiceUpgradeReward;

    /**
     * 高级盟主二次升级奖励
     */
    @TableField(value = "ADVANCED_COMPANY_TWICE_UPGRADE_REWARD")
    private BigDecimal advancedCompanyTwiceUpgradeReward;

    /**
     * 平台ID
     */
    @TableField(value = "PLATFORM_ID")
    private String platformId;

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
     * 主键
     */
    public static final String COL_ID = "ID";
    /**
     * 盟主ID
     */
    public static final String COL_COMPANY_ID = "COMPANY_ID";
    /**
     * 创建时间
     */
    public static final String COL_CREATED_TIME = "CREATED_TIME";
    /**
     * 创建人
     */
    public static final String COL_CREATOR = "CREATOR";
    /**
     * 创建人ID
     */
    public static final String COL_CREATOR_ID = "CREATOR_ID";
    /**
     * 修改人ID
     */
    public static final String COL_LAST_UPDATE_ID = "LAST_UPDATE_ID";
    /**
     * 最后修改时间
     */
    public static final String COL_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
    /**
     * 最后修改人
     */
    public static final String COL_LAST_UPDATER = "LAST_UPDATER";
    /**
     * 黄金会员价格
     */
    public static final String COL_MEMBER_UPGRADE_GOLD_PRICE = "MEMBER_UPGRADE_GOLD_PRICE";
    /**
     * 钻石会员价格
     */
    public static final String COL_MEMBER_UPGRADE_DIAMOND_PRICE = "MEMBER_UPGRADE_DIAMOND_PRICE";
    /**
     * 普通会员金钱升级直推
     */
    public static final String COL_MEMBER_NORMAL_MONEY_UPGRADE_DIRECT = "MEMBER_NORMAL_MONEY_UPGRADE_DIRECT";
    /**
     * 普通会员金钱升级间推
     */
    public static final String COL_MEMBER_NORMAL_MONEY_UPGRADE_INDIRECT = "MEMBER_NORMAL_MONEY_UPGRADE_INDIRECT";
    /**
     * 普通会员积分消费直推
     */
    public static final String COL_MEMBER_NORMAL_EXCHANGE_POINT_DIRECT = "MEMBER_NORMAL_EXCHANGE_POINT_DIRECT";
    /**
     * 普通会员积分消费间推
     */
    public static final String COL_MEMBER_NORMAL_EXCHANGE_POINT_INDIRECT = "MEMBER_NORMAL_EXCHANGE_POINT_INDIRECT";
    /**
     * 黄金会员金钱升级直推
     */
    public static final String COL_MEMBER_GOLD_MONEY_UPGRADE_DIRECT = "MEMBER_GOLD_MONEY_UPGRADE_DIRECT";
    /**
     * 黄金会员金钱升级间推
     */
    public static final String COL_MEMBER_GOLD_MONEY_UPGRADE_INDIRECT = "MEMBER_GOLD_MONEY_UPGRADE_INDIRECT";
    /**
     * 黄金会员积分消费直推
     */
    public static final String COL_MEMBER_GOLD_EXCHANGE_POINT_DIRECT = "MEMBER_GOLD_EXCHANGE_POINT_DIRECT";
    /**
     * 黄金会员积分消费间推
     */
    public static final String COL_MEMBER_GOLD_EXCHANGE_POINT_INDIRECT = "MEMBER_GOLD_EXCHANGE_POINT_INDIRECT";
    /**
     * 钻石会员金钱升级直推
     */
    public static final String COL_MEMBER_DIAMOND_MONEY_UPGRADE_DIRECT = "MEMBER_DIAMOND_MONEY_UPGRADE_DIRECT";
    /**
     * 钻石会员金钱升级间推
     */
    public static final String COL_MEMBER_DIAMOND_MONEY_UPGRADE_INDIRECT = "MEMBER_DIAMOND_MONEY_UPGRADE_INDIRECT";
    /**
     * 钻石会员积分消费直推
     */
    public static final String COL_MEMBER_DIAMOND_EXCHANGE_POINT_DIRECT = "MEMBER_DIAMOND_EXCHANGE_POINT_DIRECT";
    /**
     * 钻石会员积分消费间推
     */
    public static final String COL_MEMBER_DIAMOND_EXCHANGE_POINT_INDIRECT = "MEMBER_DIAMOND_EXCHANGE_POINT_INDIRECT";
    /**
     * 普通会员兑换价格 元/万积分
     */
    public static final String COL_MEMBER_NORMAL_EXCHANGE_UNIT_PRICE = "MEMBER_NORMAL_EXCHANGE_UNIT_PRICE";
    /**
     * 黄金会员兑换价格 元/万积分
     */
    public static final String COL_MEMBER_GOLD_EXCHANGE_UNIT_PRICE = "MEMBER_GOLD_EXCHANGE_UNIT_PRICE";
    /**
     * 钻石会员兑换价格 元/万积分
     */
    public static final String COL_MEMBER_DIAMOND_EXCHANGE_UNIT_PRICE = "MEMBER_DIAMOND_EXCHANGE_UNIT_PRICE";
    /**
     * 初级盟主价格
     */
    public static final String COL_COMPANY_NORMAL_UPGRADE_PRICE = "COMPANY_NORMAL_UPGRADE_PRICE";
    /**
     * 高级盟主价格
     */
    public static final String COL_COMPANY_ADVANCED_UPGRADE_PRICE = "COMPANY_ADVANCED_UPGRADE_PRICE";
    /**
     * 特级盟主价格
     */
    public static final String COL_COMPANY_SUPER_UPGRADE_PRICE = "COMPANY_SUPER_UPGRADE_PRICE";
    /**
     * 初级盟主会员金钱升级直推收益
     */
    public static final String COL_COMPANY_NORMAL_MONEY_UPGRADE_DIRECT = "COMPANY_NORMAL_MONEY_UPGRADE_DIRECT";
    /**
     * 高级盟主会员金钱升级直推收益
     */
    public static final String COL_COMPANY_ADVANCED_MONEY_UPGRADE_DIRECT = "COMPANY_ADVANCED_MONEY_UPGRADE_DIRECT";
    /**
     * 特级盟主会员金钱升级直推收益
     */
    public static final String COL_COMPANY_SUPER_MONEY_UPGRADE_DIRECT = "COMPANY_SUPER_MONEY_UPGRADE_DIRECT";
    /**
     * 初级盟主会员金钱升级间推收益
     */
    public static final String COL_COMPANY_NORMAL_MONEY_UPGRADE_INDIRECT = "COMPANY_NORMAL_MONEY_UPGRADE_INDIRECT";
    /**
     * 高级盟主会员金钱升级间推收益
     */
    public static final String COL_COMPANY_ADVANCED_MONEY_UPGRADE_INDIRECT = "COMPANY_ADVANCED_MONEY_UPGRADE_INDIRECT";
    /**
     * 特级盟主会员金钱升级间推收益
     */
    public static final String COL_COMPANY_SUPER_MONEY_UPGRADE_INDIRECT = "COMPANY_SUPER_MONEY_UPGRADE_INDIRECT";
    /**
     * 初级盟主收益比
     */
    public static final String COL_COMPANY_NORMAL_PROFIT_RATE = "COMPANY_NORMAL_PROFIT_RATE";
    /**
     * 高级盟主收益比
     */
    public static final String COL_COMPANY_ADVANCED_PROFIT_RATE = "COMPANY_ADVANCED_PROFIT_RATE";
    /**
     * 特级盟主收益比
     */
    public static final String COL_COMPANY_SUPER_PROFIT_RATE = "COMPANY_SUPER_PROFIT_RATE";
    /**
     * 初级盟主同级兑换奖
     */
    public static final String COL_COMPANY_NORMAL_PEER_EXCHANGE = "COMPANY_NORMAL_PEER_EXCHANGE";
    /**
     * 高级盟主同级兑换奖
     */
    public static final String COL_COMPANY_ADVANCED_PEER_EXCHANGE = "COMPANY_ADVANCED_PEER_EXCHANGE";
    /**
     * 特级盟主同级兑换奖
     */
    public static final String COL_COMPANY_SUPER_PEER_EXCHANGE = "COMPANY_SUPER_PEER_EXCHANGE";
    /**
     * 初级盟主团队奖
     */
    public static final String COL_COMPANY_NORMAL_TEAM_PROFIT = "COMPANY_NORMAL_TEAM_PROFIT";
    /**
     * 高级盟主团队奖
     */
    public static final String COL_COMPANY_ADVANCED_TEAM_PROFIT = "COMPANY_ADVANCED_TEAM_PROFIT";
    /**
     * 特级盟主团队奖
     */
    public static final String COL_COMPANY_SUPER_TEAM_PROFIT = "COMPANY_SUPER_TEAM_PROFIT";
    /**
     * 初级盟主最高价
     */
    public static final String COL_COMPANY_NORMAL_HIGHEST_PRICE = "COMPANY_NORMAL_HIGHEST_PRICE";
    /**
     * 高级盟主最高价
     */
    public static final String COL_COMPANY_ADVANCED_HIGHEST_PRICE = "COMPANY_ADVANCED_HIGHEST_PRICE";
    /**
     * 特级盟主最高价
     */
    public static final String COL_COMPANY_SUPER_HIGHEST_PRICE = "COMPANY_SUPER_HIGHEST_PRICE";
    /**
     * 推荐初级盟主奖励
     */
    public static final String COL_RECOMMEND_NORMAL_COMPANY_REWARD = "RECOMMEND_NORMAL_COMPANY_REWARD";
    /**
     * 推荐高级盟主奖励
     */
    public static final String COL_RECOMMEND_ADVANCED_COMPANY_REWARD = "RECOMMEND_ADVANCED_COMPANY_REWARD";
    /**
     * 推荐特级盟主奖励
     */
    public static final String COL_RECOMMEND_SUPER_COMPANY_REWARD = "RECOMMEND_SUPER_COMPANY_REWARD";
    /**
     * 初级盟主二次升级奖励
     */
    public static final String COL_NORMAL_COMPANY_TWICE_UPGRADE_REWARD = "NORMAL_COMPANY_TWICE_UPGRADE_REWARD";
    /**
     * 高级盟主二次升级奖励
     */
    public static final String COL_ADVANCED_COMPANY_TWICE_UPGRADE_REWARD = "ADVANCED_COMPANY_TWICE_UPGRADE_REWARD";
    /**
     * 平台ID
     */
    public static final String COL_PLATFORM_ID = "PLATFORM_ID";
    /**
     * 逻辑删除 0未删除 1 已删除
     */
    public static final String COL_DELETED = "DELETED";
    /**
     * 备用字段1
     */
    public static final String COL_SPARE1 = "SPARE1";
    /**
     * 备用字段1
     */
    public static final String COL_SPARE2 = "SPARE2";
    /**
     * 备用字段1
     */
    public static final String COL_SPARE3 = "SPARE3";
    /**
     * 备用字段1
     */
    public static final String COL_SPARE4 = "SPARE4";
    /**
     * 备用字段1
     */
    public static final String COL_SPARE5 = "SPARE5";
}