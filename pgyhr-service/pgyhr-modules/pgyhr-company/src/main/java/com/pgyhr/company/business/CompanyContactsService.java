package com.pgyhr.company.business;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.company.entity.dto.CompanyAndContactsListDTO;
import com.pgyhr.company.entity.dto.CompanyContactsDTO;
import com.pgyhr.company.entity.po.CompanyContacts;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-13
 */
public interface CompanyContactsService extends IService<CompanyContacts> {

    int deleteAdd(CompanyAndContactsListDTO companyAndContactsListDTO);

    int delCompanyC(String compamyCode);
}
