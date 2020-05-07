package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.CommonUtil;
import com.pgyhr.task.dao.mapper.EmpBackTaskSheetMapper;
import com.pgyhr.task.entity.CodePrefixUtil;
import com.pgyhr.task.entity.po.EmpBackTaskSheetPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.service.EmpBackTaskSheetService;
import com.pgyhr.task.service.EmpFrontTaskSheetServiceAgreementService;
import com.pgyhr.task.service.EmpFrontTaskSheetSocialFeeSegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Boolean generatorEmpBackTaskSheet(EmpFrontTaskSheetPO empFrontTaskSheetPO) {
        EmpBackTaskSheetPO addEmpBackTaskSheetPO = new EmpBackTaskSheetPO();
        addEmpBackTaskSheetPO = CommonTransform.convertToDTO(empFrontTaskSheetPO,EmpBackTaskSheetPO.class);
        //雇员后道任务单ID
        addEmpBackTaskSheetPO.setEmpBackTaskSheetCode(CommonUtil.buildId(CodePrefixUtil.EBT_CODE_PREFIX));

        //社保和公积金不同城市，拆分任务单 todo
        addEmpBackTaskSheetPO.setCityCode(empFrontTaskSheetPO.getSocialCityCode());
        addEmpBackTaskSheetPO.setCityName(empFrontTaskSheetPO.getSocialCityName());
        addEmpBackTaskSheetPO.setExecuteCityId(empFrontTaskSheetPO.getSocialCityCode());
        addEmpBackTaskSheetPO.setExecuteCityName(empFrontTaskSheetPO.getSocialCityName());

        return null;
    }
}
