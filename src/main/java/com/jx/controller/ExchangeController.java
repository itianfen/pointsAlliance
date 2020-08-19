package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.jx.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/28 17:49
 */
@Slf4j
@RestController
public class ExchangeController {

    @Resource
    private ExchangeService exchangeService;

    /**
     * 积分兑换
     *
     * @param params {"orderId"} 订单ID
     * @return 结果
     */
    @RequestMapping(value = "exchange", method = RequestMethod.POST)

    public Map<String, Object> exchange(@RequestBody JSONObject params) {
        return exchangeService.exchangePoint(params.getString("orderId"));
    }

}
