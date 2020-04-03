package com.pgyhr.core.dao;

import com.pgyhr.core.base.PgyhrBaseDao;
import com.pgyhr.core.entity.UserRole;

import java.util.List;

/**
 * @author cuixg
 * @title: UserRoleDao
 * @projectName pgyhr-module
 * @description: 用户角色数据处理层
 * @date 2020/4/3  11:33
 */
public interface UserRoleDao extends PgyhrBaseDao<UserRole, String> {

    /**
     * 通过roleId查找
     * @param roleId
     * @return
     */
    List<UserRole> findByRoleId(String roleId);

    /**
     * 删除用户角色
     * @param userId
     */
    void deleteByUserId(String userId);
}
