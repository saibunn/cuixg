package com.pgyhr.core.service;

import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.core.entity.Permission;

import java.util.List;

/**
 * @author cuixg
 * @title: PermissionService
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
public interface PermissionService extends PgyhrBaseService<Permission, String> {

    /**
     * 通过层级查找
     * 默认升序
     * @param level
     * @return
     */
    List<Permission> findByLevelOrderBySortOrder(Integer level);

    /**
     * 通过parendId查找
     * @param parentId
     * @return
     */
    List<Permission> findByParentIdOrderBySortOrder(String parentId);

    /**
     * 通过类型和状态获取
     * @param type
     * @param status
     * @return
     */
    List<Permission> findByTypeAndStatusOrderBySortOrder(Integer type, Integer status);

    /**
     * 通过名称获取
     * @param title
     * @return
     */
    List<Permission> findByTitle(String title);

    /**
     * 模糊搜索
     * @param title
     * @return
     */
    List<Permission> findByTitleLikeOrderBySortOrder(String title);
}