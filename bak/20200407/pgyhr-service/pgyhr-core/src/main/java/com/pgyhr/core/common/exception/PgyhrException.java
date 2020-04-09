package com.pgyhr.core.common.exception;

import lombok.Data;

/**
 * @author cuixg
 * @title: 系统日志自定义注解
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/3  11:33
 */
@Data
public class PgyhrException extends RuntimeException {

    private String msg;

    public PgyhrException(String msg){
        super(msg);
        this.msg = msg;
    }
}
