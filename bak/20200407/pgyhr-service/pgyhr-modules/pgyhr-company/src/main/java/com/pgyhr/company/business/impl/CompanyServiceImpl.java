package com.pgyhr.company.business.impl;

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
    public List<CompanyPO> getCompanyPageByParam(CompanyRequestDTO companyRequestDTO) {
        return null;
    }
}
