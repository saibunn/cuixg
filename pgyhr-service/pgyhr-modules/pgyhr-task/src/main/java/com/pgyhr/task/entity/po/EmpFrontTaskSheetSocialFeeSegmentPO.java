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
 * 前道任务单社保费用段表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-26
 */
@TableName("p_emp_front_task_sheet_social_fee_segment")
public class EmpFrontTaskSheetSocialFeeSegmentPO extends PgyhrBaseEntityNoId<EmpFrontTaskSheetSocialFeeSegmentPO> {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "emp_front_task_sheet_social_fee_segment_id", type = IdType.AUTO)
    private Long empFrontTaskSheetSocialFeeSegmentId;

    /**
     * 任务单ID
     */
    private String empFrontTaskSheetId;

    /**
     * 雇员编号
     */
    private String employeeId;

    /**
     * 雇员姓名
     */
    private String employeeName;

    /**
     * 雇员服务协议ID
     */
    private String empAgreementId;

    /**
     * 社保ID
     */
    private String policyId;

    /**
     * 社保类型
     */
    private Integer policyType;

    /**
     * 数据字典CODE
     */
    private String itemCode;

    /**
     * 社保产品名称: 养老，医疗，工伤，生育，失业，公积金，补充公积金等
     */
    private String itemName;

    /**
     * 社保城市CODE
     */
    private String cityCode;

    /**
     * 社保城市名称
     */
    private String cityName;

    /**
     * 社保项目名称
     */
    private String socialName;

    /**
     * 反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private Integer socialStatus;

    /**
     * 反馈日期
     */
    private LocalDateTime socialStatusDate;

    /**
     * 申请日期
     */
    private LocalDateTime applyDate;

    /**
     * 办理日期
     */
    private LocalDateTime handleDate;

    /**
     * 执行日期
     */
    private LocalDateTime executeDate;

    /**
     * 缴纳开始月(yyyy-MM格式)
     */
    private LocalDateTime startDate;

    /**
     * 缴纳结束月(yyyy-MM格式)
     */
    private LocalDateTime endDate;

    /**
     * 缴纳开始月确认月(yyyy-MM格式)
     */
    private LocalDateTime startConfirmDate;

    /**
     * 缴纳结束月确认月(yyyy-MM格式)
     */
    private LocalDateTime endConfirmDate;

    /**
     * 公司付款方式:1-公司自付，2-管理费
     */
    private Integer companyPayMethod;

    /**
     * 雇员付款方式:0-个人工资，2-管理费
     */
    private Integer employeePayMethod;

    /**
     * 公司基数
     */
    private BigDecimal companyBase;

    /**
     * 企业实缴基数（机构反馈金额）
     */
    private BigDecimal companyConfirmBase;

    /**
     * 公司比例
     */
    private BigDecimal companyRatio;

    /**
     * 公司金额
     */
    private BigDecimal companyAmount;

    /**
     * 公司固定金额
     */
    private BigDecimal companyFixAmount;

    /**
     * 个人基数
     */
    private BigDecimal personalBase;

    /**
     * 个人实缴基数（机构反馈金额）
     */
    private BigDecimal personalConfirmBase;

    /**
     * 个人比例
     */
    private BigDecimal personalRatio;

    /**
     * 个人金额
     */
    private BigDecimal personalAmount;

    /**
     * 个人固定金额
     */
    private BigDecimal personalFixAmount;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

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


    public Long getEmpFrontTaskSheetSocialFeeSegmentId() {
        return empFrontTaskSheetSocialFeeSegmentId;
    }

    public void setEmpFrontTaskSheetSocialFeeSegmentId(Long empFrontTaskSheetSocialFeeSegmentId) {
        this.empFrontTaskSheetSocialFeeSegmentId = empFrontTaskSheetSocialFeeSegmentId;
    }

    public String getEmpFrontTaskSheetId() {
        return empFrontTaskSheetId;
    }

    public void setEmpFrontTaskSheetId(String empFrontTaskSheetId) {
        this.empFrontTaskSheetId = empFrontTaskSheetId;
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

    public String getEmpAgreementId() {
        return empAgreementId;
    }

    public void setEmpAgreementId(String empAgreementId) {
        this.empAgreementId = empAgreementId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public Integer getPolicyType() {
        return policyType;
    }

    public void setPolicyType(Integer policyType) {
        this.policyType = policyType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public Integer getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(Integer socialStatus) {
        this.socialStatus = socialStatus;
    }

    public LocalDateTime getSocialStatusDate() {
        return socialStatusDate;
    }

    public void setSocialStatusDate(LocalDateTime socialStatusDate) {
        this.socialStatusDate = socialStatusDate;
    }

    public LocalDateTime getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDateTime applyDate) {
        this.applyDate = applyDate;
    }

    public LocalDateTime getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(LocalDateTime handleDate) {
        this.handleDate = handleDate;
    }

    public LocalDateTime getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(LocalDateTime executeDate) {
        this.executeDate = executeDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getStartConfirmDate() {
        return startConfirmDate;
    }

    public void setStartConfirmDate(LocalDateTime startConfirmDate) {
        this.startConfirmDate = startConfirmDate;
    }

    public LocalDateTime getEndConfirmDate() {
        return endConfirmDate;
    }

    public void setEndConfirmDate(LocalDateTime endConfirmDate) {
        this.endConfirmDate = endConfirmDate;
    }

    public Integer getCompanyPayMethod() {
        return companyPayMethod;
    }

    public void setCompanyPayMethod(Integer companyPayMethod) {
        this.companyPayMethod = companyPayMethod;
    }

    public Integer getEmployeePayMethod() {
        return employeePayMethod;
    }

    public void setEmployeePayMethod(Integer employeePayMethod) {
        this.employeePayMethod = employeePayMethod;
    }

    public BigDecimal getCompanyBase() {
        return companyBase;
    }

    public void setCompanyBase(BigDecimal companyBase) {
        this.companyBase = companyBase;
    }

    public BigDecimal getCompanyConfirmBase() {
        return companyConfirmBase;
    }

    public void setCompanyConfirmBase(BigDecimal companyConfirmBase) {
        this.companyConfirmBase = companyConfirmBase;
    }

    public BigDecimal getCompanyRatio() {
        return companyRatio;
    }

    public void setCompanyRatio(BigDecimal companyRatio) {
        this.companyRatio = companyRatio;
    }

    public BigDecimal getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(BigDecimal companyAmount) {
        this.companyAmount = companyAmount;
    }

    public BigDecimal getCompanyFixAmount() {
        return companyFixAmount;
    }

    public void setCompanyFixAmount(BigDecimal companyFixAmount) {
        this.companyFixAmount = companyFixAmount;
    }

    public BigDecimal getPersonalBase() {
        return personalBase;
    }

    public void setPersonalBase(BigDecimal personalBase) {
        this.personalBase = personalBase;
    }

    public BigDecimal getPersonalConfirmBase() {
        return personalConfirmBase;
    }

    public void setPersonalConfirmBase(BigDecimal personalConfirmBase) {
        this.personalConfirmBase = personalConfirmBase;
    }

    public BigDecimal getPersonalRatio() {
        return personalRatio;
    }

    public void setPersonalRatio(BigDecimal personalRatio) {
        this.personalRatio = personalRatio;
    }

    public BigDecimal getPersonalAmount() {
        return personalAmount;
    }

    public void setPersonalAmount(BigDecimal personalAmount) {
        this.personalAmount = personalAmount;
    }

    public BigDecimal getPersonalFixAmount() {
        return personalFixAmount;
    }

    public void setPersonalFixAmount(BigDecimal personalFixAmount) {
        this.personalFixAmount = personalFixAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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
        return this.empFrontTaskSheetSocialFeeSegmentId;
    }

    @Override
    public String toString() {
        return "EmpFrontTaskSheetSocialFeeSegmentPO{" +
                "empFrontTaskSheetSocialFeeSegmentId=" + empFrontTaskSheetSocialFeeSegmentId +
                ", empFrontTaskSheetId=" + empFrontTaskSheetId +
                ", employeeId=" + employeeId +
                ", employeeName=" + employeeName +
                ", empAgreementId=" + empAgreementId +
                ", policyId=" + policyId +
                ", policyType=" + policyType +
                ", itemCode=" + itemCode +
                ", itemName=" + itemName +
                ", cityCode=" + cityCode +
                ", cityName=" + cityName +
                ", socialName=" + socialName +
                ", socialStatus=" + socialStatus +
                ", socialStatusDate=" + socialStatusDate +
                ", applyDate=" + applyDate +
                ", handleDate=" + handleDate +
                ", executeDate=" + executeDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startConfirmDate=" + startConfirmDate +
                ", endConfirmDate=" + endConfirmDate +
                ", companyPayMethod=" + companyPayMethod +
                ", employeePayMethod=" + employeePayMethod +
                ", companyBase=" + companyBase +
                ", companyConfirmBase=" + companyConfirmBase +
                ", companyRatio=" + companyRatio +
                ", companyAmount=" + companyAmount +
                ", companyFixAmount=" + companyFixAmount +
                ", personalBase=" + personalBase +
                ", personalConfirmBase=" + personalConfirmBase +
                ", personalRatio=" + personalRatio +
                ", personalAmount=" + personalAmount +
                ", personalFixAmount=" + personalFixAmount +
                ", totalAmount=" + totalAmount +
                ", remark=" + remark +
                ", isActive=" + isActive +
                ", version=" + version +
                "}";
    }
}