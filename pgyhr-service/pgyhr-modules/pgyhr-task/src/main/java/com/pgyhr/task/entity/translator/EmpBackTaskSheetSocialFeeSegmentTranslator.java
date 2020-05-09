package com.pgyhr.task.entity.translator;

import com.pgyhr.task.entity.dto.EmpBackTaskSheetSocialFeeSegmentResponseDTO;
import com.pgyhr.task.entity.enums.PayMethodEnum;
import com.pgyhr.task.entity.enums.SocialStatusEnum;
import com.pgyhr.task.entity.enums.TaskStatusEnum;
import com.pgyhr.task.entity.po.EmpBackTaskSheetSocialFeeSegmentPO;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 前道任务单转换类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-09
 */
public class EmpBackTaskSheetSocialFeeSegmentTranslator {

    /**
     * 将empBackTaskSheetSocialFeeSegmentPO转换成EmpBackTaskSheetSocialFeeSegmentResponseDTO
     * @param empBackTaskSheetSocialFeeSegmentPO
     * @return
     */
    public static EmpBackTaskSheetSocialFeeSegmentResponseDTO toEmpBackTaskSheetSocialFeeSegmentResponseDTO(EmpBackTaskSheetSocialFeeSegmentPO empBackTaskSheetSocialFeeSegmentPO){
        EmpBackTaskSheetSocialFeeSegmentResponseDTO empBackTaskSheetSocialFeeSegmentResponseDTO  = new EmpBackTaskSheetSocialFeeSegmentResponseDTO();
        BeanUtils.copyProperties(empBackTaskSheetSocialFeeSegmentPO, empBackTaskSheetSocialFeeSegmentResponseDTO);
        if (empBackTaskSheetSocialFeeSegmentResponseDTO.getCompanyPayMethod() != null) {
            empBackTaskSheetSocialFeeSegmentResponseDTO.setCompanyPayMethodLabel(PayMethodEnum.getValueByKey(empBackTaskSheetSocialFeeSegmentResponseDTO.getCompanyPayMethod()));
        }
        if (empBackTaskSheetSocialFeeSegmentResponseDTO.getEmployeePayMethod() != null) {
            empBackTaskSheetSocialFeeSegmentResponseDTO.setEmployeePayMethodLabel(PayMethodEnum.getValueByKey(empBackTaskSheetSocialFeeSegmentResponseDTO.getEmployeePayMethod()));
        }
        if (empBackTaskSheetSocialFeeSegmentResponseDTO.getSocialStatus() != null) {
            empBackTaskSheetSocialFeeSegmentResponseDTO.setSocialStatusLabel(SocialStatusEnum.getValueByKey(empBackTaskSheetSocialFeeSegmentResponseDTO.getSocialStatus()));
        }

        return empBackTaskSheetSocialFeeSegmentResponseDTO;
    }
}
