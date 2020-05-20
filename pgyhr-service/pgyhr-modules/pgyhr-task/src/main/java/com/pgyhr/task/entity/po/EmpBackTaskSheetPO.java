package com.pgyhr.task.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 雇员后道任务单表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-07
 */
@TableName("p_emp_back_task_sheet")
public class EmpBackTaskSheetPO extends PgyhrBaseEntityNoId<EmpBackTaskSheetPO> {

    private static final long serialVersionUID=1L;

    /**
     * 雇员后道任务单ID
     */
    @TableId(value = "emp_back_task_sheet_code")
    private String empBackTaskSheetCode;

    /**
     * 雇员前道任务单ID
     */
    private String empFrontTaskSheetCode;

    /**
     * 任务单域:0-前道，1-后道
     */
    private Integer taskArea;

    /**
     * 任务单状态:0-后道批退,1-前道提交,2-后道客服确认,3-后道专员确认,4-后道部分完成,5-后道完成,
     */
    private Integer taskStatus;

    /**
     * 任务单类型:0-新增,1-调整,2-年度调整,3-终止,4-一次性费用,5-服务费调整
     */
    private Integer taskType;

    /**
     * 任务单城市code
     */
    private String cityCode;

    /**
     * 任务单城市名称
     */
    private String cityName;

    /**
     * 执行城市ID
     */
    private String executeCityId;

    /**
     * 执行城市名称
     */
    private String executeCityName;

    /**
     * 委托机构ID
     */
    private String entrustOrganizationId;

    /**
     * 委托机构名称
     */
    private String entrustOrganizationName;

    /**
     * 客户雇员ID
     */
    private String empCompanyId;

    /**
     * 雇员编号
     */
    private String employeeId;

    /**
     * 雇员姓名
     */
    private String employeeName;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 办理用工日期
     */
    private LocalDateTime employmentDate;

    /**
     * 合同开始日期
     */
    private LocalDateTime contractStartDate;

    /**
     * 合同结束日期
     */
    private LocalDateTime contractEndDate;

    /**
     * 雇员公积金账号
     */
    private String employeesFundAccount;

    /**
     * 雇员社保账号
     */
    private String employeesSocialAccount;

    /**
     * 社保福利办理方:1: 独立户, 2: 大库
     */
    private Integer socialUnit;

    /**
     * 公积金福利办理方:1: 独立户, 2: 大库
     */
    private Integer fundUnit;

    /**
     * 用退工福利办理方:1: 独立户, 2: 大库
     */
    private Integer hireUnit;

    /**
     * 服务产品反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private Integer serviceProductStatus;

    /**
     * 服务产品反馈日期
     */
    private LocalDateTime serviceProductStatusDate;

    /**
     * 服务产品执行年月
     */
    private LocalDateTime serviceProductStartDate;

    /**
     * 服务产品结束年月
     */
    private LocalDateTime serviceProductEndDate;

    /**
     * 档案所在地
     */
    private String fileAddress;

    /**
     * 档案保管费
     */
    private BigDecimal fileKeepFee;

    /**
     * 档案保管费反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private Integer fileKeepFeeStatus;

    /**
     * 档案保管费反馈日期
     */
    private LocalDateTime fileKeepFeeStatusDate;

    /**
     * 档案费执行年月
     */
    private LocalDateTime fileKeepFeeStartDate;

    /**
     * 档案费结束年月
     */
    private LocalDateTime fileKeepFeeEndDate;

    /**
     * 额外费用
     */
    private BigDecimal otherFee;

    /**
     * 额外费用反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private Integer otherFeeStatus;

    /**
     * 额外费用反馈日期
     */
    private LocalDateTime otherFeeStatusDate;

    /**
     * 额外费用执行年月
     */
    private LocalDateTime otherFeeStartDate;

    /**
     * 额外费用结束年月
     */
    private LocalDateTime otherFeeEndDate;

    /**
     * 实际工资
     */
    private BigDecimal actualWage;

    /**
     * 前道服务费
     */
    private BigDecimal frontServiceFee;

    /**
     * 服务费
     */
    private BigDecimal serviceFee;

    /**
     * 服务费反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private Integer serviceFeeStatus;

    /**
     * 服务费反馈日期
     */
    private LocalDateTime serviceFeeStatusDate;

