package com.pgyhr.company.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.company.business.CompanyContactsService;
import com.pgyhr.company.dao.mapper.CompanyContactsMapper;
import com.pgyhr.company.entity.dto.CompanyAndContactsListDTO;
import com.pgyhr.company.entity.dto.CompanyContactsDTO;
import com.pgyhr.company.entity.po.CompanyContacts;
import com.pgyhr.core.common.utils.CommonUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-13
 */
@Service
public class CompanyContactsServiceImpl extends ServiceImpl<CompanyContactsMapper, CompanyContacts> implements CompanyContactsService {

    @Override
    public int deleteAdd(CompanyAndContactsListDTO companyAndContactsListDTO) {
        QueryWrapper<CompanyContacts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_code",companyAndContactsListDTO.getCompanyCode());
        int count = companyAndContactsListDTO.getCompanyContactsDTOList().size();
        System.out.println(count);
        int countDel = baseMapper.delete(queryWrapper);
        //if(countDel>0){
        for (CompanyContacts cc:companyAndContactsListDTO.getCompanyContactsDTOList()) {
            baseMapper.insert(cc);
        }
        //}
        return 0;
    }

    @Override
    public int delCompanyC(String compamyCode) {
        QueryWrapper<CompanyContacts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("company_code",compamyCode);
        int count = baseMapper.delete(queryWrapper);
        return count;
    }
}
