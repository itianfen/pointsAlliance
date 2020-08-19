package com.utils;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/5 11:36
 */
public enum CardExchangeLimit {
    /**
     * 不限制
     */
    NO_LIMIT(0, "不限制"),
    /**
     * 次/天
     */
    DAY_LIMIT(1, "次/天"),
    /**
     * 次/月
     */
    MONTH_LIMIT(2, "次/月"),
    /**
     * 次/年
     */
    YEAR_LIMIT(3, "次/年"),
    /**
     * 次/人
     */
    SELF_LIMIT(4, "次/人");

    Integer exchangeType;
    String exchangeDetail;

    CardExchangeLimit(int exchangeType, String exchangeDetail) {
        this.exchangeType = exchangeType;
        this.exchangeDetail = exchangeDetail;
    }

    public static String getExchangeDetailByExchangeType(Integer state) {
        CardExchangeLimit[] cardExchangeLimits = CardExchangeLimit.values();
        for (CardExchangeLimit cardExchangeLimit : cardExchangeLimits) {
            if (cardExchangeLimit.getExchangeType().compareTo(state) == 0) {
                return cardExchangeLimit.getExchangeDetail();
            }
        }
        return null;
    }

    public Integer getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Integer exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getExchangeDetail() {
        return exchangeDetail;
    }

    public void setExchangeDetail(String exchangeDetail) {
        this.exchangeDetail = exchangeDetail;
    }
}
