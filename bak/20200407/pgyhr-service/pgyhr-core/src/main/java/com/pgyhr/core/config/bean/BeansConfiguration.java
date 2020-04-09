package com.pgyhr.core.config.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author cuixg
 * @title: UsernameUtil
 * @projectName pgyhr-module
 * @description: 声明bean
 * @date 2020/4/3  11:33
 */
@Configuration
public class BeansConfiguration {

    @Bean
    public PathMatcher pathMatcher(){

        return new AntPathMatcher();
    }
}
