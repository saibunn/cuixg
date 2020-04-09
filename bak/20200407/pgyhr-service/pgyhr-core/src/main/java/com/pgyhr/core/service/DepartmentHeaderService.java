package com.pgyhr.core.service;

import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.core.entity.DepartmentHeader;

import java.util.List;

/**
 * @author cuixg
 * @title: DepartmentHeaderService
 * @projectName pgyhr-module
 * @description: 部门负责人接口
 * @date 2020/4/3  11:33
 */
public interface DepartmentHeaderService extends PgyhrBaseService<DepartmentHeader,String> {

    /**
     * 通过部门和负责人类型获取
     * @param departmentId
     * @param type
     * @return
     */
    List<String> findHeaderByDepartmentId(String departmentId, Integer type);

    /**
     * 通过部门获取
     * @param departmentIds
     * @return
     */
    List<DepartmentHeader> findByDepartmentIdIn(List<String> departmentIds);

    /**
     * 通过部门id删除
     * @param departmentId
     */
    void deleteByDepartmentId(String departmentId);

    /**
     * 通过userId删除
     * @param userId
     */
    void deleteByUserId(String userId);
}