package com.pgyhr.task.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 前道任务单服务约定表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-26
 */
@TableName("p_emp_front_task_sheet_service_agreement")
public class EmpFrontTaskSheetServiceAgreementPO extends PgyhrBaseEntityNoId<EmpFrontTaskSheetServiceAgreementPO> {

    private static final long serialVersionUID=1L;

    /**
     * 前道任务单服务约定ID
     */
    @TableId(value = "emp_front_task_sheet_service_agreement_id", type = IdType.AUTO)
    private Long empFrontTaskSheetServiceAgreementId;

    /**
     * 前道任务单服务约定名称
     */
    private String empFrontTaskSheetServiceAgreementName;

    /**
     * 任务单ID
     */
    private String empFrontTaskSheetId;

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
     * 执行城市ID
     */
    private String cityCode;

    /**
     * 执行城市名称
     */
    private String cityName;

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



    public Long getEmpFrontTaskSheetServiceAgreementId() {
        return empFrontTaskSheetServiceAgreementId;
    }

    public void setEmpFrontTaskSheetServiceAgreementId(Long empFrontTaskSheetServiceAgreementId) {
        this.empFrontTaskSheetServiceAgreementId = empFrontTaskSheetServiceAgreementId;
    }

    public String getEmpFrontTaskSheetServiceAgreementName() {
        return empFrontTaskSheetServiceAgreementName;
    }

    public void setEmpFrontTaskSheetServiceAgreementName(String empFrontTaskSheetServiceAgreementName) {
        this.empFrontTaskSheetServiceAgreementName = empFrontTaskSheetServiceAgreementName;
    }

    public String getEmpFrontTaskSheetId() {
        return empFrontTaskSheetId;
    }

    public void setEmpFrontTaskSheetId(String empFrontTaskSheetId) {
        this.empFrontTaskSheetId = empFrontTaskSheetId;
    }

    public Long getCustomerCompanyInfoId() {
        return customerCompanyInfoId;
    }

    public void setCustomerCompanyInfoId(Long customerCompanyInfoId) {
        this.customerCompanyInfoId = customerCompanyInfoId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getSocialType() {
        return socialType;
    }

    public void setSocialType(Integer socialType) {
        this.socialType = socialType;
    }

    public Integer getFundType() {
        return fundType;
    }

    public void setFundType(Integer fundType) {
        this.fundType = fundType;
    }

    public Integer getCompanyServiceType() {
        return companyServiceType;
    }

    public void setCompanyServiceType(Integer companyServiceType) {
        this.companyServiceType = companyServiceType;
    }

    public Integer getContractLabourSignType() {
        return contractLabourSignType;
    }

    public void setContractLabourSignType(Integer contractLabourSignType) {
        this.contractLabourSignType = contractLabourSignType;
    }

    public Integer getHandleWorkType() {
        return handleWorkType;
    }

    public void setHandleWorkType(Integer handleWorkType) {
        this.handleWorkType = handleWorkType;
    }

    public Integer getFileKeepingType() {
        return fileKeepingType;
    }

    public void setFileKeepingType(Integer fileKeepingType) {
        this.fileKeepingType = fileKeepingType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.empFrontTaskSheetServiceAgreementId;
    }

    @Override
    public String toString() {
        return "EmpFrontTaskSheetServiceAgreementPO{" +
        "empFrontTaskSheetServiceAgreementId=" + empFrontTaskSheetServiceAgreementId +
        ", empFrontTaskSheetServiceAgreementName=" + empFrontTaskSheetServiceAgreementName +
        ", empFrontTaskSheetId=" + empFrontTaskSheetId +
        ", customerCompanyInfoId=" + customerCompanyInfoId +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", cityCode=" + cityCode +
        ", cityName=" + cityName +
        ", socialType=" + socialType +
        ", fundType=" + fundType +
        ", companyServiceType=" + companyServiceType +
        ", contractLabourSignType=" + contractLabourSignType +
        ", handleWorkType=" + handleWorkType +
        ", fileKeepingType=" + fileKeepingType +
        ", remark=" + remark +
        ", isActive=" + isActive +
        ", version=" + version +
        "}";
    }
}
