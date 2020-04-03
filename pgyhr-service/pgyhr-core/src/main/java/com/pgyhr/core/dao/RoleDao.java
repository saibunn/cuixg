package com.pgyhr.core.dao;

import com.pgyhr.core.base.PgyhrBaseDao;
import com.pgyhr.core.entity.Role;

import java.util.List;

/**
 * @author cuixg
 * @title: RoleDao
 * @projectName pgyhr-module
 * @description: 角色数据处理层
 * @date 2020/4/3  11:33
 */
public interface RoleDao extends PgyhrBaseDao<Role, String> {

    /**
     * 获取默认角色
     * @param defaultRole
     * @return
     */
    List<Role> findByDefaultRole(Boolean defaultRole);
}
