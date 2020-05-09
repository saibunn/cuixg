package com.pgyhr.task.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName EmpFrontTaskSaveRequestDTO
 * @Description
 * @Author xiaoguang.cui
 * @Date 2020/5/9 11:27
 * @Version V1.0
 **/
@Data
public class EmpBackTaskResponseDTO implements Serializable {


    private static final long serialVersionUID = -1948880040260713031L;
    private EmployeeInfoResponseDTO employeeInfoResponseDTO;

    private EmpCompanyResponseDTO empCompanyResponseDTO;

    private EmpBackTaskSheetResponseDTO empBackTaskSheetResponseDTO;

    private List<EmpBackTaskSheetSocialFeeSegmentResponseDTO> empBackTaskSheetSocialFeeSegmentResponseDTOList;
}
