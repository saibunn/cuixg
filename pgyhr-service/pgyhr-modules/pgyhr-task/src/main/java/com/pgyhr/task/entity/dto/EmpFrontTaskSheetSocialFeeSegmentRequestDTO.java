package com.pgyhr.task.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 前道任务单社保费用段表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-26
 */
@Data
public class EmpFrontTaskSheetSocialFeeSegmentRequestDTO implements Serializable {

    private static final long serialVersionUID = 5251848424917465544L;

    /**
     * 雇员前道任务单Code
     */
    private String empFrontTaskSheetCode;

    /**
     * 社保政策CODE
     */
    private String socialPolicyCode;

    /**
     * 公积金政策CODE
     */
    private String fundlPolicyCode;

    /**
     * 请求类型
     */
    private Integer requestType;

    /**
     * 社保城市CODE
     */
    private String cityCode;

    /**
     * 开始日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date starDate;


}