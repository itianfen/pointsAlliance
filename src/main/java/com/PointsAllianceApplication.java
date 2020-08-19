package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 程序启动入口
 *
 * @author zhoas
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = {"com.jx.dao"})
public class PointsAllianceApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(PointsAllianceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

}