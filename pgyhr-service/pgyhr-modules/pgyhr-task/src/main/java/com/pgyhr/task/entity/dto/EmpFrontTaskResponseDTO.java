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
public class EmpFrontTaskResponseDTO implements Serializable {

    private static final long serialVersionUID = -3166363412416468427L;

    private EmployeeInfoResponseDTO employeeInfoResponseDTO;

    private EmpCompanyResponseDTO empCompanyResponseDTO;

    private EmpFrontTaskSheetResponseDTO empFrontTaskSheetResponseDTO;

    private List<EmpFrontTaskSheetSocialFeeSegmentResponseDTO> empFrontTaskSheetSocialFeeSegmentResponseDTOList;
}
