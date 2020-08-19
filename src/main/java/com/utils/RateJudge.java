package com.utils;

import com.jx.entity.Card;
import com.jx.entity.SysUser;
import com.jx.entity.SystemSet;

import java.math.BigDecimal;

/**
 * 通过设置，用户等级，判断应该得到的收益
 *
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/24 17:10
 */
public class RateJudge {
    /**
     * 获取会员升级奖励比例
     *
     * @param systemSet 系统设置
     * @param sysUser   用户
     * @param direct    是否直推
     * @return 比例
     */
    public static BigDecimal getMemberUpgradeRate(SystemSet systemSet, SysUser sysUser, boolean direct) {
        System.out.println(systemSet);
        System.out.println(systemSet.getMemberNormalMoneyUpgradeDirect());
        //判断是不是盟主
        boolean isCompany = ConstantPool.COMPANY_ROLE_ID.equals(sysUser.getRoleId());
        //如果是盟主
        if (isCompany) {
            if (direct) {
                switch (String.valueOf(sysUser.getCompanyLevel())) {
                    case ConstantPool.COMPANY_NORMAL_LEVEL:
                        return systemSet.getCompanyNormalMoneyUpgradeDirect().divide(new BigDecimal("100"));
                    case ConstantPool.COMPANY_ADVANCED_LEVEL:
                        return systemSet.getCompanyAdvancedMoneyUpgradeDirect().divide(new BigDecimal("100"));
                    case ConstantPool.COMPANY_SUPER_LEVEL:
                        return systemSet.getCompanySuperMoneyUpgradeDirect().divide(new BigDecimal("100"));
                    default:
                        throw new RuntimeException();
                }
            } else {
                switch (String.valueOf(sysUser.getCompanyLevel())) {
                    case ConstantPool.COMPANY_NORMAL_LEVEL:
                        return systemSet.getCompanyNormalMoneyUpgradeIndirect().divide(new BigDecimal("100"));
                    case ConstantPool.COMPANY_ADVANCED_LEVEL:
                        return systemSet.getCompanyAdvancedMoneyUpgradeIndirect().divide(new BigDecimal("100"));
                    case ConstantPool.COMPANY_SUPER_LEVEL:
                        return systemSet.getCompanySuperMoneyUpgradeIndirect().divide(new BigDecimal("100"));
                    default:
                        throw new RuntimeException();
                }
            }
        } else {
            if (direct) {
                switch (String.valueOf(sysUser.getMemberLevel())) {
                    case ConstantPool.MEMBER_GOLD_LEVEL:
                        return systemSet.getMemberGoldMoneyUpgradeDirect().divide(new BigDecimal("100"));
                    case ConstantPool.MEMBER_DIAMOND_LEVEL:
                        return systemSet.getMemberDiamondMoneyUpgradeDirect().divide(new BigDecimal("100"));
                    case ConstantPool.MEMBER_NORMAL_LEVEL:
                        return systemSet.getMemberNormalMoneyUpgradeDirect().divide(new BigDecimal("100"));
                    default:
                        throw new RuntimeException();
                }
            } else {
                switch (String.valueOf(sysUser.getMemberLevel())) {
                    case ConstantPool.MEMBER_GOLD_LEVEL:
                        return systemSet.getMemberGoldMoneyUpgradeIndirect().divide(new BigDecimal("100"));
                    case ConstantPool.MEMBER_DIAMOND_LEVEL:
                        return systemSet.getMemberDiamondMoneyUpgradeIndirect().divide(new BigDecimal("100"));
                    case ConstantPool.MEMBER_NORMAL_LEVEL:
                        return systemSet.getMemberNormalMoneyUpgradeIndirect().divide(new BigDecimal("100"));
                    default:
                        throw new RuntimeException();
                }
            }
        }
    }

