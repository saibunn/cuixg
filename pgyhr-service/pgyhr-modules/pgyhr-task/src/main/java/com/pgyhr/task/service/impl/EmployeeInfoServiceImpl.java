package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.task.dao.mapper.EmployeeInfoMapper;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.service.EmployeeInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 雇员信息表 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-20
 */
@Service
public class EmployeeInfoServiceImpl extends ServiceImpl<EmployeeInfoMapper, EmployeeInfoPO> implements EmployeeInfoService {

}
