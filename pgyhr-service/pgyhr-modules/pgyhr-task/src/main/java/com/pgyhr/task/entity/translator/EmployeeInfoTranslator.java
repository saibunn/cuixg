package com.pgyhr.task.entity.translator;

import com.pgyhr.task.entity.dto.EmployeeInfoResponseDTO;
import com.pgyhr.task.entity.enums.*;
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
public class EmployeeInfoTranslator {

    /**
     * 将employeeInfoPO转换成EmployeeInfoResponseDTO
     * @param employeeInfoPO
     * @return
     */
    public static EmployeeInfoResponseDTO toEmployeeInfoResponseDTO(EmployeeInfoPO employeeInfoPO){
        EmployeeInfoResponseDTO employeeInfoResponseDTO  = new EmployeeInfoResponseDTO();
        BeanUtils.copyProperties(employeeInfoPO, employeeInfoResponseDTO);
        if (employeeInfoResponseDTO.getIdCardType() != null) {
            employeeInfoResponseDTO.setIdCardTypeLabel(IdCardTypeEnum.getValueByKey(employeeInfoResponseDTO.getIdCardType()));
        }
        if (employeeInfoResponseDTO.getResidentType() != null) {
            employeeInfoResponseDTO.setResidentTypeLabel(ResidentTypeEnum.getValueByKey(employeeInfoResponseDTO.getResidentType()));
        }
        if (employeeInfoResponseDTO.getGender() != null) {
            employeeInfoResponseDTO.setGenderLabel(GenderTypeEnum.getValueByKey(employeeInfoResponseDTO.getGender()));
        }

        return employeeInfoResponseDTO;
    }
}
