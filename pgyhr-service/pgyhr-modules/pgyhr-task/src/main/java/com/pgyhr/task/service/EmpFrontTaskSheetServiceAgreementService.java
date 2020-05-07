package com.pgyhr.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetServiceAgreementDTO;
import com.pgyhr.task.entity.po.EmpCompanyPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetServiceAgreementPO;

import java.util.List;

/**
 * <p>
 * 前道任务单服务约定表 服务类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-26
 */
public interface EmpFrontTaskSheetServiceAgreementService extends IService<EmpFrontTaskSheetServiceAgreementPO> {

    int saveEmpFrontTaskSheetServiceAgreement(EmpCompanyPO addEmpCompanyPO,EmpFrontTaskSheetPO addEmpFrontTaskSheetPO);

    List<EmpFrontTaskSheetServiceAgreementPO> getEmpFrontTaskSheetServiceAgreementByParam(EmpFrontTaskSheetServiceAgreementDTO empFrontTaskSheetServiceAgreementDTO);
}
