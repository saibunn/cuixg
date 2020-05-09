package com.pgyhr.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.EmpBackTaskSheetSocialFeeSegmentResponseDTO;
import com.pgyhr.task.entity.po.EmpBackTaskSheetSocialFeeSegmentPO;

import java.util.List;

/**
 * <p>
 * 任务单社保费用段表 服务类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-07
 */
public interface EmpBackTaskSheetSocialFeeSegmentService extends IService<EmpBackTaskSheetSocialFeeSegmentPO> {

    List<EmpBackTaskSheetSocialFeeSegmentPO> getEmpBackTaskSheetSocialFeeSegmentByParam(EmpBackTaskSheetSocialFeeSegmentResponseDTO empBackTaskSheetSocialFeeSegmentResponseDTO);
}
