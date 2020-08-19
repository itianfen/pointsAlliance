package com.utils;

import java.math.BigDecimal;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/24 15:02
 */
public class DetailTemplate {

    /**
     * 流水模板
     *
     * @param userName    受益人姓名
     * @param userId      受益人ID
     * @param method      方法
     * @param profitMoney 受益多少元
     * @param profitPoint 获得积分
     * @return 模板
     */
    public static String getDetail(String userName, String userId, String method, BigDecimal profitMoney, BigDecimal profitPoint) {
        return "姓名：" + userName + " ID:" + userId + "通过：" + method + " 获得收益：" + profitMoney + "元 " + profitPoint + "积分";
    }
}
