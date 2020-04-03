package com.pgyhr.core.common.annotation;

import java.lang.annotation.*;

/**
 * @author cuixg
 * @title: RateLimiter
 * @projectName pgyhr-module
 * @description: 限流注解
 * @date 2020/4/3  11:33
 */
@Target(ElementType.METHOD)//作用于方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {

    int limit() default 5;
    int timeout() default 1000;
}
