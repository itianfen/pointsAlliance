package com.jx.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/22 9:57
 */
@Mapper
public interface WxBaseService {
    /**
     * 微信绑定
     *
     * @param token    token
     * @param userInfo userInfo
     * @return result
     */
    Map<String, Object> wxBind(String token, JSONObject userInfo);

    /**
     * 微信绑定
     *
     * @param openId openId
     * @return result
     */
    Map<String, Object> wxLogin(String openId);
}
