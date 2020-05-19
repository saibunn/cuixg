package com.pgyhr.task.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmpCompanyWhereDTO extends CommonListDTO implements Serializable {
    private String empCompanyId;
    private String companyName;
    private String employeeName;
}
