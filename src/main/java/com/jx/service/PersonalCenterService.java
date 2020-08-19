package com.jx.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/29 10:45
 */
@Service
public interface PersonalCenterService {
    /**
     * 获取个人中心
     *
     * @param token token
     * @return 个人信息
     */
    Map<String, Object> getPersonalCenter(String token);
}
