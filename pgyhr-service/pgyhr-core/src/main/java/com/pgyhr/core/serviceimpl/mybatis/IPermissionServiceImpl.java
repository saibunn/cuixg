package com.pgyhr.core.serviceimpl.mybatis;

import com.pgyhr.core.dao.mapper.PermissionMapper;
import com.pgyhr.core.entity.Permission;
import com.pgyhr.core.service.mybatis.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cuixg
 * @title: IPermissionServiceImpl
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Service
public class IPermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByUserId(String userId) {

        return permissionMapper.findByUserId(userId);
    }
}
