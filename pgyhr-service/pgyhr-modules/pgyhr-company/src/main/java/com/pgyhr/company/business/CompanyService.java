package com.pgyhr.company.business;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.company.entity.dto.CompanyRequestDTO;
import com.pgyhr.company.entity.po.CompanyPO;

import java.util.List;

/**
 * <p>
 * 全国客户公司表 服务类
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-07
 */
public interface CompanyService extends IService<CompanyPO> {

    Page<CompanyPO> getCompanyPageByParam(Page<CompanyPO> companyPOPage, CompanyRequestDTO companyRequestDTO);
}
