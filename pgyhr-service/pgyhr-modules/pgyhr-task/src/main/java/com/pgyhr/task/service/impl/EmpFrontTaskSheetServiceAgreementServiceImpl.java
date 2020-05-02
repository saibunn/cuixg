package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.task.dao.mapper.EmpFrontTaskSheetServiceAgreementMapper;
import com.pgyhr.task.entity.po.EmpCompanyPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetServiceAgreementPO;
import com.pgyhr.task.service.EmpFrontTaskSheetServiceAgreementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 前道任务单服务约定表 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-26
 */
@Service
public class EmpFrontTaskSheetServiceAgreementServiceImpl extends ServiceImpl<EmpFrontTaskSheetServiceAgreementMapper, EmpFrontTaskSheetServiceAgreementPO> implements EmpFrontTaskSheetServiceAgreementService {

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int saveEmpFrontTaskSheetServiceAgreement(EmpCompanyPO addEmpCompanyPO,EmpFrontTaskSheetPO addEmpFrontTaskSheetPO) {
        EmpFrontTaskSheetServiceAgreementPO empFrontTaskSheetServiceAgreementPO = new EmpFrontTaskSheetServiceAgreementPO();
        empFrontTaskSheetServiceAgreementPO.setEmpFrontTaskSheetCode(addEmpFrontTaskSheetPO.getEmpFrontTaskSheetCode());
        empFrontTaskSheetServiceAgreementPO.setCompanyId(addEmpFrontTaskSheetPO.getCompanyId());
        empFrontTaskSheetServiceAgreementPO.setCompanyName(addEmpFrontTaskSheetPO.getCompanyName());
        empFrontTaskSheetServiceAgreementPO.setWorkCityCode(addEmpCompanyPO.getWorkCityCode());
        empFrontTaskSheetServiceAgreementPO.setWorkCityName(addEmpCompanyPO.getWorkCityName());
        empFrontTaskSheetServiceAgreementPO.setSocialCityCode(addEmpCompanyPO.getSocialCityCode());
        empFrontTaskSheetServiceAgreementPO.setSocialCityName(addEmpCompanyPO.getSocialCityName());
        empFrontTaskSheetServiceAgreementPO.setFundCityCode(addEmpCompanyPO.getFundCityCode());
        empFrontTaskSheetServiceAgreementPO.setFundCityName(addEmpCompanyPO.getFundCityName());

        empFrontTaskSheetServiceAgreementPO.setSocialType(addEmpCompanyPO.getSocialUnit());
        empFrontTaskSheetServiceAgreementPO.setFundType(addEmpCompanyPO.getFundUnit());
        empFrontTaskSheetServiceAgreementPO.setCompanyServiceType(addEmpCompanyPO.getTemplateType());
        empFrontTaskSheetServiceAgreementPO.setContractLabourSignType(addEmpCompanyPO.getLaborSide());
        empFrontTaskSheetServiceAgreementPO.setHandleWorkType(2);
        empFrontTaskSheetServiceAgreementPO.setFileKeepingType(2);
//        po.setTaskSheetServiceAgreementName("temp");
//        po.setCustomerCompanyInfoId(1L);

        //todo 档案
        //empFrontTaskSheetServiceAgreementPO.setFileKeepingType(fileKeepingType);
        return baseMapper.insert(empFrontTaskSheetServiceAgreementPO);
    }
}
