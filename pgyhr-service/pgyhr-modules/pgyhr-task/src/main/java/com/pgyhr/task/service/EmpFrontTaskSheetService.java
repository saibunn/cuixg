package com.pgyhr.task.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSearchDTO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;

/**
 * <p>
 * 雇员前道任务单表 服务类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-30
 */
public interface EmpFrontTaskSheetService extends IService<EmpFrontTaskSheetPO> {

    Page<EmpFrontTaskSheetPO> getEmployeeFrontTaskSheetPageByParam(Page<EmpFrontTaskSheetPO> empFrontTaskSheetPOPage, EmpFrontTaskSheetSearchDTO empFrontTaskSheetSearchDTO);

    EmpFrontTaskSheetPO getEmpFrontTaskSheetByKey(String empFrontTaskSheetCode);
}
