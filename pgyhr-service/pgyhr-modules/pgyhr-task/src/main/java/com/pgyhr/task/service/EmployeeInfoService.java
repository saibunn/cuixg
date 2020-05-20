package com.pgyhr.task.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.EmployeeInfoRequsetDTO;
import com.pgyhr.task.entity.dto.EmployeeRequestDTO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;

import java.util.List;

/**
 * <p>
 * 雇员信息表 服务类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-20
 */
public interface EmployeeInfoService extends IService<EmployeeInfoPO> {

    EmployeeInfoPO selectEmployeeInfoByParam(EmployeeInfoRequsetDTO employeeInfoRequsetDTO);

    Page<EmployeeInfoPO> getEmployeeInfoPageByParam(Page<EmployeeInfoPO> employeeInfoPOPage, EmployeeRequestDTO employeeRequestDTO);

    EmployeeInfoPO getemployeeInfoByKey(String employeeId);
}
