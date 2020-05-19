package com.pgyhr.company.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.company.business.CompanyService;
import com.pgyhr.company.dao.mapper.CompanyMapper;
import com.pgyhr.company.entity.dto.CompanyRequestDTO;
import com.pgyhr.company.entity.po.CompanyPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 全国客户公司表 服务实现类
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-07
 */
@Slf4j
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyPO> implements CompanyService {


    @Override
    public Page<CompanyPO> getCompanyPageByParam(Page<CompanyPO> companyPOPage, CompanyRequestDTO companyRequestDTO) {
        QueryWrapper<CompanyPO> queryWrapper = new QueryWrapper<>();
        System.out.println(companyRequestDTO.getCompanyName());
        if(companyRequestDTO.getCompanyCode()!=null&&companyRequestDTO.getCompanyCode()!="") {
            queryWrapper.like("company_code", companyRequestDTO.getCompanyCode());
        }
        if(companyRequestDTO.getCompanyName()!=null&&companyRequestDTO.getCompanyName()!="") {
            queryWrapper.like("company_name", companyRequestDTO.getCompanyName());
        }
        if(companyRequestDTO.getIsActive()!=null) {
            if (companyRequestDTO.getIsActive()) {
                queryWrapper.eq("is_active", 1);
            } else {
                queryWrapper.eq("is_active", 0);
            }
        }
        if(companyRequestDTO.getSignedSales()!=null&&companyRequestDTO.getSignedSales()!="") {
            queryWrapper.like("signed_sales", companyRequestDTO.getSignedSales());
        }
        if(companyRequestDTO.getResponsibilityService()!=null&&companyRequestDTO.getResponsibilityService()!="") {
            queryWrapper.like("responsibility_service", companyRequestDTO.getResponsibilityService());
        }
        queryWrapper.orderByDesc("created_time");
        return baseMapper.selectPage(companyPOPage,queryWrapper);
    }

    @Override
    public List<CompanyPO> getCompanyPOLevel(int companyLevel) {
        QueryWrapper<CompanyPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_level",companyLevel);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public int delCompany(String compamyCode) {
        QueryWrapper<CompanyPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_code",compamyCode);
        int count = baseMapper.delete(queryWrapper);
        return count;
    }
}
