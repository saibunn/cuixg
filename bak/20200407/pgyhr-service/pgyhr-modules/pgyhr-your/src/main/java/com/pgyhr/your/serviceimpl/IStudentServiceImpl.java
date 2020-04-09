package com.pgyhr.your.serviceimpl;

import com.pgyhr.your.mapper.StudentMapper;
import com.pgyhr.your.entity.Student;
import com.pgyhr.your.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cuixg
 * @title: IStudentService
 * @projectName pgyhr-module
 * @description: 测试接口实现
 * @date 2020/4/3  11:33
 */
@Slf4j
@Service
@Transactional
public class IStudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
}