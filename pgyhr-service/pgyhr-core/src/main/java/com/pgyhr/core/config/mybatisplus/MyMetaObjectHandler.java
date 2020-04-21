package com.pgyhr.core.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cuixg
 * @title: MyMetaObjectHandler
 * @projectName pgyhr-module
 * @description: 字段填充审计
 * @date 2020/4/3  11:33
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        String principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if(!"anonymousUser".equals(principal)){
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            this.setFieldValByName("createBy", user.getUsername(), metaObject);
            this.setFieldValByName("createdBy", user.getUsername(), metaObject);
        }
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createdTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        String principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if(!"anonymousUser".equals(principal)){
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            this.setFieldValByName("updateBy", user.getUsername(), metaObject);
            this.setFieldValByName("modifiedBy", user.getUsername(), metaObject);
        }
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("modifiedTime", new Date(), metaObject);
    }
}