    /**
     * 服档费:0-服务费不包括档案费，1-服务费包括档案费
     */
    private Integer serviceFileFeeStatus;

    /**
     * 离职原因：1: 辞职,2: 协商解除,3: 公司解聘,4: 合同到期,5: 关闭,6: 出国,7: 退休,8: 工伤死亡,// 9: 取消入职,10: 死亡,11: 转科技人才,12: 转用工单位（翻牌）,13: 公司自行管理, 无需退工,14: 公司自行管理, 需办退工,15: 转其他公司管理, 无需退工,16: 转其他公司管理, 需办退工
     */
    private Integer outReason;

    /**
     * 离职日期
     */
    private LocalDateTime outDate;

    /**
     * 批退审核结果
     */
    private String retreatExamineResult;

    /**
     * 批退原因
     */
    private String retreatReason;

    /**
     * 批退状态:0-正常，1-未处理，2-已拒绝，3-已批退
     */
    private Integer retreatStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 备注类型:0-社保，1-公积金，2-其它
     */
    private Integer remarkType;

    /**
     * 服务协议ID
     */
    private String serviceAgreementId;

    /**
     * 是否可用:0-禁用 1-可用 
     */
    private Boolean isActive;

    /**
     * 版本号
     */
    private Long version;


    public String getEmpBackTaskSheetCode() {
        return empBackTaskSheetCode;
    }

    public void setEmpBackTaskSheetCode(String empBackTaskSheetCode) {
        this.empBackTaskSheetCode = empBackTaskSheetCode;
    }

    public Integer getTaskArea() {
        return taskArea;
    }

