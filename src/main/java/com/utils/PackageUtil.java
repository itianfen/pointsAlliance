package com.utils;

import com.jx.entity.Card;
import com.jx.entity.SysUser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/4 10:11
 */
public class PackageUtil {
    public static List<Map<String, Object>> userPackage(List<SysUser> list) {
        List<Map<String, Object>> result = new ArrayList<>();
        list.forEach(sysUser -> {
            Map<String, Object> temp = new HashMap<>(16);
            temp.put("userId", sysUser.getId());
            temp.put("userName", sysUser.getName());
            temp.put("roleId", sysUser.getRoleId());
            temp.put("memberLevel", sysUser.getMemberLevel());
            temp.put("companyLevel", sysUser.getCompanyLevel());
            temp.put("profit", sysUser.getCumulativeProfit());
            temp.put("point", sysUser.getCumulativePoint());
            temp.put("head", sysUser.getHeadUrl());
            if (ConstantPool.COMPANY_ROLE_ID.equals(sysUser.getRoleId())) {
                temp.put("roleLevel", RoleLevel.getRoleNameById(Integer.parseInt(sysUser.getRoleId()) * 10 + sysUser.getCompanyLevel()));
            } else {
                temp.put("roleLevel", RoleLevel.getRoleNameById(Integer.parseInt(sysUser.getRoleId()) * 10 + sysUser.getMemberLevel()));
            }
            result.add(temp);
        });
        return result;
    }

    public static List<Map<String, Object>> cardListPackage(List<Card> list, SysUser sysUser) {
        List<Map<String, Object>> result = new ArrayList<>();
        list.forEach(card -> {
            Map<String, Object> temp = new HashMap<>(16);
            temp.put("cardId", card.getId());
            temp.put("name", card.getName());
            temp.put("odds", card.getOdds());
            temp.put("limitLine", card.getLimitLine());
            BigDecimal uniPrice = getExchangeRate(card, sysUser);
            temp.put("uniPrice", uniPrice);
            temp.put("memberNormal", card.getMemberNormal());
            temp.put("memberGold", card.getMemberGold());
            temp.put("memberDiamond", card.getMemberDiamond());
            temp.put("service", card.getService().compareTo(0) > 0 ? "实物" : "虚拟");
            Integer exchangeType = card.getExchangeType();
            Integer exchangeCount = card.getExchangeCount();
            String exchangeLimit;
            if (exchangeType.compareTo(0) == 0 || exchangeCount.compareTo(0) == 0 || exchangeCount == null) {
                exchangeLimit = "不限制";
            } else {
                exchangeLimit = "" + exchangeCount + CardExchangeLimit.getExchangeDetailByExchangeType(exchangeType);
            }
            temp.put("exchangeLimit", exchangeLimit);
            result.add(temp);
        });
        return result;
    }

    /**
     * 获取当事人兑换价格比例
     *
     * @param card    卡类型
     * @param sysUser 当事人
     * @return 兑换收益比例
     */
    private static BigDecimal getExchangeRate(Card card, SysUser sysUser) {

        BigDecimal limit = card.getLimitLine().divide(new BigDecimal("10000"));

        //判断自己是不是盟主
        if (ConstantPool.COMPANY_ROLE_ID.equals(sysUser.getRoleId())) {
            //如果自己是盟主 直接获取钻石会员价格
            return card.getMemberDiamond().divide(limit, 2, BigDecimal.ROUND_DOWN);
        } else {
            //判断会员等级
            switch (String.valueOf(sysUser.getMemberLevel())) {
                case ConstantPool.MEMBER_NORMAL_LEVEL:
                    return card.getMemberNormal().divide(limit, 2, BigDecimal.ROUND_DOWN);
                case ConstantPool.MEMBER_GOLD_LEVEL:
                    return card.getMemberGold().divide(limit, 2, BigDecimal.ROUND_DOWN);
                case ConstantPool.MEMBER_DIAMOND_LEVEL:
                    return card.getMemberDiamond().divide(limit, 2, BigDecimal.ROUND_DOWN);
                default:
                    throw new RuntimeException();
            }
        }
    }

    public static Map<String, Object> userPackage(SysUser sysUser) {
        Map<String, Object> result = Response.success();
        String unEnPhone = sysUser.getPhone();
        if (!StringUtils.isEmpty(unEnPhone) && unEnPhone.length() == 11) {
            result.put("phoneNumber", unEnPhone.substring(0, 3) + "****" + unEnPhone.substring(7));
        }
        result.put("roleName", sysUser.getRoleName() == null ? "" : sysUser.getRoleName());
        result.put("memberLevel", sysUser.getMemberLevel() == null ? "" : sysUser.getMemberLevel());
        result.put("companyLevel", sysUser.getCompanyLevel() == null ? "" : sysUser.getCompanyLevel());
        result.put("headUrl", sysUser.getHeadUrl() == null ? "" : sysUser.getHeadUrl());
        result.put("name", sysUser.getName() == null ? "" : sysUser.getName());
        result.put("roleId", sysUser.getRoleId() == null ? "" : sysUser.getRoleId());
        return result;
    }
}
