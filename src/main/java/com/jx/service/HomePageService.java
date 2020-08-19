package com.jx.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/7/20 10:05
 */
@Service
public interface HomePageService {
    /**
     * 通过token获取首页信息
     *
     * @param token token
     * @return 首页信息
     */
    Map<String, Object> getHome(String token);

}
