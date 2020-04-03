package com.pgyhr.core.serviceimpl;

import com.pgyhr.core.common.constant.CommonConstant;
import com.pgyhr.core.dao.UserDao;
import com.pgyhr.core.dao.UserRoleDao;
import com.pgyhr.core.entity.User;
import com.pgyhr.core.entity.UserRole;
import com.pgyhr.core.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixg
 * @title: UserRoleServiceImpl
 * @projectName pgyhr-module
 * @description: 用户角色接口实现
 * @date 2020/4/3  11:33
 */
@Slf4j
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private UserDao userDao;

    @Override
    public UserRoleDao getRepository() {
        return userRoleDao;
    }

    @Override
    public List<UserRole> findByRoleId(String roleId) {
        return userRoleDao.findByRoleId(roleId);
    }

    @Override
    public List<User> findUserByRoleId(String roleId) {

        List<UserRole> userRoleList = userRoleDao.findByRoleId(roleId);
        List<User> list = new ArrayList<>();
        for(UserRole ur : userRoleList){
            User u = userDao.findById(ur.getUserId()).orElse(null);
            if(u!=null&& CommonConstant.USER_STATUS_NORMAL.equals(u.getStatus())){
                list.add(u);
            }
        }
        return list;
    }

    @Override
    public void deleteByUserId(String userId) {
        userRoleDao.deleteByUserId(userId);
    }
}
