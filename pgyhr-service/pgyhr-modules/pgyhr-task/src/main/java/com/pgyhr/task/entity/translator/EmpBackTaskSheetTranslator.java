package com.pgyhr.task.entity.translator;

import com.pgyhr.task.entity.dto.EmpBackTaskSheetResponseDTO;
import com.pgyhr.task.entity.enums.RetreatStatusEnum;
import com.pgyhr.task.entity.enums.TaskStatusEnum;
import com.pgyhr.task.entity.enums.TaskTypeEnum;
import com.pgyhr.task.entity.enums.TerminationReasonEnum;
import com.pgyhr.task.entity.po.EmpBackTaskSheetPO;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 前道任务单转换类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-03
 */
public class EmpBackTaskSheetTranslator {

    /**
     * 将empBackTaskSheetPO转换成EmpBackTaskSheetPageRequestDTO
     * @param empBackTaskSheetPO
     * @return
     */
    public static EmpBackTaskSheetResponseDTO toTaskSheetResponseDTO(EmpBackTaskSheetPO empBackTaskSheetPO){
        EmpBackTaskSheetResponseDTO empBackTaskSheetPageRequestDTO = new EmpBackTaskSheetResponseDTO();
        BeanUtils.copyProperties(empBackTaskSheetPO, empBackTaskSheetPageRequestDTO);
        if (empBackTaskSheetPageRequestDTO.getTaskType() != null) {
            empBackTaskSheetPageRequestDTO.setTaskTypeLabel(TaskTypeEnum.getValueByKey(empBackTaskSheetPageRequestDTO.getTaskType()));
        }
        if (empBackTaskSheetPageRequestDTO.getTaskStatus() != null) {
            empBackTaskSheetPageRequestDTO.setTaskStatusLabel(TaskStatusEnum.getValueByKey(empBackTaskSheetPageRequestDTO.getTaskStatus()));
        }

        return empBackTaskSheetPageRequestDTO;
    }
}
