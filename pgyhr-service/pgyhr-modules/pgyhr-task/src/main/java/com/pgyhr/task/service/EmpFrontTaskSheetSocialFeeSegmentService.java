package com.pgyhr.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentDTO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetSocialFeeSegmentPO;

import java.util.List;

/**
 * <p>
 * 前道任务单社保费用段表 服务类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-26
 */
public interface EmpFrontTaskSheetSocialFeeSegmentService extends IService<EmpFrontTaskSheetSocialFeeSegmentPO> {

    List<EmpFrontTaskSheetSocialFeeSegmentPO> getEmpFrontTaskSheetSocialFeeSegmentByParam(EmpFrontTaskSheetSocialFeeSegmentDTO empFrontTaskSheetSocialFeeSegmentDTO);
}
