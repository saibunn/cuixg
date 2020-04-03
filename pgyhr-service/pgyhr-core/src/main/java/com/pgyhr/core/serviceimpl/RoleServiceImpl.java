package com.pgyhr.core.serviceimpl;

import com.pgyhr.core.dao.RoleDao;
import com.pgyhr.core.entity.Role;
import com.pgyhr.core.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cuixg
 * @title: RoleServiceImpl
 * @projectName pgyhr-module
 * @description: 角色接口实现
 * @date 2020/4/3  11:33
 */
@Slf4j
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public RoleDao getRepository() {
        return roleDao;
    }

    @Override
    public List<Role> findByDefaultRole(Boolean defaultRole) {
        return roleDao.findByDefaultRole(defaultRole);
    }
}
