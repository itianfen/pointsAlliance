package com.utils;

import com.jx.entity.OrderForm;
import com.jx.entity.Token;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/25 10:41
 */
public class OrderUtils {
    /**
     * 根据token创建会员升级订单
     *
     * @param token token
     * @return 订单
     */
    public static OrderForm createMemberUpgradeOrder(String token, String auditContent, String orderType) {
        OrderForm orderForm = baseOrder(token);
        orderForm.setAuditState(Integer.parseInt(ConstantPool.ORDER_FORM_IN_REVIEW));
        orderForm.setAuditContent(auditContent);
        orderForm.setOrderType(Integer.parseInt(orderType));
        orderForm.setOderDetail("");
        return orderForm;
    }

    /**
     * 根据token创建提现订单
     *
     * @param token
     * @return
     */
    public static OrderForm createWithdrawOrder(String token, String auditContent, String orderType, String money) {
        OrderForm orderForm = baseOrder(token);
        orderForm.setAuditState(Integer.parseInt(ConstantPool.ORDER_FORM_IN_REVIEW));
        orderForm.setAuditContent(auditContent);
        orderForm.setOrderType(Integer.parseInt(orderType));
        orderForm.setOderDetail("");
        orderForm.setGetMoney(new BigDecimal(money));
        return orderForm;
    }

    public static OrderForm baseOrder(String token) {
        Token tokenObj = TokenUtils.getTokenObj(token);
        OrderForm orderForm = new OrderForm();
        orderForm.setId(UUIDUtils.generate());
        orderForm.setCreatedTime(DateFormatUtils.getCurrentDate());
        orderForm.setCreator(Objects.requireNonNull(tokenObj).getUserName());
        orderForm.setCreatorId(tokenObj.getUserId());
        orderForm.setLastUpdateId(tokenObj.getUserId());
        orderForm.setLastUpdateTime(DateFormatUtils.getCurrentDate());
        orderForm.setLastUpdater(tokenObj.getUserName());
        orderForm.setUserId(tokenObj.getUserId());
        orderForm.setUserName(tokenObj.getUserName());
        orderForm.setUserPhone(tokenObj.getPhone());
        orderForm.setDeleted(0);
        return orderForm;
    }

}
