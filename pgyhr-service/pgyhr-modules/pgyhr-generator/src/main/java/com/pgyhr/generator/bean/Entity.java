package com.pgyhr.generator.bean;

import lombok.Data;

/**
 * @author cuixg
 * @title: Entity
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
public class Entity {

    private String entityPackage;

    private String daoPackage;

    private String servicePackage;

    private String serviceImplPackage;

    private String controllerPackage;

    private String author;

    private String className;

    private String classNameLowerCase;

    private String tableName;

    private String description;

    private String primaryKeyType;

    private Boolean isTree;
}