    public void setTaskArea(Integer taskArea) {
        this.taskArea = taskArea;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
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

    public String getExecuteCityId() {
        return executeCityId;
    }

    public void setExecuteCityId(String executeCityId) {
        this.executeCityId = executeCityId;
    }

    public String getExecuteCityName() {
        return executeCityName;
    }

    public void setExecuteCityName(String executeCityName) {
        this.executeCityName = executeCityName;
    }

    public String getEntrustOrganizationId() {
        return entrustOrganizationId;
    }

    public void setEntrustOrganizationId(String entrustOrganizationId) {
        this.entrustOrganizationId = entrustOrganizationId;
    }

    public String getEntrustOrganizationName() {
        return entrustOrganizationName;
    }

    public void setEntrustOrganizationName(String entrustOrganizationName) {
        this.entrustOrganizationName = entrustOrganizationName;
    }

    public String getEmpCompanyId() {
        return empCompanyId;
    }

    public void setEmpCompanyId(String empCompanyId) {
        this.empCompanyId = empCompanyId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public LocalDateTime getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDateTime employmentDate) {
        this.employmentDate = employmentDate;
    }

    public LocalDateTime getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDateTime contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDateTime getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDateTime contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getEmployeesFundAccount() {
        return employeesFundAccount;
    }

    public void setEmployeesFundAccount(String employeesFundAccount) {
        this.employeesFundAccount = employeesFundAccount;
    }

    public String getEmployeesSocialAccount() {
        return employeesSocialAccount;
    }

    public void setEmployeesSocialAccount(String employeesSocialAccount) {
        this.employeesSocialAccount = employeesSocialAccount;
    }

    public Integer getSocialUnit() {
        return socialUnit;
    }

    public void setSocialUnit(Integer socialUnit) {
        this.socialUnit = socialUnit;
    }

    public Integer getFundUnit() {
        return fundUnit;
    }

    public void setFundUnit(Integer fundUnit) {
        this.fundUnit = fundUnit;
    }

    public Integer getHireUnit() {
        return hireUnit;
    }

    public void setHireUnit(Integer hireUnit) {
        this.hireUnit = hireUnit;
    }

    public Integer getServiceProductStatus() {
        return serviceProductStatus;
    }

    public void setServiceProductStatus(Integer serviceProductStatus) {
        this.serviceProductStatus = serviceProductStatus;
    }

    public LocalDateTime getServiceProductStatusDate() {
        return serviceProductStatusDate;
    }

    public void setServiceProductStatusDate(LocalDateTime serviceProductStatusDate) {
        this.serviceProductStatusDate = serviceProductStatusDate;
    }

    public LocalDateTime getServiceProductStartDate() {
        return serviceProductStartDate;
    }

    public void setServiceProductStartDate(LocalDateTime serviceProductStartDate) {
        this.serviceProductStartDate = serviceProductStartDate;
    }

    public LocalDateTime getServiceProductEndDate() {
        return serviceProductEndDate;
    }

    public void setServiceProductEndDate(LocalDateTime serviceProductEndDate) {
        this.serviceProductEndDate = serviceProductEndDate;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public BigDecimal getFileKeepFee() {
        return fileKeepFee;
    }

    public void setFileKeepFee(BigDecimal fileKeepFee) {
        this.fileKeepFee = fileKeepFee;
    }

    public Integer getFileKeepFeeStatus() {
        return fileKeepFeeStatus;
    }

    public void setFileKeepFeeStatus(Integer fileKeepFeeStatus) {
        this.fileKeepFeeStatus = fileKeepFeeStatus;
    }

    public LocalDateTime getFileKeepFeeStatusDate() {
        return fileKeepFeeStatusDate;
    }

    public void setFileKeepFeeStatusDate(LocalDateTime fileKeepFeeStatusDate) {
        this.fileKeepFeeStatusDate = fileKeepFeeStatusDate;
    }

    public LocalDateTime getFileKeepFeeStartDate() {
        return fileKeepFeeStartDate;
    }

    public void setFileKeepFeeStartDate(LocalDateTime fileKeepFeeStartDate) {
        this.fileKeepFeeStartDate = fileKeepFeeStartDate;
    }

    public LocalDateTime getFileKeepFeeEndDate() {
        return fileKeepFeeEndDate;
    }

    public void setFileKeepFeeEndDate(LocalDateTime fileKeepFeeEndDate) {
        this.fileKeepFeeEndDate = fileKeepFeeEndDate;
    }

    public BigDecimal getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    public Integer getOtherFeeStatus() {
        return otherFeeStatus;
    }

    public void setOtherFeeStatus(Integer otherFeeStatus) {
        this.otherFeeStatus = otherFeeStatus;
    }

    public LocalDateTime getOtherFeeStatusDate() {
        return otherFeeStatusDate;
    }

    public void setOtherFeeStatusDate(LocalDateTime otherFeeStatusDate) {
        this.otherFeeStatusDate = otherFeeStatusDate;
    }

    public LocalDateTime getOtherFeeStartDate() {
        return otherFeeStartDate;
    }

    public void setOtherFeeStartDate(LocalDateTime otherFeeStartDate) {
        this.otherFeeStartDate = otherFeeStartDate;
    }

    public LocalDateTime getOtherFeeEndDate() {
        return otherFeeEndDate;
    }

    public void setOtherFeeEndDate(LocalDateTime otherFeeEndDate) {
        this.otherFeeEndDate = otherFeeEndDate;
    }

    public BigDecimal getActualWage() {
        return actualWage;
    }

    public void setActualWage(BigDecimal actualWage) {
        this.actualWage = actualWage;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getServiceFeeStatus() {
        return serviceFeeStatus;
    }

    public void setServiceFeeStatus(Integer serviceFeeStatus) {
        this.serviceFeeStatus = serviceFeeStatus;
    }

    public LocalDateTime getServiceFeeStatusDate() {
        return serviceFeeStatusDate;
    }

    public void setServiceFeeStatusDate(LocalDateTime serviceFeeStatusDate) {
        this.serviceFeeStatusDate = serviceFeeStatusDate;
    }

    public Integer getServiceFileFeeStatus() {
        return serviceFileFeeStatus;
    }

    public void setServiceFileFeeStatus(Integer serviceFileFeeStatus) {
        this.serviceFileFeeStatus = serviceFileFeeStatus;
    }

    public Integer getOutReason() {
        return outReason;
    }

    public void setOutReason(Integer outReason) {
        this.outReason = outReason;
    }

    public LocalDateTime getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDateTime outDate) {
        this.outDate = outDate;
    }

    public String getRetreatExamineResult() {
        return retreatExamineResult;
    }

    public void setRetreatExamineResult(String retreatExamineResult) {
        this.retreatExamineResult = retreatExamineResult;
    }

    public String getRetreatReason() {
        return retreatReason;
    }

    public void setRetreatReason(String retreatReason) {
        this.retreatReason = retreatReason;
    }

    public Integer getRetreatStatus() {
        return retreatStatus;
    }

    public void setRetreatStatus(Integer retreatStatus) {
        this.retreatStatus = retreatStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRemarkType() {
        return remarkType;
    }

    public void setRemarkType(Integer remarkType) {
        this.remarkType = remarkType;
    }

    public String getServiceAgreementId() {
        return serviceAgreementId;
    }

    public void setServiceAgreementId(String serviceAgreementId) {
        this.serviceAgreementId = serviceAgreementId;
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

    public String getEmpFrontTaskSheetCode() {
        return empFrontTaskSheetCode;
    }

    public void setEmpFrontTaskSheetCode(String empFrontTaskSheetCode) {
        this.empFrontTaskSheetCode = empFrontTaskSheetCode;
    }

    public BigDecimal getFrontServiceFee() {
        return frontServiceFee;
    }

    public void setFrontServiceFee(BigDecimal frontServiceFee) {
        this.frontServiceFee = frontServiceFee;
    }

    @Override
    protected Serializable pkVal() {
        return this.empBackTaskSheetCode;
    }

    @Override
    public String toString() {
        return "EmpBackTaskSheetPO{" +
        "empBackTaskSheetCode=" + empBackTaskSheetCode +
        ", taskArea=" + taskArea +
        ", taskStatus=" + taskStatus +
        ", taskType=" + taskType +
        ", cityCode=" + cityCode +
        ", cityName=" + cityName +
        ", executeCityId=" + executeCityId +
        ", executeCityName=" + executeCityName +
        ", entrustOrganizationId=" + entrustOrganizationId +
        ", entrustOrganizationName=" + entrustOrganizationName +
        ", empCompanyId=" + empCompanyId +
        ", employeeId=" + employeeId +
        ", employeeName=" + employeeName +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", employmentDate=" + employmentDate +
        ", contractStartDate=" + contractStartDate +
        ", contractEndDate=" + contractEndDate +
        ", employeesFundAccount=" + employeesFundAccount +
        ", employeesSocialAccount=" + employeesSocialAccount +
        ", socialUnit=" + socialUnit +
        ", fundUnit=" + fundUnit +
        ", hireUnit=" + hireUnit +
        ", serviceProductStatus=" + serviceProductStatus +
        ", serviceProductStatusDate=" + serviceProductStatusDate +
        ", serviceProductStartDate=" + serviceProductStartDate +
        ", serviceProductEndDate=" + serviceProductEndDate +
        ", fileAddress=" + fileAddress +
        ", fileKeepFee=" + fileKeepFee +
        ", fileKeepFeeStatus=" + fileKeepFeeStatus +
        ", fileKeepFeeStatusDate=" + fileKeepFeeStatusDate +
        ", fileKeepFeeStartDate=" + fileKeepFeeStartDate +
        ", fileKeepFeeEndDate=" + fileKeepFeeEndDate +
        ", otherFee=" + otherFee +
        ", otherFeeStatus=" + otherFeeStatus +
        ", otherFeeStatusDate=" + otherFeeStatusDate +
        ", otherFeeStartDate=" + otherFeeStartDate +
        ", otherFeeEndDate=" + otherFeeEndDate +
        ", actualWage=" + actualWage +
        ", serviceFee=" + serviceFee +
        ", serviceFeeStatus=" + serviceFeeStatus +
        ", serviceFeeStatusDate=" + serviceFeeStatusDate +
        ", serviceFileFeeStatus=" + serviceFileFeeStatus +
        ", outReason=" + outReason +
        ", outDate=" + outDate +
        ", retreatExamineResult=" + retreatExamineResult +
        ", retreatReason=" + retreatReason +
        ", retreatStatus=" + retreatStatus +
        ", remark=" + remark +
        ", remarkType=" + remarkType +
        ", serviceAgreementId=" + serviceAgreementId +
        ", isActive=" + isActive +
        ", version=" + version +
        "}";
    }
}
