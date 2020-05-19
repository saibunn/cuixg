package com.pgyhr.company.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pgyhr.company.entity.dto.CompanyAndContactsListDTO;
import javafx.scene.control.Pagination;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CompanyDTOMapper extends BaseMapper<CompanyAndContactsListDTO> {
    public int insertDetails(CompanyAndContactsListDTO companyAndContactsListDTO);
    public int insertCC(CompanyAndContactsListDTO companyAndContactsListDTO);
    public CompanyAndContactsListDTO queryCompanyCode(@Param("companyCode") String companyCode);
    public int updateCompany(CompanyAndContactsListDTO companyAndContactsListDTO);

    public List<CompanyAndContactsListDTO> queryCompany(IPage<CompanyAndContactsListDTO> companyDTOPage);
}