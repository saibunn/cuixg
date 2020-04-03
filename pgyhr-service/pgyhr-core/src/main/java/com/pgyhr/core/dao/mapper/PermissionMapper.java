package com.pgyhr.core.dao.mapper;

import com.pgyhr.core.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cuixg
 * @title: PermissionMapper
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 通过用户id获取
     * @param userId
     * @return
     */
    List<Permission> findByUserId(@Param("userId") String userId);
}
