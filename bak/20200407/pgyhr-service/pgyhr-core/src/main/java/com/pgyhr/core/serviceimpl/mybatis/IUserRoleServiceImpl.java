package com.pgyhr.core.serviceimpl.mybatis;

import com.pgyhr.core.dao.mapper.UserRoleMapper;
import com.pgyhr.core.entity.Role;
import com.pgyhr.core.entity.UserRole;
import com.pgyhr.core.service.mybatis.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cuixg
 * @title: IUserRoleServiceImpl
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Service
public class IUserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> findByUserId(String userId) {

        return userRoleMapper.findByUserId(userId);
    }

    @Override
    public List<String> findDepIdsByUserId(String userId) {

        return userRoleMapper.findDepIdsByUserId(userId);
    }
}
