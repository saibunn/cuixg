package com.pgyhr.task.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 前道任务单服务约定表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-07
 */
@Data
public class EmpFrontTaskSheetServiceAgreementDTO implements Serializable{

    private static final long serialVersionUID = 458849632588081507L;
    /**
     * 前道任务单服务约定ID
     */
    private Long empFrontTaskSheetServiceAgreementId;

    /**
     * 前道任务单服务约定名称
     */
    private String empFrontTaskSheetServiceAgreementName;

    /**
     * 任务单ID
     */
    private String empFrontTaskSheetCode;

    /**
     * 公司序号
     */
    private Long customerCompanyInfoId;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 工作城市CODE
     */
    private String workCityCode;

    /**
     * 工作城市名称
     */
    private String workCityName;

    /**
     * 社保缴纳城市CODE
     */
    private String socialCityCode;

    /**
     * 社保缴纳城市名称
     */
    private String socialCityName;

    /**
     * 公积金缴城市CODE
     */
    private String fundCityCode;

    /**
     * 公积金缴城市名称
     */
    private String fundCityName;
    /**
     * 社保情况:1-独立户 2-大库 0-不做
     */
    private Integer socialType;

    /**
     * 公积金情况:1-独立户 2-大库 0-不做
     */
    private Integer fundType;

    /**
     * 客户公司服务性质:0-派遣 1-代理 2-业务外包
     */
    private Integer companyServiceType;

    /**
     * 劳动合同签订方:1-蒲公英 2-蒲公英外包 3-客户代签 4-客户自签
     */
    private Integer contractLabourSignType;

    /**
     * 办理用工情况 :1-独立户  2-大库
     */
    private Integer handleWorkType;

    /**
     * 档案保管情况 :1-独立户  2-大库 0-不保管
     */
    private Integer fileKeepingType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否可用:0-禁用 1-可用 
     */
    private Boolean isActive;

    /**
     * 版本号
     */
    private Long version;


}
