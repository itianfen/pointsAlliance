package com.jx.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/27 8:48
 */
@Service
public interface ExchangeService {
    /**
     * 积分兑换分成
     *
     * @param orderId 订单ID
     * @return 兑换结果
     */
    Map<String, Object> exchangePoint(String orderId);
}
