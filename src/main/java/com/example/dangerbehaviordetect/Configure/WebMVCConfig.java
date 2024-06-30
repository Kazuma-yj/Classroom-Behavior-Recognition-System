package com.example.dangerbehaviordetect.Configure;//package com.example.dangerbehaviordetect.Configure;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMVCConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        //进行跨域配置
//        //前端占用8080 后端占用8888
//        //两个端口之间的访问就是跨域
//        //要允许8080端口访问8888
//        registry.addMapping("/**").allowedOrigins("http://172.30.93.99:8080/").allowedOrigins("http://172.27.136.223:8080").allowedOrigins("http://172.26.160.238:8080");
////        registry.addMapping("/**").allowedOrigins("http://192.168.43.83:8080/");
//    }
//}

import com.example.dangerbehaviordetect.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 实现 WebMvcConfigurer(全局跨域) 重写 addCorsMappings 方法设置跨域映射
 *
 * @author wangMaoXiong
 * @version 1.0
 * @date 2021/6/6 8:08
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)  // 允许客户端携带认证信息
                .allowedOriginPatterns("http://*:*")  // 允许所有域名和端口
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的HTTP方法
                .allowedHeaders("*");  // 允许所有的头部信息
    }

    @Configuration
    public class WebMvcConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //  /home/file/**为前端URL访问路径  后面 file:xxxx为本地磁盘映射
            registry.addResourceHandler("/images/**").addResourceLocations("file:D://images/");
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor())
                .addPathPatterns("/**");// 拦截所有请求，可以根据需要进行配置
    }
}