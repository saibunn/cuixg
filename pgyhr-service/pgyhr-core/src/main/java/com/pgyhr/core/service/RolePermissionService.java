package com.pgyhr.core.service;

import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.core.entity.RolePermission;

import java.util.List;

/**
 * @author cuixg
 * @title: RolePermissionService
 * @projectName pgyhr-module
 * @description: 角色权限接口
 * @date 2020/4/3  11:33
 */
public interface RolePermissionService extends PgyhrBaseService<RolePermission,String> {

    /**
     * 通过permissionId获取
     * @param permissionId
     * @return
     */
    List<RolePermission> findByPermissionId(String permissionId);

    /**
     * 通过roleId获取
     * @param roleId
     * @return
     */
    List<RolePermission> findByRoleId(String roleId);

    /**
     * 通过roleId删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}