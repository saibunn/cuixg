package com.pgyhr.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cuixg
 * @title: RedisVo
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
@AllArgsConstructor
public class RedisVo {

    private String key;

    private String value;

    private Long expireTime;
}
