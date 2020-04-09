package com.pgyhr.your.entity;

import com.pgyhr.core.base.PgyhrBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author cuixg
 * @title: Student
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
@Entity
@Table(name = "t_student")
@TableName("t_student")
@ApiModel(value = "测试")
public class Student extends PgyhrBaseEntity {

    private static final long serialVersionUID = 1L;

}