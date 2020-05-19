package com.pgyhr.task.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeRequestDTO extends EmployeePageDTO implements Serializable {
    /**
     * 雇员姓名
     */
    private String employeeName;
    /**
     * 证件号码
     */
    private String idNum;
}
