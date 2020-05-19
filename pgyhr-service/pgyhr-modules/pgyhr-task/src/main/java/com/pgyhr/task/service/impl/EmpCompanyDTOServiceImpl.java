package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.task.dao.mapper.EmpCompanyDTOMapper;
import com.pgyhr.task.entity.dto.EmpCompanyRequestDTO;
import com.pgyhr.task.entity.dto.EmpCompanyWhereDTO;
import com.pgyhr.task.service.EmpCompanyDTOService;
import org.springframework.stereotype.Service;

@Service
public class EmpCompanyDTOServiceImpl extends ServiceImpl<EmpCompanyDTOMapper, EmpCompanyRequestDTO> implements EmpCompanyDTOService {

    @Override
    public IPage<EmpCompanyRequestDTO> getEmpCompany(IPage<EmpCompanyRequestDTO> empCompanyRequestDTOIPage, EmpCompanyWhereDTO empCompanyWhereDTO) {
        return empCompanyRequestDTOIPage.setRecords(this.baseMapper.queryEmpCompany(empCompanyRequestDTOIPage,empCompanyWhereDTO));
    }
}
