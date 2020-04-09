package com.pgyhr.quartz.service;


import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.quartz.entity.QuartzJob;

import java.util.List;

/**
 * @author cuixg
 * @title: QuartzJobService
 * @projectName pgyhr-module
 * @description: 定时任务接口
 * @date 2020/4/3  11:33
 */
public interface QuartzJobService extends PgyhrBaseService<QuartzJob, String> {

    /**
     * 通过类名获取
     * @param jobClassName
     * @return
     */
    List<QuartzJob> findByJobClassName(String jobClassName);
}