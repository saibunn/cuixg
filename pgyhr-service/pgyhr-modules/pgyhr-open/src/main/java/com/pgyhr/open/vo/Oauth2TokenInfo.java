package com.pgyhr.open.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cuixg
 * @title: Oauth2TokenInfo
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
@AllArgsConstructor
public class Oauth2TokenInfo implements Serializable {

    private String clientId;

    private String username;
}
