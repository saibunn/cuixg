package com.pgyhr.core.service;


import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.core.entity.User;
import com.pgyhr.core.entity.UserRole;

import java.util.List;

/**
 * @author cuixg
 * @title: UserRoleService
 * @projectName pgyhr-module
 * @description: 用户角色接口
 * @date 2020/4/3  11:33
 */
public interface UserRoleService extends PgyhrBaseService<UserRole, String> {

    /**
     * 通过roleId查找
     * @param roleId
     * @return
     */
    List<UserRole> findByRoleId(String roleId);

    /**
     * 通过roleId查找用户
     * @param roleId
     * @return
     */
    List<User> findUserByRoleId(String roleId);

    /**
     * 删除用户角色
     * @param userId
     */
    void deleteByUserId(String userId);
}
