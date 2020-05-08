package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.CommonUtil;
import com.pgyhr.task.dao.mapper.EmpBackTaskSheetMapper;
import com.pgyhr.task.entity.CodePrefixUtil;
import com.pgyhr.task.entity.dto.EmpBackTaskSheetSearchRequestDTO;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetServiceAgreementDTO;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentDTO;
import com.pgyhr.task.entity.po.*;
import com.pgyhr.task.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 雇员后道任务单表 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-07
 */
@Service
public class EmpBackTaskSheetServiceImpl extends ServiceImpl<EmpBackTaskSheetMapper, EmpBackTaskSheetPO> implements EmpBackTaskSheetService {

    @Autowired
    private EmpFrontTaskSheetSocialFeeSegmentService empFrontTaskSheetSocialFeeSegmentService;

    @Autowired
    private EmpFrontTaskSheetServiceAgreementService empFrontTaskSheetServiceAgreementService;

    @Autowired
    private EmpBackTaskSheetSocialFeeSegmentService empBackTaskSheetSocialFeeSegmentService;

    @Autowired
    private EmpBackTaskSheetServiceAgreementService empBackTaskSheetServiceAgreementService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean generatorEmpBackTaskSheet(EmpFrontTaskSheetPO empFrontTaskSheetPO) {
        Boolean generatorResult = true;
        EmpBackTaskSheetPO addEmpBackTaskSheetPO  = CommonTransform.convertToDTO(empFrontTaskSheetPO,EmpBackTaskSheetPO.class);
        //雇员后道任务单ID
        addEmpBackTaskSheetPO.setEmpBackTaskSheetCode(CommonUtil.buildId(CodePrefixUtil.EBT_CODE_PREFIX));
        addEmpBackTaskSheetPO.setTaskArea(1);
        //社保和公积金不同城市，拆分任务单 todo
        addEmpBackTaskSheetPO.setCityCode(empFrontTaskSheetPO.getSocialCityCode());
        addEmpBackTaskSheetPO.setCityName(empFrontTaskSheetPO.getSocialCityName());
        addEmpBackTaskSheetPO.setExecuteCityId(empFrontTaskSheetPO.getSocialCityCode());
        addEmpBackTaskSheetPO.setExecuteCityName(empFrontTaskSheetPO.getSocialCityName());
        if(baseMapper.insert(addEmpBackTaskSheetPO)>0){
            EmpFrontTaskSheetSocialFeeSegmentDTO empFrontTaskSheetSocialFeeSegmentDTO = new EmpFrontTaskSheetSocialFeeSegmentDTO();
            empFrontTaskSheetSocialFeeSegmentDTO.setEmpFrontTaskSheetCode(empFrontTaskSheetPO.getEmpFrontTaskSheetCode());
            List<EmpFrontTaskSheetSocialFeeSegmentPO> empFrontTaskSheetSocialFeeSegmentPOList =
                    empFrontTaskSheetSocialFeeSegmentService.getEmpFrontTaskSheetSocialFeeSegmentByParam(empFrontTaskSheetSocialFeeSegmentDTO);

            if(!CollectionUtils.isEmpty(empFrontTaskSheetSocialFeeSegmentPOList)){
                List<EmpBackTaskSheetSocialFeeSegmentPO> empBackTaskSheetSocialFeeSegmentPOList =
                        CommonTransform.convertToDTOs(empFrontTaskSheetSocialFeeSegmentPOList,EmpBackTaskSheetSocialFeeSegmentPO.class);

                empBackTaskSheetSocialFeeSegmentPOList.stream().forEach(item->{
                            item.setEmpBackTaskSheetCode(addEmpBackTaskSheetPO.getEmpBackTaskSheetCode());
                        }
                );
                if(!empBackTaskSheetSocialFeeSegmentService.saveBatch(empBackTaskSheetSocialFeeSegmentPOList)){
                    log.error("后道任务单社保费用段表表保存失败:" + addEmpBackTaskSheetPO.toString());
                    generatorResult = false;
                }

            }


            EmpFrontTaskSheetServiceAgreementDTO empFrontTaskSheetServiceAgreementDTO = new EmpFrontTaskSheetServiceAgreementDTO();
            empFrontTaskSheetServiceAgreementDTO.setEmpFrontTaskSheetCode(empFrontTaskSheetPO.getEmpFrontTaskSheetCode());
            List<EmpFrontTaskSheetServiceAgreementPO> empFrontTaskSheetServiceAgreementPOList =
                    empFrontTaskSheetServiceAgreementService.getEmpFrontTaskSheetServiceAgreementByParam(empFrontTaskSheetServiceAgreementDTO);

            if(!CollectionUtils.isEmpty(empFrontTaskSheetServiceAgreementPOList)){
                List<EmpBackTaskSheetServiceAgreementPO> empBackTaskSheetServiceAgreementPOList =
                        CommonTransform.convertToDTOs(empFrontTaskSheetServiceAgreementPOList,EmpBackTaskSheetServiceAgreementPO.class);

                empBackTaskSheetServiceAgreementPOList.stream().forEach(item->{
                            item.setEmpBackTaskSheetCode(addEmpBackTaskSheetPO.getEmpBackTaskSheetCode());
                            item.setCityId(addEmpBackTaskSheetPO.getExecuteCityId());
                            item.setCityName(addEmpBackTaskSheetPO.getExecuteCityName());

                        }
                );
                if(!empBackTaskSheetServiceAgreementService.saveBatch(empBackTaskSheetServiceAgreementPOList)){
                    log.error("后道任务单服务约定表保存失败:" + addEmpBackTaskSheetPO.toString());
                    generatorResult = false;
                }

            }

        }else{
            generatorResult = false;
        }




        return generatorResult;
    }

    @Override
    public Page<EmpBackTaskSheetPO> getEmployeeBackTaskSheetPageByParam(Page<EmpBackTaskSheetPO> empBackTaskSheetPOPage, EmpBackTaskSheetSearchRequestDTO empBackTaskSheetSearchRequestDTO) {
        QueryWrapper<EmpBackTaskSheetPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty(empBackTaskSheetSearchRequestDTO.getCompanyName()),"company_name",empBackTaskSheetSearchRequestDTO.getCompanyName());
        return baseMapper.selectPage(empBackTaskSheetPOPage,queryWrapper);
    }
}
