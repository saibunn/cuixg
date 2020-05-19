package com.pgyhr.company.business.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.company.business.CompanyDTOService;
import com.pgyhr.company.dao.mapper.CompanyDTOMapper;
import com.pgyhr.company.entity.dto.CompanyAndContactsListDTO;
import com.pgyhr.company.entity.dto.CompanyRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CompanyDTOServiceImpl extends ServiceImpl<CompanyDTOMapper, CompanyAndContactsListDTO> implements CompanyDTOService {

    @Override
    public int insertDetails(CompanyAndContactsListDTO companyAndContactsListDTO) {
        System.out.println(companyAndContactsListDTO);
        int count = baseMapper.insertDetails(companyAndContactsListDTO);
        if(count>0&&companyAndContactsListDTO.getCompanyContactsDTOList().size()!=0) {
            baseMapper.insertCC(companyAndContactsListDTO);
        }
        return count;
    }

    @Override
    public CompanyAndContactsListDTO queryCompanyCode(String companyCode) {
        CompanyAndContactsListDTO companyAndContactsListDTO = baseMapper.queryCompanyCode(companyCode);
        return companyAndContactsListDTO;
    }

    @Override
    public int updateCompany(CompanyAndContactsListDTO companyAndContactsListDTO) {
        int count = baseMapper.updateCompany(companyAndContactsListDTO);
        if(count>0) {
        }
        return count;
    }

    @Override
    public IPage<CompanyAndContactsListDTO> getCompanyDTO(IPage<CompanyAndContactsListDTO> companyDTOPage, CompanyRequestDTO companyRequestDTO) {
        Map params = new HashMap();
        params.put("companyCode", companyRequestDTO.getCompanyCode());
        params.put("companyName", companyRequestDTO.getCompanyName());
        params.put("signedSales", companyRequestDTO.getSignedSales());
        params.put("responsibilityServiceName", companyRequestDTO.getResponsibilityService());
        System.out.println(companyRequestDTO.getIsActive());
        if(companyRequestDTO.getIsActive()!=null) {
            if (companyRequestDTO.getIsActive()) {
                params.put("isActive", 1);
            } else {
                params.put("isActive", 0);
            }
        }
//        params.put("currentPage", companyRequestDTO.getCurrentPage());
//        params.put("size", companyRequestDTO.getSize());
        IPage page = new Page<>(1,2);
        return companyDTOPage.setRecords(this.baseMapper.queryCompany(page));
    }

}
