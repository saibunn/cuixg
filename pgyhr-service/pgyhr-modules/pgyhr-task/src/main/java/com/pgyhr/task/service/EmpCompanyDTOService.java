package com.pgyhr.task.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.EmpCompanyRequestDTO;
import com.pgyhr.task.entity.dto.EmpCompanyWhereDTO;

public interface EmpCompanyDTOService extends IService<EmpCompanyRequestDTO> {
    IPage<EmpCompanyRequestDTO> getEmpCompany(IPage<EmpCompanyRequestDTO> empCompanyRequestDTOIPage, EmpCompanyWhereDTO empCompanyWhereDTO);
}
