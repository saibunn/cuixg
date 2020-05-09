package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.task.dao.mapper.EmpBackTaskSheetSocialFeeSegmentMapper;
import com.pgyhr.task.entity.dto.EmpBackTaskSheetSocialFeeSegmentResponseDTO;
import com.pgyhr.task.entity.po.EmpBackTaskSheetSocialFeeSegmentPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetSocialFeeSegmentPO;
import com.pgyhr.task.service.EmpBackTaskSheetSocialFeeSegmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务单社保费用段表 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-09
 */
@Service
public class EmpBackTaskSheetSocialFeeSegmentServiceImpl extends ServiceImpl<EmpBackTaskSheetSocialFeeSegmentMapper, EmpBackTaskSheetSocialFeeSegmentPO> implements EmpBackTaskSheetSocialFeeSegmentService {

    @Override
    public List<EmpBackTaskSheetSocialFeeSegmentPO> getEmpBackTaskSheetSocialFeeSegmentByParam(EmpBackTaskSheetSocialFeeSegmentResponseDTO empBackTaskSheetSocialFeeSegmentResponseDTO) {
        QueryWrapper<EmpBackTaskSheetSocialFeeSegmentPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("emp_back_task_sheet_code",empBackTaskSheetSocialFeeSegmentResponseDTO.getEmpBackTaskSheetCode());
        return baseMapper.selectList(queryWrapper);
    }
}
