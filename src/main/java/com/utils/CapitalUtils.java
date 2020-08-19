package com.utils;

import com.jx.entity.CapitalDetail;
import com.jx.entity.SysUser;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/25 10:38
 */
public class CapitalUtils {

    /**
     * 添加流水
     *
     * @param sysUser      生成人(升级/消费的人)
     * @param userId       受益人的用户Id
     * @param capitalType  流水类型
     * @param pointsDetail 积分变动
     * @param moneyDetail  金钱变动
     * @param orderId      订单Id
     * @param detail       详细说明
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addCapital(SysUser sysUser, String userId, String capitalType, BigDecimal pointsDetail, BigDecimal moneyDetail, String orderId, String detail) {
        //创建流水
        CapitalDetail capitalDetail = new CapitalDetail();
        capitalDetail.setId(UUIDUtils.generate());
        capitalDetail.setCreatedTime(DateFormatUtils.getCurrentDate());
        capitalDetail.setCreator(sysUser.getName());
        capitalDetail.setCreatorId(sysUser.getId());
        capitalDetail.setLastUpdateId(sysUser.getId());
        capitalDetail.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        capitalDetail.setLastUpdater(sysUser.getName());
        capitalDetail.setUserId(userId);
        capitalDetail.setCapitalType(Integer.valueOf(capitalType));
        capitalDetail.setPointsDetail(pointsDetail);
        capitalDetail.setMoneyDetail(moneyDetail);
        capitalDetail.setOrderId(orderId);
        capitalDetail.setCapitalContent(detail);
        capitalDetail.setDeleted(0);
        capitalDetail.insert();
    }
}
