package com.example.dangerbehaviordetect.Configure;

import com.example.dangerbehaviordetect.interceptor.LogParamsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements  WebMvcConfigurer {


    @Autowired
    LogParamsInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor).addPathPatterns("/**") // 你可以修改路径模式来匹配需要拦截的路径
                .excludePathPatterns("/login", "/register");;
    }
}