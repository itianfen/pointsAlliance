package com.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jx.entity.OrderForm;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/5 14:18
 */
public class OrderQuery {
    public static QueryWrapper<OrderForm> convert(QueryWrapper<OrderForm> queryWrapper, Integer exchangeType) {
        switch (exchangeType) {
            case 0:
            case 4:
                return queryWrapper;
            case 1:
                return queryWrapper.between(OrderForm.COL_CREATED_TIME, DateFormatUtils.getCurrentDayMin(), DateFormatUtils.getCurrentDayMax());
            case 2:
                return queryWrapper.between(OrderForm.COL_CREATED_TIME, DateFormatUtils.getCurrentMonthMin(), DateFormatUtils.getCurrentMonthMax());
            case 3:
                return queryWrapper.between(OrderForm.COL_CREATED_TIME, DateFormatUtils.getCurrentYearMin(), DateFormatUtils.getCurrentYearMax());
            default:
                throw new RuntimeException();
        }
    }
}
