package com.utils;

/**
 * @author yangyantong
 */

public enum SmsCode {
    /**
     * 注册
     */
    REGISTRATION("1", "SMS_198865054"),
    /**
     * 找回密码
     */
    FIND_PASSWORD("2", "SMS_198790023");


    private String state;
    private String Template;

    SmsCode(String state, String template) {
        this.state = state;
        Template = template;
    }

    public static String getTemplateByState(String state) {
        SmsCode[] smsCodes = SmsCode.values();
        for (SmsCode smsCode : smsCodes) {
            if (smsCode.getState().equals(state)) {
                return smsCode.getTemplate();
            }
        }
        return null;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTemplate() {
        return Template;
    }

    public void setTemplate(String template) {
        Template = template;
    }
}