    /**
     * 获取盟主升级奖励比例
     *
     * @param systemSet   盟主设置表
     * @param parentUser  推荐人
     * @param correctUser 当前人
     * @param isFirst     是否第一次升级
     * @return 比例
     */
    public static BigDecimal getCompanyUpgradeRate(SystemSet systemSet, SysUser parentUser, SysUser correctUser, boolean isFirst) {
        //判断是不是盟主
        boolean isCompany = ConstantPool.COMPANY_ROLE_ID.equals(parentUser.getRoleId());
        if (isCompany) {
            if (isFirst) {
                switch (String.valueOf(correctUser.getCompanyLevel())) {
                    case ConstantPool.COMPANY_NORMAL_LEVEL:
                        return systemSet.getRecommendNormalCompanyReward();
                    case ConstantPool.COMPANY_ADVANCED_LEVEL:
                        return systemSet.getRecommendAdvancedCompanyReward();
                    case ConstantPool.COMPANY_SUPER_LEVEL:
                        return systemSet.getRecommendSuperCompanyReward();
                    default:
                        throw new RuntimeException();
                }
            } else {
                switch (String.valueOf(correctUser.getCompanyLevel() - 1)) {
                    case ConstantPool.COMPANY_NORMAL_LEVEL:
                        return systemSet.getNormalCompanyTwiceUpgradeReward().divide(new BigDecimal("100"));
                    case ConstantPool.COMPANY_ADVANCED_LEVEL:
                        return systemSet.getAdvancedCompanyTwiceUpgradeReward().divide(new BigDecimal("100"));
                    default:
                        throw new RuntimeException();
                }
            }
        } else {
            return BigDecimal.ZERO;
        }
    }

    /**
     * 获取当事人兑换价格比例
     *
     * @param card    卡类型
     * @param sysUser 当事人
     * @return 兑换收益比例
     */
    public static BigDecimal getExchangeRate(Card card, SysUser sysUser) {
        //判断自己是不是盟主
        if (ConstantPool.COMPANY_ROLE_ID.equals(sysUser.getRoleId())) {
            //如果自己是盟主 直接获取钻石会员价格
            return card.getMemberDiamond();
        } else {
            //判断会员等级
            switch (String.valueOf(sysUser.getMemberLevel())) {
                case ConstantPool.MEMBER_NORMAL_LEVEL:
                    return card.getMemberNormal();
                case ConstantPool.MEMBER_GOLD_LEVEL:
                    return card.getMemberGold();
                case ConstantPool.MEMBER_DIAMOND_LEVEL:
                    return card.getMemberDiamond();
                default:
                    throw new RuntimeException();
            }
        }
    }

    /**
     * 获取推荐人受益比例 直推间推
     *
     * @param systemSet 设置表
     * @param sysUser   获取收益用户
     * @param direct    是否直推
     * @return 收益比例
     */
    public static BigDecimal exchangeRecommendRate(SystemSet systemSet, SysUser sysUser, boolean direct) {
        //判断是否盟主 盟主没有兑换直推间推收益 只有盟主永久收益比例
        boolean isCompany = ConstantPool.COMPANY_ROLE_ID.equals(sysUser.getRoleId());
        if (isCompany) {
            return BigDecimal.ZERO;
        } else {
            //如果不是盟主 就按着系统设置表取收益比例
            if (direct) {
                //如果是直推
                //判断会员等级
                switch (String.valueOf(sysUser.getMemberLevel())) {
                    case ConstantPool.MEMBER_NORMAL_LEVEL:
                        return systemSet.getMemberNormalExchangePointDirect().divide(new BigDecimal("100"));
                    case ConstantPool.MEMBER_GOLD_LEVEL:
                        return systemSet.getMemberGoldExchangePointDirect().divide(new BigDecimal("100"));
                    case ConstantPool.MEMBER_DIAMOND_LEVEL:
                        return systemSet.getMemberDiamondExchangePointDirect().divide(new BigDecimal("100"));
                    default:
                        throw new RuntimeException();
                }
            } else {
                //间推
                //判断会员等级
                switch (String.valueOf(sysUser.getMemberLevel())) {
                    case ConstantPool.MEMBER_NORMAL_LEVEL:
                        return systemSet.getMemberNormalExchangePointIndirect().divide(new BigDecimal("100"));
                    case ConstantPool.MEMBER_GOLD_LEVEL:
                        return systemSet.getMemberGoldExchangePointIndirect().divide(new BigDecimal("100"));
                    case ConstantPool.MEMBER_DIAMOND_LEVEL:
                        return systemSet.getMemberDiamondExchangePointIndirect().divide(new BigDecimal("100"));
                    default:
                        throw new RuntimeException();
                }
            }
        }
    }


