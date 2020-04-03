package com.pgyhr.core.service.mybatis;

import com.pgyhr.core.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author cuixg
 * @title: IPermissionService
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@CacheConfig(cacheNames = "userPermission")
public interface IPermissionService extends IService<Permission> {

    /**
     * 通过用户id获取
     * @param userId
     * @return
     */
    @Cacheable(key = "#userId")
    List<Permission> findByUserId(String userId);
}
