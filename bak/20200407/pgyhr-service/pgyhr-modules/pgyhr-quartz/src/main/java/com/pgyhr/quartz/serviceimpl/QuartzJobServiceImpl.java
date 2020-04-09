package com.pgyhr.quartz.serviceimpl;

import com.pgyhr.quartz.dao.QuartzJobDao;
import com.pgyhr.quartz.entity.QuartzJob;
import com.pgyhr.quartz.service.QuartzJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cuixg
 * @title: QuartzJobServiceImpl
 * @projectName pgyhr-module
 * @description: 定时任务接口实现
 * @date 2020/4/3  11:33
 */
@Slf4j
@Service
@Transactional
public class QuartzJobServiceImpl implements QuartzJobService {

    @Autowired
    private QuartzJobDao quartzJobDao;

    @Override
    public QuartzJobDao getRepository() {
        return quartzJobDao;
    }

    @Override
    public List<QuartzJob> findByJobClassName(String jobClassName) {

        return quartzJobDao.findByJobClassName(jobClassName);
    }
}