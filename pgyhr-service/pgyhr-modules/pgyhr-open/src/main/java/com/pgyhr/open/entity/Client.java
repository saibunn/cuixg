package com.pgyhr.open.entity;

import com.pgyhr.core.base.PgyhrBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author cuixg
 * @title: Client
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
@Entity
@Table(name = "t_client")
@TableName("t_client")
@ApiModel(value = "第三方网站client信息")
public class Client extends PgyhrBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "网站名称")
    private String name;

    @ApiModelProperty(value = "秘钥")
    private String clientSecret;

    @ApiModelProperty(value = "网站主页")
    private String homeUri;

    @ApiModelProperty(value = "成功授权后的回调地址")
    private String redirectUri;
}