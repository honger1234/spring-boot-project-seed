package com.honger1234.springbootprojectseed.intercepter;

import com.honger1234.springbootprojectseed.util.JWTUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zt
 */
public class TokenIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            return false;
        }
        //验证是否过期
        boolean expired = JWTUtil.isExpired(token);
        if (expired){
            return false;
        }
        return true;
    }
}
