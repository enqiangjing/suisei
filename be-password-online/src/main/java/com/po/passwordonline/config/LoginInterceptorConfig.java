package com.po.passwordonline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置请求拦截器
 *
 * @author eq
 */
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    /**
     * 实现addInterceptors
     *
     * @param registry 拦截器
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(
                "/",
                "/login",
                "/api/pub/**",
                "/js/**",
                "/css/**",
                "/imgs/**",
                "/fonts/**",
                "/favicon.ico"
        );
        // 拦截所有请求，除 / 与 /main ... ... ...
    }
}
