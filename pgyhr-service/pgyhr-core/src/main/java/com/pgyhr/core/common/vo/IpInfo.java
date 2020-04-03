package com.pgyhr.core.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cuixg
 * @title: UsernameUtil
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
@AllArgsConstructor
public class IpInfo implements Serializable {

    private String url;

    private String p;
}
