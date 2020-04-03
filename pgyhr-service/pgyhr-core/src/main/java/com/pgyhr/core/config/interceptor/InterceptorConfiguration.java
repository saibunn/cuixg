package com.pgyhr.core.config.interceptor;

import com.pgyhr.core.config.properties.IgnoredUrlsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cuixg
 * @title: InterceptorConfiguration
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    private IgnoredUrlsProperties ignoredUrlsProperties;

    @Autowired
    private LimitRaterInterceptor limitRaterInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(limitRaterInterceptor);
        // 配置拦截的路径
        ir.addPathPatterns("/**");
        // 配置不拦截的路径 避免加载css也拦截（可根据实际情况放开限流配置或拦截路径）
        ir.excludePathPatterns(ignoredUrlsProperties.getLimitUrls());
    }
}
