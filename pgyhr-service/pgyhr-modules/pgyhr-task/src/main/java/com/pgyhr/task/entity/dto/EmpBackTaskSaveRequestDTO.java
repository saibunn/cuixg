package com.pgyhr.task.entity.dto;

import com.pgyhr.task.entity.po.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName EmpFrontTaskSaveRequestDTO
 * @Description
 * @Author xiaoguang.cui
 * @Date 2020/05/13
 * @Version V1.0
 **/
@Data
public class EmpBackTaskSaveRequestDTO implements Serializable {

    private static final long serialVersionUID = -5860352817277000960L;

    private EmpBackTaskSheetPO empFrontTaskSheetPO;


    private List<EmpBackTaskSheetSocialFeeSegmentRequestDTO> empBackTaskSheetSocialFeeSegmentRequestDTOList;
}
