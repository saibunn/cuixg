package com.pgyhr.core.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author cuixg
 * @title: UsernameUtil
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
@AllArgsConstructor
public class TokenUser implements Serializable{

    private String username;

    private List<String> permissions;

    private Boolean saveLogin;
}
