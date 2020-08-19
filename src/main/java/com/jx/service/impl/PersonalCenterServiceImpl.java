package com.jx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jx.entity.OrderForm;
import com.jx.entity.SysUser;
import com.jx.entity.Token;
import com.jx.service.OrderFormService;
import com.jx.service.PersonalCenterService;
import com.jx.service.SysUserService;
import com.utils.ConstantPool;
import com.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/29 10:46
 */
@Service
public class PersonalCenterServiceImpl implements PersonalCenterService {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private OrderFormService orderFormService;

    /**
     * 获取个人中心
     *
     * @param token token
     * @return 个人信息
     */
    @Override
    public Map<String, Object> getPersonalCenter(String token) {
        Map<String, Object> result = new HashMap<>(6);
        Token tokenObj = TokenUtils.getTokenObj(token);
        SysUser sysUser = sysUserService.getById(Objects.requireNonNull(tokenObj).getUserId());
        //累计盈利
        result.put("cumulativeProfit", sysUser.getCumulativeProfit());
        //可提现金额
        result.put("balance", sysUser.getBalance());
        //累计兑换积分
        result.put("cumulativePoint", sysUser.getCumulativePoint());
        //所有订单
        QueryWrapper<OrderForm> q = new QueryWrapper<>();
        q.eq(OrderForm.COL_CREATOR_ID, sysUser.getId());
        q.eq(OrderForm.COL_ORDER_TYPE, ConstantPool.ORDER_EXCHANGE_TYPE);
        List<OrderForm> list = orderFormService.list(q);
        //待审核
        int orderWaitReview = 0;
        int orderInReview = 0;
        int orderReviewSuccess = 0;
        int orderReviewFail = 0;
        for (OrderForm orderForm : list) {
            switch (String.valueOf(orderForm.getAuditState())) {
                case ConstantPool.ORDER_WAIT_PAY:
                    break;
                case ConstantPool.ORDER_FORM_WAIT_REVIEW:
                    orderWaitReview += 1;
                    break;
                case ConstantPool.ORDER_FORM_IN_REVIEW:
                    orderInReview += 1;
                    break;
                case ConstantPool.ORDER_FORM_REVIEW_SUCCESS:
                    orderReviewSuccess += 1;
                    break;
                case ConstantPool.ORDER_FORM_REVIEW_FAIL:
                    orderReviewFail += 1;
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        result.put("orderWaitReview", orderWaitReview);
        result.put("orderInReview", orderInReview);
        result.put("orderReviewSuccess", orderReviewSuccess);
        result.put("orderReviewFail", orderReviewFail);
        result.put("head", sysUser.getHeadUrl());
        return result;
    }
}
