package com.pgyhr.task.entity.translator;

import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentResponseDTO;
import com.pgyhr.task.entity.dto.EmployeeInfoResponseDTO;
import com.pgyhr.task.entity.enums.*;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetSocialFeeSegmentPO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 前道任务单转换类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-03
 */
public class EmpFrontTaskSheetSocialFeeSegmentTranslator {

    /**
     * 将empFrontTaskSheetSocialFeeSegmentPO转换成EmpFrontTaskSheetSocialFeeSegmentResponseDTO
     * @param empFrontTaskSheetSocialFeeSegmentPO
     * @return
     */
    public static EmpFrontTaskSheetSocialFeeSegmentResponseDTO toEmpFrontTaskSheetSocialFeeSegmentResponseDTO(EmpFrontTaskSheetSocialFeeSegmentPO empFrontTaskSheetSocialFeeSegmentPO){
        EmpFrontTaskSheetSocialFeeSegmentResponseDTO empFrontTaskSheetSocialFeeSegmentResponseDTO  = new EmpFrontTaskSheetSocialFeeSegmentResponseDTO();
        BeanUtils.copyProperties(empFrontTaskSheetSocialFeeSegmentPO, empFrontTaskSheetSocialFeeSegmentResponseDTO);
        if (empFrontTaskSheetSocialFeeSegmentResponseDTO.getCompanyPayMethod() != null) {
            empFrontTaskSheetSocialFeeSegmentResponseDTO.setCompanyPayMethodLabel(PayMethodEnum.getValueByKey(empFrontTaskSheetSocialFeeSegmentResponseDTO.getCompanyPayMethod()));
        }
        if (empFrontTaskSheetSocialFeeSegmentResponseDTO.getEmployeePayMethod() != null) {
            empFrontTaskSheetSocialFeeSegmentResponseDTO.setEmployeePayMethodLabel(PayMethodEnum.getValueByKey(empFrontTaskSheetSocialFeeSegmentResponseDTO.getEmployeePayMethod()));
        }
        if (empFrontTaskSheetSocialFeeSegmentResponseDTO.getSocialStatus() != null) {
            empFrontTaskSheetSocialFeeSegmentResponseDTO.setSocialStatusLabel(TaskStatusEnum.getValueByKey(empFrontTaskSheetSocialFeeSegmentResponseDTO.getSocialStatus()));
        }

        return empFrontTaskSheetSocialFeeSegmentResponseDTO;
    }
}
