package com.pgyhr.core.common.exception;

import lombok.Data;

/**
 * @author cuixg
 * @title: LimitException
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/3  11:33
 */
@Data
public class LimitException extends RuntimeException {

    private String msg;

    public LimitException(String msg){
        super(msg);
        this.msg = msg;
    }
}
