package com.bila.demo.spring.configurer;

import com.bila.demo.spring.interceptor.MyWebMvcConfigurerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Magician
 * @Desc: WebMvcConfigurer配置类其实是Spring内部的一种配置方式，采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制
 * @Date: 2020/05/25
 * @Modify By:
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myWebMvcConfigurerInterceptor())
            .addPathPatterns("/**");
    }

    @Bean
    public HandlerInterceptor myWebMvcConfigurerInterceptor() {
        return new MyWebMvcConfigurerInterceptor();
    }
}
