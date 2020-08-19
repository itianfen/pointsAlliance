package com.jx.controller;

import com.utils.WeiXinJsSdkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yangyantong
 * @version 1.0
 * @date 2020/8/3 9:36
 */
@Slf4j
@RestController
public class GetJsConfig {
    @RequestMapping(value = "/getJsConfig", method = RequestMethod.GET)
    public Map<Object, Object> getJsConfig(String url) {
        return WeiXinJsSdkUtils.getJsApiConfigArgs(url);
    }
}
