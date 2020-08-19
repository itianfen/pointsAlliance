package com.intercept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决跨域访问问题
 *
 * @author zhaos 2020/6/24
 */
@Configuration
public class CorsConfig {

    public CorsConfig() {
        // TODO Auto-generated constructor stub
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 4 对接口配置跨域设置
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //“*”代表全部。”**”代表适配所有接口。
        //其中addAllowedOrigin(String origin)方法是追加访问源地址。如果不使用”*”（即允许全部访问源），则可以配置多条访问源来做控制。
        // 1 设置访问源地址
        corsConfiguration.addAllowedOrigin("*");
        // 2 设置访问源请求头
        corsConfiguration.addAllowedHeader("*");
        // 3 设置访问源请求方法
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
        //corsConfiguration.addAllowedOrigin("http://www.aimaonline.cn/");
        //corsConfiguration.addAllowedOrigin("http://test.aimaonline.cn/");
    }
}
