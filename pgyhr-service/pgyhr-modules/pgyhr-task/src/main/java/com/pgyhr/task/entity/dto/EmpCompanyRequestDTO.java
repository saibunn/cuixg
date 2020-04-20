package com.pgyhr.task.entity.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 客户雇员表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-20
 */
public class EmpCompanyRequestDTO implements Serializable {


    private static final long serialVersionUID = -2431191240434144210L;
    /**
     * 客户雇员ID
     */
    private String empCompanyId;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 雇员ID
     */
    private String employeeId;

    /**
     * 管理方ID
     */
    private String managementId;

    /**
     * 旧雇员ID
     */
    private String oldEmployeeId;

    /**
     * 渠道ID
     */
    private String channelId;

    /**
     * 雇员类型1: 派遣, 2: 代理, 3: 业务外包
     */
    private Integer templateType;

    /**
     * 入职日期
     */
    private LocalDateTime inDate;

    /**
     * 是否代办银行卡0 ：不是，1：是
     */
    private Integer isTransActBankCard;

    /**
     * 是否需要银行卡信息:0 ：不需要，1：需要
     */
    private Integer isNeedBankCard;

    /**
     * 银行卡种类:1: 建设银行, 2: 工商银行，3：招商银行4：中国银行 5:其他银行
     */
    private Integer bankType;

    /**
     * 银行卡号
     */
    private String bankCode;

    /**
     * 薪资
     */
    private BigDecimal salary;

    /**
     * 工资支付方式:0: 用工单位, 1: 蒲公英
     */
    private Integer salaryPayType;

    /**
     * 合同开始时间
     */
    private LocalDateTime laborStartDate;

    /**
     * 合同结束时间
     */
    private LocalDateTime laborEndDate;

    /**
     * 合同签订方:1: 蒲公英, 2: 蒲公英外包, 3: 客户代签, 4: 客户自签
     */
    private String laborSide;

    /**
     * 部门
     */
    private String deptName;

    /**
     * 员工编号
     */
    private String empCode;

    /**
     * 职务
     */
    private String position;

    /**
     * 员工公司邮箱
     */
    private String empPost;

    /**
     * 员工职业
     */
    private String empProfession;

    /**
     * 试用薪资
     */
    private BigDecimal trySalary;

    /**
     * 试用期开始时间
     */
    private LocalDateTime tryStartDate;

    /**
     * 试用期结束时间
     */
    private LocalDateTime tryEndDate;

    /**
     * 工时种类：0: 标准工时, 1: 不定时工时, 2: 综合工时
     */
    private Integer workType;

    /**
     * 入职类型: 1: 常规入职, 2: 集体转入
     */
    private Integer postType;

    /**
     * 用工形式:1: 全日制, 2: 非全日制
     */
    private Integer employStyle;

    /**
     * 社保福利办理方:1: 独立户, 2: 大库
     */
    private Integer socialUnit;

    /**
     * 社保福利办理方:1: 独立户, 2: 大库
     */
    private Integer fundUnit;

    /**
     * 用退工福利办理方:1: 独立户, 2: 大库
     */
    private Integer hireUnit;

    /**
     * 工作城市CODE
     */
    private String workCityCode;

    /**
     * 社保缴纳城市CODE
     */
    private String socialCityCode;

    /**
     * 公积金缴城市CODE
     */
    private String fundCityCode;

    /**
     * 离职时间
     */
    private LocalDateTime outDate;

    /**
     * 离职原因：1: 辞职,2: 协商解除,3: 公司解聘,4: 合同到期,5: 关闭,6: 出国,7: 退休,8: 工伤死亡,// 9: 取消入职,10: 死亡,11: 转科技人才,12: 转用工单位（翻牌）,13: 公司自行管理, 无需退工,14: 公司自行管理, 需办退工,15: 转其他公司管理, 无需退工,16: 转其他公司管理, 需办退工
     */
    private Integer outReason;

    /**
     * 社保停缴方式:1: 转出, 2: 封存
     */
    private Integer socialStopType;

    /**
     * 公积金停缴方式:1: 转出, 2: 封存
     */
    private Integer fundStopType;

    /**
     * 雇员材料位置
     */
    private String materialPosition;

    /**
     * 雇员入表方式:1:预录用2:雇员新增3:雇员翻牌
     */
    private Integer empInType;

    /**
     * 状态1:预录用 2:雇员信息确认中 3:在职 4:离职
     */
    private Integer status;

