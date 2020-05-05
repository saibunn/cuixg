package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.task.dao.mapper.EmpFrontTaskSheetMapper;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSearchDTO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;
import com.pgyhr.task.service.EmpFrontTaskSheetService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 雇员前道任务单表 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-30
 */
@Service
public class EmpFrontTaskSheetServiceImpl extends ServiceImpl<EmpFrontTaskSheetMapper, EmpFrontTaskSheetPO> implements EmpFrontTaskSheetService {

    @Override
    public Page<EmpFrontTaskSheetPO> getEmployeeFrontTaskSheetPageByParam(Page<EmpFrontTaskSheetPO> empFrontTaskSheetPOPage, EmpFrontTaskSheetSearchDTO empFrontTaskSheetSearchDTO) {
        QueryWrapper<EmpFrontTaskSheetPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty(empFrontTaskSheetSearchDTO.getCompanyName()),"company_name",empFrontTaskSheetSearchDTO.getCompanyName());
        return baseMapper.selectPage(empFrontTaskSheetPOPage,queryWrapper);
    }

    @Override
    public EmpFrontTaskSheetPO getEmpFrontTaskSheetByKey(String empFrontTaskSheetCode) {
        QueryWrapper<EmpFrontTaskSheetPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("emp_front_task_sheet_code",empFrontTaskSheetCode);
        return baseMapper.selectOne(queryWrapper);
    }
}
