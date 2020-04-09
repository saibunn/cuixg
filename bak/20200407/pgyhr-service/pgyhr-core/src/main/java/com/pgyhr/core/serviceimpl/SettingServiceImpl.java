package com.pgyhr.core.serviceimpl;

import com.pgyhr.core.dao.SettingDao;
import com.pgyhr.core.entity.Setting;
import com.pgyhr.core.service.SettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cuixg
 * @title: SettingServiceImpl
 * @projectName pgyhr-module
 * @description: 配置接口实现
 * @date 2020/4/3  11:33
 */
@Slf4j
@Service
@Transactional
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingDao settingDao;

    @Override
    public Setting get(String id) {

        return settingDao.findById(id).orElse(new Setting(id));
    }

    @Override
    public Setting saveOrUpdate(Setting setting) {

        return settingDao.saveAndFlush(setting);
    }
}