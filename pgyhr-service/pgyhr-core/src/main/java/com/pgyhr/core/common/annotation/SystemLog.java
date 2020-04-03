package com.pgyhr.core.common.annotation;

import com.pgyhr.core.common.enums.LogType;

import java.lang.annotation.*;

/**
 * @author cuixg
 * @title: SystemLog
 * @projectName pgyhr-module
 * @description: 系统日志自定义注解
 * @date 2020/4/3  11:33
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

        /**
         * 日志名称
         * @return
         */
        String description() default "";

        /**
         * 日志类型
         * @return
         */
        LogType type() default LogType.OPERATION;
}
