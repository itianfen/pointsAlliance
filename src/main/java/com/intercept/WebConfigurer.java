package com.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Garen 2019/5/9
 */

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Resource
    private AuthIntercept authIntercept;

    /**
     * 这个方法是用来配置静态资源的，比如html，js，css，等等
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:/D:/test/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /**
     * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authIntercept).addPathPatterns("/**").excludePathPatterns("/Login/*", "/pages/*", "/iconFont/*", "/plugins/*");
    }

}
