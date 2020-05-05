package com.pgyhr.task.entity.translator;

import com.pgyhr.task.entity.dto.EmpFrontTaskSheetResponseDTO;
import com.pgyhr.task.entity.enums.RetreatStatusEnum;
import com.pgyhr.task.entity.enums.TaskStatusEnum;
import com.pgyhr.task.entity.enums.TaskTypeEnum;
import com.pgyhr.task.entity.enums.TerminationReasonEnum;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 前道任务单转换类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-03
 */
public class EmpFrontTaskSheetTranslator {

    /**
     * 将empFrontTaskSheetPO转换成EmpFrontTaskSheetPageRequestDTO
     * @param empFrontTaskSheetPO
     * @return
     */
    public static EmpFrontTaskSheetResponseDTO toTaskSheetResponseDTO(EmpFrontTaskSheetPO empFrontTaskSheetPO){
        EmpFrontTaskSheetResponseDTO empFrontTaskSheetPageRequestDTO = new EmpFrontTaskSheetResponseDTO();
        BeanUtils.copyProperties(empFrontTaskSheetPO, empFrontTaskSheetPageRequestDTO);
        if (empFrontTaskSheetPageRequestDTO.getTaskType() != null) {
            empFrontTaskSheetPageRequestDTO.setTaskTypeLabel(TaskTypeEnum.getValueByKey(empFrontTaskSheetPageRequestDTO.getTaskType()));
        }
        if (empFrontTaskSheetPageRequestDTO.getTaskStatus() != null) {
            empFrontTaskSheetPageRequestDTO.setTaskStatusLabel(TaskStatusEnum.getValueByKey(empFrontTaskSheetPageRequestDTO.getTaskStatus()));
        }
        if (empFrontTaskSheetPageRequestDTO.getRetreatStatus() != null) {
            empFrontTaskSheetPageRequestDTO.setRetreatStatusLabel(RetreatStatusEnum.getValueByKey(empFrontTaskSheetPageRequestDTO.getRetreatStatus()));
        }

        if (empFrontTaskSheetPageRequestDTO.getOutReason() != null) {
            empFrontTaskSheetPageRequestDTO.setOutReasonLabel(TerminationReasonEnum.getValueByKey(empFrontTaskSheetPageRequestDTO.getOutReason()));
        }

        return empFrontTaskSheetPageRequestDTO;
    }
}
