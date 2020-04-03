package com.pgyhr.core.common.exception;

import lombok.Data;

/**
 * @author cuixg
 * @title: CaptchaException
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/3  11:33
 */
@Data
public class CaptchaException extends RuntimeException {

    private String msg;

    public CaptchaException(String msg){
        super(msg);
        this.msg = msg;
    }
}
