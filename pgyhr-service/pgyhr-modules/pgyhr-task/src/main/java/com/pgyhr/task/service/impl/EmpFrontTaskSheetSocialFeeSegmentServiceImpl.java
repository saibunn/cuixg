package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.task.dao.mapper.EmpFrontTaskSheetSocialFeeSegmentMapper;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentDTO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetSocialFeeSegmentPO;
import com.pgyhr.task.service.EmpFrontTaskSheetSocialFeeSegmentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 前道任务单社保费用段表 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-26
 */
@Service
public class EmpFrontTaskSheetSocialFeeSegmentServiceImpl extends ServiceImpl<EmpFrontTaskSheetSocialFeeSegmentMapper, EmpFrontTaskSheetSocialFeeSegmentPO> implements EmpFrontTaskSheetSocialFeeSegmentService {

    @Override
    public List<EmpFrontTaskSheetSocialFeeSegmentPO> getEmpFrontTaskSheetSocialFeeSegmentByParam(EmpFrontTaskSheetSocialFeeSegmentDTO empFrontTaskSheetSocialFeeSegmentDTO) {
        QueryWrapper<EmpFrontTaskSheetSocialFeeSegmentPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("emp_front_task_sheet_code",empFrontTaskSheetSocialFeeSegmentDTO.getEmpFrontTaskSheetCode());
        return baseMapper.selectList(queryWrapper);
    }
}
