package com.pgyhr.core.service;

import com.pgyhr.core.entity.Setting;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author cuixg
 * @title: SettingService
 * @projectName pgyhr-module
 * @description: 角色接口
 * @date 2020/4/3  11:33
 */
@CacheConfig(cacheNames = "setting")
public interface SettingService {

    /**
     * 通过id获取
     * @param id
     * @return
     */
    @Cacheable(key = "#id")
    Setting get(String id);

    /**
     * 修改
     * @param setting
     * @return
     */
    @CacheEvict(key = "#setting.id")
    Setting saveOrUpdate(Setting setting);
}