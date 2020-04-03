package com.pgyhr.core.dao;

import com.pgyhr.core.base.PgyhrBaseDao;
import com.pgyhr.core.entity.RolePermission;

import java.util.List;

/**
 * @author cuixg
 * @title: RolePermissionDao
 * @projectName pgyhr-module
 * @description: 角色权限数据处理层
 * @date 2020/4/3  11:33
 */
public interface RolePermissionDao extends PgyhrBaseDao<RolePermission, String> {

    /**
     * 通过permissionId获取
     * @param permissionId
     * @return
     */
    List<RolePermission> findByPermissionId(String permissionId);

    /**
     * 通过roleId获取
     * @param roleId
     */
    List<RolePermission> findByRoleId(String roleId);

    /**
     * 通过roleId删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}