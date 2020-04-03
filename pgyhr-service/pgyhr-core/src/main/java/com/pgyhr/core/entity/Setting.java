package com.pgyhr.core.entity;

import com.pgyhr.core.base.PgyhrBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author cuixg
 * @title: Setting
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
@Entity
@Table(name = "t_setting")
@TableName("t_setting")
@ApiModel(value = "配置")
@NoArgsConstructor
public class Setting extends PgyhrBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "配置值value")
    private String value;

    public Setting(String id){

        super.setId(id);
    }
}