    //获取盟主团队奖比例
    //获取盟主同级兑换奖比例
    //获取盟主基础受益
    //获取盟主差价受益

    /**
     * 拿到盟主的底价
     *
     * @param sysUser 盟主实体
     * @param card    卡片实体
     * @return 盟主最低价
     */
    public static BigDecimal getCompanyFloorPrice(SysUser sysUser, Card card) {
        //判断盟主等级
        switch (String.valueOf(sysUser.getCompanyLevel())) {
            case ConstantPool.COMPANY_NORMAL_LEVEL:
                return card.getNormalCompanyFloorPrice();
            case ConstantPool.COMPANY_ADVANCED_LEVEL:
                return card.getAdvancedCompanyFloorPrice();
            case ConstantPool.COMPANY_SUPER_LEVEL:
                return card.getSuperCompanyFloorPrice();
            default:
                throw new RuntimeException();
        }
    }

    /**
     * 获取盟主永久收益
     *
     * @param sysUser   盟主实体
     * @param systemSet 盟主设置
     * @return 盟主永久收益
     */
    public static BigDecimal getCompanyForeverRate(SysUser sysUser, SystemSet systemSet) {
        //判断盟主等级
        switch (String.valueOf(sysUser.getCompanyLevel())) {
            case ConstantPool.COMPANY_NORMAL_LEVEL:
                return systemSet.getCompanyNormalProfitRate().divide(new BigDecimal("100"));
            case ConstantPool.COMPANY_ADVANCED_LEVEL:
                return systemSet.getCompanyAdvancedProfitRate().divide(new BigDecimal("100"));
            case ConstantPool.COMPANY_SUPER_LEVEL:
                return systemSet.getCompanySuperProfitRate().divide(new BigDecimal("100"));
            default:
                throw new RuntimeException();
        }
    }

    /**
     * 获取盟主团队奖收益比例
     *
     * @param sysUser   盟主实体
     * @param systemSet 盟主设置
     * @return 盟主团队奖收益比例
     */
    public static BigDecimal getCompanyTeamRate(SysUser sysUser, SystemSet systemSet) {
        //判断盟主等级
        switch (String.valueOf(sysUser.getCompanyLevel())) {
            case ConstantPool.COMPANY_NORMAL_LEVEL:
                return systemSet.getCompanyNormalTeamProfit().divide(new BigDecimal("100"));
            case ConstantPool.COMPANY_ADVANCED_LEVEL:
                return systemSet.getCompanyAdvancedTeamProfit().divide(new BigDecimal("100"));
            case ConstantPool.COMPANY_SUPER_LEVEL:
                return systemSet.getCompanySuperTeamProfit().divide(new BigDecimal("100"));
            default:
                throw new RuntimeException();
        }
    }

    /**
     * 获取盟主同级兑换奖
     *
     * @param sysUser   盟主实体
     * @param systemSet 盟主设置
     * @return 盟主同级兑换奖收益比例
     */
    public static BigDecimal getCompanyPeerExchangeRate(SysUser sysUser, SystemSet systemSet) {
        //判断盟主等级
        switch (String.valueOf(sysUser.getCompanyLevel())) {
            case ConstantPool.COMPANY_NORMAL_LEVEL:
                return systemSet.getCompanyNormalPeerExchange().divide(new BigDecimal("100"));
            case ConstantPool.COMPANY_ADVANCED_LEVEL:
                return systemSet.getCompanyAdvancedPeerExchange().divide(new BigDecimal("100"));
            case ConstantPool.COMPANY_SUPER_LEVEL:
                return systemSet.getCompanySuperPeerExchange().divide(new BigDecimal("100"));
            default:
                throw new RuntimeException();
        }
    }
}