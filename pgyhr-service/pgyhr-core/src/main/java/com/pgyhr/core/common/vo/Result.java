package com.pgyhr.core.common.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author cuixg
 * @title: UsernameUtil
 * @projectName pgyhr-module
 * @description: 前后端交互数据标准
 * @date 2020/4/3  11:33
 */
@Data
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;
}
