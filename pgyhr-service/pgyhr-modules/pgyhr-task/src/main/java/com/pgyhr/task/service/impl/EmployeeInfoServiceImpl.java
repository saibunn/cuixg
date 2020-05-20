package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.task.dao.mapper.EmployeeInfoMapper;
import com.pgyhr.task.entity.dto.EmployeeInfoRequsetDTO;
import com.pgyhr.task.entity.dto.EmployeeRequestDTO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.service.EmployeeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Override
    public EmployeeInfoPO selectEmployeeInfoByParam(EmployeeInfoRequsetDTO employeeInfoRequsetDTO) {
        QueryWrapper<EmployeeInfoPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_card_type",employeeInfoRequsetDTO.getIdCardType());
        queryWrapper.eq("id_num",employeeInfoRequsetDTO.getIdNum());
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Page<EmployeeInfoPO> getEmployeeInfoPageByParam(Page<EmployeeInfoPO> employeeInfoPOPage, EmployeeRequestDTO employeeRequestDTO) {
        QueryWrapper<EmployeeInfoPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("employee_name",employeeRequestDTO.getEmployeeName());
        queryWrapper.like("id_num",employeeRequestDTO.getIdNum());
        queryWrapper.orderByDesc("created_time");
        return baseMapper.selectPage(employeeInfoPOPage,queryWrapper);
    }

    @Override
    public EmployeeInfoPO getemployeeInfoByKey(String employeeId) {
        QueryWrapper<EmployeeInfoPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id",employeeId);
        return baseMapper.selectOne(queryWrapper);
    }
}
