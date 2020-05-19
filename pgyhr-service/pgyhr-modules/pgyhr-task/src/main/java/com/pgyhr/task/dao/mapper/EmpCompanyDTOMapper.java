package com.pgyhr.task.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pgyhr.task.entity.dto.EmpCompanyRequestDTO;
import com.pgyhr.task.entity.dto.EmpCompanyWhereDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpCompanyDTOMapper extends BaseMapper<EmpCompanyRequestDTO> {
    public List<EmpCompanyRequestDTO> queryEmpCompany(IPage<EmpCompanyRequestDTO> empCompanyRequestDTOIPage, @Param("empCompanyWhereDTO") EmpCompanyWhereDTO empCompanyWhereDTO);
}
