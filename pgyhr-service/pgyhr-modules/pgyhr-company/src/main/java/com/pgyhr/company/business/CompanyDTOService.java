package com.pgyhr.company.business;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.company.entity.dto.CompanyAndContactsListDTO;
import com.pgyhr.company.entity.dto.CompanyRequestDTO;

import java.util.List;

public interface CompanyDTOService extends IService<CompanyAndContactsListDTO> {
    int insertDetails(CompanyAndContactsListDTO companyAndContactsListDTO);
    public CompanyAndContactsListDTO queryCompanyCode(String companyCode);
    int updateCompany(CompanyAndContactsListDTO companyAndContactsListDTO);

    IPage<CompanyAndContactsListDTO> getCompanyDTO(IPage<CompanyAndContactsListDTO> companyDTOPage, CompanyRequestDTO companyRequestDTO);
}
