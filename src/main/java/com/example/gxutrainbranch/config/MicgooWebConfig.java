package com.example.gxutrainbranch.config;

/**
 * @author MaoMao
 * @Description
 * @create 2022-09-02 4:43 PM
 */


import com.example.gxutrainbranch.control.admin.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * web配置
 */
@Configuration
@ComponentScan("com.example.gxutrainbranch.control")
@EnableWebMvc
public class MicgooWebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/*")//拦截所有请求
//                .excludePathPatterns("/login*")//过滤登录请求 以及 一些静态资源 （放行的意思）
//                .excludePathPatterns("/css")
//                .excludePathPatterns("/image")
//                .excludePathPatterns("/img")
//                .excludePathPatterns("/js");
//
//    }
}
