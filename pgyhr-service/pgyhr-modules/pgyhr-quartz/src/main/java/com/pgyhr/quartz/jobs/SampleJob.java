package com.pgyhr.quartz.jobs;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author cuixg
 * @title: SampleJob
 * @projectName pgyhr-module
 * @description: 示例带参定时任务
 * @date 2020/4/3  11:33
 */
@Slf4j
public class SampleJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info(String.format("欢迎使用pgyhr平台! 时间:"+ DateUtil.now()));
    }
}