    /**
     * 紧急联系人
     */
    private String sos;

    /**
     * 紧急联系人电话
     */
    private String sosPhone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 离职备注
     */
    private String remarkOut;

    /**
     * 是否需要微信信息:0 ：不需要，1：需要
     */
    private Integer isUploadWechatData;

    /**
     * 微信ID
     */
    private String wechatCode;

    /**
     * 是否可用:0-禁用 1-可用 
     */
    private Boolean isActive;

    /**
     * 雇员上级ID
     */
    private String leadershipId;

    /**
     * 雇员上级姓名
     */
    private String leadershipName;

    /**
     * 劳动合同CODE
     */
    private String laborContractCode;

    /**
     * 岗位描述
     */
    private String jobContent;

    /**
     * 派遣期限
     */
    private String dispatchingTerm;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改人
     */
    private String modifiedBy;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;


    public String getEmpCompanyId() {
        return empCompanyId;
    }

    public void setEmpCompanyId(String empCompanyId) {
        this.empCompanyId = empCompanyId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getManagementId() {
        return managementId;
    }

    public void setManagementId(String managementId) {
        this.managementId = managementId;
    }

    public String getOldEmployeeId() {
        return oldEmployeeId;
    }

    public void setOldEmployeeId(String oldEmployeeId) {
        this.oldEmployeeId = oldEmployeeId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public LocalDateTime getInDate() {
        return inDate;
    }

    public void setInDate(LocalDateTime inDate) {
        this.inDate = inDate;
    }

    public Integer getIsTransActBankCard() {
        return isTransActBankCard;
    }

    public void setIsTransActBankCard(Integer isTransActBankCard) {
        this.isTransActBankCard = isTransActBankCard;
    }

    public Integer getIsNeedBankCard() {
        return isNeedBankCard;
    }

    public void setIsNeedBankCard(Integer isNeedBankCard) {
        this.isNeedBankCard = isNeedBankCard;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getSalaryPayType() {
        return salaryPayType;
    }

    public void setSalaryPayType(Integer salaryPayType) {
        this.salaryPayType = salaryPayType;
    }

    public LocalDateTime getLaborStartDate() {
        return laborStartDate;
    }

    public void setLaborStartDate(LocalDateTime laborStartDate) {
        this.laborStartDate = laborStartDate;
    }

    public LocalDateTime getLaborEndDate() {
        return laborEndDate;
    }

    public void setLaborEndDate(LocalDateTime laborEndDate) {
        this.laborEndDate = laborEndDate;
    }

    public String getLaborSide() {
        return laborSide;
    }

    public void setLaborSide(String laborSide) {
        this.laborSide = laborSide;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmpPost() {
        return empPost;
    }

    public void setEmpPost(String empPost) {
        this.empPost = empPost;
    }

    public String getEmpProfession() {
        return empProfession;
    }

    public void setEmpProfession(String empProfession) {
        this.empProfession = empProfession;
    }

    public BigDecimal getTrySalary() {
        return trySalary;
    }

    public void setTrySalary(BigDecimal trySalary) {
        this.trySalary = trySalary;
    }

    public LocalDateTime getTryStartDate() {
        return tryStartDate;
    }

    public void setTryStartDate(LocalDateTime tryStartDate) {
        this.tryStartDate = tryStartDate;
    }

    public LocalDateTime getTryEndDate() {
        return tryEndDate;
    }

    public void setTryEndDate(LocalDateTime tryEndDate) {
        this.tryEndDate = tryEndDate;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public Integer getEmployStyle() {
        return employStyle;
    }

    public void setEmployStyle(Integer employStyle) {
        this.employStyle = employStyle;
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

    public String getWorkCityCode() {
        return workCityCode;
    }

    public void setWorkCityCode(String workCityCode) {
        this.workCityCode = workCityCode;
    }

    public String getSocialCityCode() {
        return socialCityCode;
    }

    public void setSocialCityCode(String socialCityCode) {
        this.socialCityCode = socialCityCode;
    }

    public String getFundCityCode() {
        return fundCityCode;
    }

    public void setFundCityCode(String fundCityCode) {
        this.fundCityCode = fundCityCode;
    }

    public LocalDateTime getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDateTime outDate) {
        this.outDate = outDate;
    }

    public Integer getOutReason() {
        return outReason;
    }

    public void setOutReason(Integer outReason) {
        this.outReason = outReason;
    }

    public Integer getSocialStopType() {
        return socialStopType;
    }

    public void setSocialStopType(Integer socialStopType) {
        this.socialStopType = socialStopType;
    }

    public Integer getFundStopType() {
        return fundStopType;
    }

    public void setFundStopType(Integer fundStopType) {
        this.fundStopType = fundStopType;
    }

    public String getMaterialPosition() {
        return materialPosition;
    }

    public void setMaterialPosition(String materialPosition) {
        this.materialPosition = materialPosition;
    }

    public Integer getEmpInType() {
        return empInType;
    }

    public void setEmpInType(Integer empInType) {
        this.empInType = empInType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSos() {
        return sos;
    }

    public void setSos(String sos) {
        this.sos = sos;
    }

    public String getSosPhone() {
        return sosPhone;
    }

    public void setSosPhone(String sosPhone) {
        this.sosPhone = sosPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarkOut() {
        return remarkOut;
    }

    public void setRemarkOut(String remarkOut) {
        this.remarkOut = remarkOut;
    }

    public Integer getIsUploadWechatData() {
        return isUploadWechatData;
    }

    public void setIsUploadWechatData(Integer isUploadWechatData) {
        this.isUploadWechatData = isUploadWechatData;
    }

    public String getWechatCode() {
        return wechatCode;
    }

    public void setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getLeadershipId() {
        return leadershipId;
    }

    public void setLeadershipId(String leadershipId) {
        this.leadershipId = leadershipId;
    }

    public String getLeadershipName() {
        return leadershipName;
    }

    public void setLeadershipName(String leadershipName) {
        this.leadershipName = leadershipName;
    }

    public String getLaborContractCode() {
        return laborContractCode;
    }

    public void setLaborContractCode(String laborContractCode) {
        this.laborContractCode = laborContractCode;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getDispatchingTerm() {
        return dispatchingTerm;
    }

    public void setDispatchingTerm(String dispatchingTerm) {
        this.dispatchingTerm = dispatchingTerm;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "EmpCompanyPO{" +
        "empCompanyId=" + empCompanyId +
        ", companyId=" + companyId +
        ", employeeId=" + employeeId +
        ", managementId=" + managementId +
        ", oldEmployeeId=" + oldEmployeeId +
        ", channelId=" + channelId +
        ", templateType=" + templateType +
        ", inDate=" + inDate +
        ", isTransActBankCard=" + isTransActBankCard +
        ", isNeedBankCard=" + isNeedBankCard +
        ", bankType=" + bankType +
        ", bankCode=" + bankCode +
        ", salary=" + salary +
        ", salaryPayType=" + salaryPayType +
        ", laborStartDate=" + laborStartDate +
        ", laborEndDate=" + laborEndDate +
        ", laborSide=" + laborSide +
        ", deptName=" + deptName +
        ", empCode=" + empCode +
        ", position=" + position +
        ", empPost=" + empPost +
        ", empProfession=" + empProfession +
        ", trySalary=" + trySalary +
        ", tryStartDate=" + tryStartDate +
        ", tryEndDate=" + tryEndDate +
        ", workType=" + workType +
        ", postType=" + postType +
        ", employStyle=" + employStyle +
        ", socialUnit=" + socialUnit +
        ", fundUnit=" + fundUnit +
        ", hireUnit=" + hireUnit +
        ", workCityCode=" + workCityCode +
        ", socialCityCode=" + socialCityCode +
        ", fundCityCode=" + fundCityCode +
        ", outDate=" + outDate +
        ", outReason=" + outReason +
        ", socialStopType=" + socialStopType +
        ", fundStopType=" + fundStopType +
        ", materialPosition=" + materialPosition +
        ", empInType=" + empInType +
        ", status=" + status +
        ", sos=" + sos +
        ", sosPhone=" + sosPhone +
        ", remark=" + remark +
        ", remarkOut=" + remarkOut +
        ", isUploadWechatData=" + isUploadWechatData +
        ", wechatCode=" + wechatCode +
        ", isActive=" + isActive +
        ", leadershipId=" + leadershipId +
        ", leadershipName=" + leadershipName +
        ", laborContractCode=" + laborContractCode +
        ", jobContent=" + jobContent +
        ", dispatchingTerm=" + dispatchingTerm +
        ", version=" + version +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", modifiedBy=" + modifiedBy +
        ", modifiedTime=" + modifiedTime +
        "}";
    }
}
