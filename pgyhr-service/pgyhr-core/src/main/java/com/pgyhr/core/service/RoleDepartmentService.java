package com.pgyhr.core.service;

import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.core.entity.RoleDepartment;

import java.util.List;

/**
 * @author cuixg
 * @title: RoleDepartmentService
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
public interface RoleDepartmentService extends PgyhrBaseService<RoleDepartment,String> {

    /**
     * 通过roleId获取
     * @param roleId
     * @return
     */
    List<RoleDepartment> findByRoleId(String roleId);

    /**
     * 通过角色id删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);

    /**
     * 通过角色id删除
     * @param departmentId
     */
    void deleteByDepartmentId(String departmentId);
}