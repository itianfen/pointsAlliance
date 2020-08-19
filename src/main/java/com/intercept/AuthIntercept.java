package com.intercept;

import com.alibaba.fastjson.JSONObject;
import com.jx.entity.Token;
import com.utils.ErrorItem;
import com.utils.Response;
import com.utils.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Garen 2019/5/9
 */
@Component
public class AuthIntercept implements HandlerInterceptor {

    private static final String LOGIN = "login";
    private static final Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //请求的连接
        String uri = httpServletRequest.getRequestURI();
        //如果是登陆的直接通过
        if (uri.contains(LOGIN)) {
            log.info(uri + "登陆页允许访问");
            return true;
        }

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            Auth auth = handlerMethod.getMethod().getAnnotation(Auth.class);
            // 如果方法上的注解为空 则获取类的注解
            if (auth == null) {
                auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
            }

            if (auth == null) {
                log.info("cant find @Auth in this uri:" + httpServletRequest.getRequestURI());
                return true;
            }
            //获取token对象
            Token token = TokenUtils.getTokenObj(httpServletRequest.getHeader("Authorization"));

            //未登录
            if (token == null) {
                log.info(uri + "用户需要登录后访问");
                httpServletResponse.setHeader("SESSIONSTATUS", "TIMEOUT");
                httpServletResponse.setHeader("content-type", "text/html;charset=UTF-8");
                httpServletResponse.setStatus(401);
                JSONObject fail = new JSONObject(Response.fail(ErrorItem.AUTH_NEED_LOGIN));
                httpServletResponse.getWriter().write(fail.toString());
                return false;
            }
            // 从参数中取出用户身份并验证
            if (auth.user().contains(token.getAuth())) {
                return true;
            } else {
                log.info(uri + "权限不足无法访问");
                httpServletResponse.setStatus(402);
                httpServletResponse.setHeader("content-type", "text/html;charset=UTF-8");
                JSONObject fail = new JSONObject(Response.fail(ErrorItem.AUTH_TRANSCEND_ERROR));
                httpServletResponse.getWriter().write(fail.toString());
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }
}
