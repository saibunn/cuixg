package com.pgyhr.core.service;


import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.core.entity.Role;

import java.util.List;

/**
 * @author cuixg
 * @title: RoleService
 * @projectName pgyhr-module
 * @description: 角色接口
 * @date 2020/4/3  11:33
 */
public interface RoleService extends PgyhrBaseService<Role, String> {

    /**
     * 获取默认角色
     * @param defaultRole
     * @return
     */
    List<Role> findByDefaultRole(Boolean defaultRole);
}
