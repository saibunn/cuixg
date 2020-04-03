package com.pgyhr.core.dao;

import com.pgyhr.core.base.PgyhrBaseDao;
import com.pgyhr.core.entity.User;

import java.util.List;

/**
 * @author cuixg
 * @title: UserDao
 * @projectName pgyhr-module
 * @description: 用户数据处理层
 * @date 2020/4/3  11:33
 */
public interface UserDao extends PgyhrBaseDao<User, String> {

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过手机获取用户
     * @param mobile
     * @return
     */
    User findByMobile(String mobile);

    /**
     * 通过邮件获取用户
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 通过部门id获取
     * @param departmentId
     * @return
     */
    List<User> findByDepartmentId(String departmentId);

    /**
     * 通过用户名模糊搜索
     * @param username
     * @param status
     * @return
     */
    List<User> findByUsernameLikeAndStatus(String username, Integer status);
}
