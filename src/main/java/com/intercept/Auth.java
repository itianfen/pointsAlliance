package com.intercept;

import java.lang.annotation.*;

/**
 * @author zhaos
 * @description 与拦截器结合使用 验证权限
 * @date 2019/05/06
 * @since 1.0
 */
@Inherited
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
    String user() default "";
}
/* 用法示例
 * @RestController
	@EnableAutoConfiguration
	public class DemoController {
	 
	  @Auth(user = "admin")
	  @RequestMapping(value = "/hello", method = RequestMethod.GET)
	  public String sayHello() {
	    return "hello world.";
	  }
	}
 */