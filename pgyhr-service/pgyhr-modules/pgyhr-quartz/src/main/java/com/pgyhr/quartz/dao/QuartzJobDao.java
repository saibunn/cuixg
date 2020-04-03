package com.pgyhr.quartz.dao;

import com.pgyhr.core.base.PgyhrBaseDao;
import com.pgyhr.quartz.entity.QuartzJob;

import java.util.List;

/**
 * @author cuixg
 * @title: QuartzJobDao
 * @projectName pgyhr-module
 * @description: 定时任务数据处理层
 * @date 2020/4/3  11:33
 */
public interface QuartzJobDao extends PgyhrBaseDao<QuartzJob, String> {

    /**
     * 通过类名获取
     * @param jobClassName
     * @return
     */
    List<QuartzJob> findByJobClassName(String jobClassName);
}