package com.pgyhr.core.dao;

import com.pgyhr.core.base.PgyhrBaseDao;
import com.pgyhr.core.entity.RoleDepartment;

import java.util.List;

/**
 * @author cuixg
 * @title: RoleDepartmentDao
 * @projectName pgyhr-module
 * @description: 角色部门数据处理层
 * @date 2020/4/3  11:33
 */
public interface RoleDepartmentDao extends PgyhrBaseDao<RoleDepartment, String> {

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