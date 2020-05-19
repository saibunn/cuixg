package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.task.dao.mapper.EmpFrontTaskSheetMapper;
import com.pgyhr.task.entity.dto.EmpBackTaskSaveRequestDTO;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSearchDTO;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentDTO;
import com.pgyhr.task.entity.po.EmpBackTaskSheetPO;
import com.pgyhr.task.entity.po.EmpBackTaskSheetSocialFeeSegmentPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetSocialFeeSegmentPO;
import com.pgyhr.task.service.EmpFrontTaskSheetService;
import com.pgyhr.task.service.EmpFrontTaskSheetSocialFeeSegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Autowired
    private EmpFrontTaskSheetSocialFeeSegmentService empFrontTaskSheetSocialFeeSegmentService;

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

    @Override
    public Boolean changeEmpFrontTaskSheetStatus(EmpBackTaskSheetPO empBackTaskSheetPO, List<EmpBackTaskSheetSocialFeeSegmentPO> empBackTaskSheetSocialFeeSegmentPOList) {
        boolean changeFlg = true;
        EmpFrontTaskSheetPO empFrontTaskSheetPO = baseMapper.selectById(empBackTaskSheetPO.getEmpFrontTaskSheetCode());
        empFrontTaskSheetPO.setTaskStatus(5);
        if(this.updateById(empFrontTaskSheetPO)){
            //更新社保明细
            //前道任务单社保费用段表
            EmpFrontTaskSheetSocialFeeSegmentDTO empFrontTaskSheetSocialFeeSegmentDTO = new EmpFrontTaskSheetSocialFeeSegmentDTO();
            empFrontTaskSheetSocialFeeSegmentDTO.setEmpFrontTaskSheetCode(empFrontTaskSheetPO.getEmpFrontTaskSheetCode());
            List<EmpFrontTaskSheetSocialFeeSegmentPO> empFrontTaskSheetSocialFeeSegmentPOList =
                    empFrontTaskSheetSocialFeeSegmentService.getEmpFrontTaskSheetSocialFeeSegmentByParam(empFrontTaskSheetSocialFeeSegmentDTO);
            if(!CollectionUtils.isEmpty(empFrontTaskSheetSocialFeeSegmentPOList) && !CollectionUtils.isEmpty(empBackTaskSheetSocialFeeSegmentPOList)){
                EmpBackTaskSheetSocialFeeSegmentPO empBackTaskSheetSocialFeeSegmentPO;
                for(EmpFrontTaskSheetSocialFeeSegmentPO empFrontTaskSheetSocialFeeSegmentPO:empFrontTaskSheetSocialFeeSegmentPOList){
                    empBackTaskSheetSocialFeeSegmentPO = empBackTaskSheetSocialFeeSegmentPOList.stream().filter(a -> (empFrontTaskSheetSocialFeeSegmentPO.getItemCode().equals(a.getItemCode()))).findFirst().orElse(null);
                    if(empBackTaskSheetSocialFeeSegmentPO != null){
                        empFrontTaskSheetSocialFeeSegmentPO.setSocialStatus(empBackTaskSheetSocialFeeSegmentPO.getSocialStatus());
                        empFrontTaskSheetSocialFeeSegmentPO.setCompanyConfirmBase(empBackTaskSheetSocialFeeSegmentPO.getCompanyConfirmBase());
                        empFrontTaskSheetSocialFeeSegmentPO.setPersonalConfirmBase(empBackTaskSheetSocialFeeSegmentPO.getPersonalConfirmBase());
                        empFrontTaskSheetSocialFeeSegmentPO.setStartConfirmDate(empBackTaskSheetSocialFeeSegmentPO.getStartConfirmDate());
                        empFrontTaskSheetSocialFeeSegmentPO.setEndConfirmDate(empBackTaskSheetSocialFeeSegmentPO.getEndConfirmDate());

                    }
                }
                if(!empFrontTaskSheetSocialFeeSegmentService.updateBatchById(empFrontTaskSheetSocialFeeSegmentPOList)){
                    log.error("前道任务单社保费用段表表保存失败:" + empFrontTaskSheetPO.toString());
                    changeFlg = false;
                }
            }

        }else{
            changeFlg = false;
        }

        return changeFlg;
    }

}
