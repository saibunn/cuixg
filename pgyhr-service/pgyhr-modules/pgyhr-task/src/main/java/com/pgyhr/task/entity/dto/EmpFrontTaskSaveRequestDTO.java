package com.pgyhr.task.entity.dto;

import com.pgyhr.task.entity.po.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName EmpFrontTaskSaveRequestDTO
 * @Description
 * @Author xiaoguang.cui
 * @Date 2020/4/30 11:27
 * @Version V1.0
 **/
@Data
public class EmpFrontTaskSaveRequestDTO implements Serializable {

    private static final long serialVersionUID = -3166363412416468427L;

    private EmployeeInfoPO employeeInfoPO;

    private EmpCompanyPO empCompanyPO;

    private EmpFrontTaskSheetPO empFrontTaskSheetPO;

    private EmpFrontTaskSheetServiceAgreementPO empFrontTaskSheetServiceAgreementPO;

    private List<EmpFrontTaskSheetSocialFeeSegmentForSocialInfoDTO> empFrontTaskSheetSocialFeeSegmentForSocialInfoDTOList;
}
