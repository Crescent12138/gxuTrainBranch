package com.example.gxutrainbranch.control.interceptor;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-02 4:15 PM
 */


import com.example.gxutrainbranch.service.AdminService;
import com.example.gxutrainbranch.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
//定义一个拦截器

@Slf4j  // => log
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        String uri = request.getRequestURI();
        log.info("当前路径："+uri);
        //获取token
        String token = request.getHeader("Authorization");

        String userId = jwtUtils.getUsernameFromToken(token);
        if (!jwtUtils.validateToken(token)) {
            //jwt中的验证token
            // 未通过拦截器验证，抛出异常
            log.error("登录失败！");
            throw new RuntimeException("登录失败！");
        }

//权限验证，需要自定义注解
        if (!(handler instanceof  HandlerMethod)){
            //不是接口请求不拦截
            return  true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        RequestMapping requestMapping = handlerMethod.getMethodAnnotation(RequestMapping.class);

//        List<String> authStrList = adminService.getAuthStrListByUserId(Long.valueOf(userId));
        //添加了自定义注解的方法
//        PreAuth preAuth = handlerMethod.getMethodAnnotation(PreAuth.class);
//        log.info("preAuth:"+preAuth);
//        if(!authStrList.contains(preAuth.value())){
//            // 用户无权限访问
//            log.error("用户无权限访问！");
//            throw new RuntimeException("用户无权限访问！");
//
//        }
        // 有权限访问
        return true;
    }
}
