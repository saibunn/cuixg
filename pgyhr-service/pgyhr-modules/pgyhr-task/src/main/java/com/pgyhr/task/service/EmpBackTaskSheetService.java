package com.pgyhr.task.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.EmpBackTaskSheetSearchRequestDTO;
import com.pgyhr.task.entity.po.EmpBackTaskSheetPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;

/**
 * <p>
 * 雇员后道任务单表 服务类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-07
 */
public interface EmpBackTaskSheetService extends IService<EmpBackTaskSheetPO> {

    Boolean generatorEmpBackTaskSheet(EmpFrontTaskSheetPO empFrontTaskSheetPO);

    Page<EmpBackTaskSheetPO> getEmployeeBackTaskSheetPageByParam(Page<EmpBackTaskSheetPO> empBackTaskSheetPOPage, EmpBackTaskSheetSearchRequestDTO empBackTaskSheetSearchRequestDTO);
}
