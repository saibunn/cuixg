package com.pgyhr.task.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 雇员信息表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-20
 */
@TableName("p_employee_info")
public class EmployeeInfoPO extends PgyhrBaseEntityNoId {

    private static final long serialVersionUID=1L;

    /**
     * 雇员编号
     */
    @TableId(value = "employee_id")
    private String employeeId;

    /**
     * 雇员姓名
     */
    private String employeeName;

    /**
     * 曾用名
     */
    private String formerName;

    /**
     * 证件类型:1: 身份证, 2: 护照, 3: 军(警)官证, 4: 士兵证, 5: 台胞证, 6: 回乡证, 7: 其他
     */
    private Integer idCardType;

    /**
     * 证件号码
     */
    private String idNum;

    /**
     * 雇员出生日期
     */
    private LocalDateTime birthday;

    /**
     * 户口性质:1: 非农业户口, 2: 农业户口
     */
    private Integer residentType;

    /**
     * 雇员性别:0,男性，1，女性    2，中性
     */
    private Integer gender;

    /**
     * 婚姻状况:0: 未婚, 1: 已婚，2：离异3：丧偶
     */
    private Integer marriageStatus;

    /**
     * 结婚日期
     */
    private LocalDateTime marriageDate;

    /**
     * 子女情况:0:无子女 1:独生子女 2:有子女但非独生子女
     */
    private Integer childStatus;

    /**
     * 子女数量
     */
    private Integer childNum;

    /**
     * 健康状况:0:健康或良好 1:残疾 2:一般或软弱 3: 有疾病, 4: 有生理缺陷
     */
    private Integer healthStatus;

    /**
     * 教育程度：1.博士后,2.博士研究生,3.硕士,4.硕士研究生,5.大学本科,6.大学专科,7.中专,8.中等专科,9.职业高中,10.技工学校,11.技校,12.普通高中,13.职高,14.职专,15.初中,16.小学,17.文盲或半文盲,18.其他
     */
    private Integer eduLevel;

    /**
     * 人员类别:1.新成长失业人员,2.就业转失业人员,3.其他失业人员,4.在业人员,5.退休人员,6.在学人员,7.退伍军人,8.农村劳动力,9.外来劳动力	10.其他
     */
    private Integer empType;

    /**
     * 个人身份:1.工人,2.原工商业者,3.农民,4.学生,5.干部,6.现役军人,7.无业人员,8.其他
     */
    private Integer empIdentity;

    /**
     * 参加工作日期
     */
    private LocalDateTime workDate;

    /**
     * 政治面貌：0: 群众, 1: 党员，2：团员
     */
    private Integer policy;

    /**
     * 国籍code
     */
    private String countryCode;

    /**
     * 国籍
     */
    private String countryName;

    /**
     * 民族
     */
    private String nationality;

    /**
     * 社保账号
     */
    private String socialAccount;

    /**
     * 公积金账号
     */
    private String fundAccount;

    /**
     * 补充公积金账号
     */
    private String addFundAccount;

    /**
     * 雇员邮箱
     */
    private String employeeEmail;

    /**
     * 雇员手机号码
     */
    private String employeeMobile;

    /**
     * 雇员联系地址
     */
    private String employeeAddress;

    /**
     * 雇员邮编
     */
    private String employeeZipCode;

    /**
     * 户籍地址
     */
    private String residenceAddress;

    /**
     * 紧急联系人
     */
    private String emergencyContactName;

    /**
     * 紧急联系人电话
     */
    private String emergencyMobile;

    /**
     * 档案所在地址
     */
    private String fileAddress;

    /**
     * 是否可用:0-禁用 1-可用
     */
    private Boolean isActive;

    /**
     * 版本号
     */
    private Long version;


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

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public Integer getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(Integer idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getResidentType() {
        return residentType;
    }

    public void setResidentType(Integer residentType) {
        this.residentType = residentType;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(Integer marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public LocalDateTime getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDateTime marriageDate) {
        this.marriageDate = marriageDate;
    }

    public Integer getChildStatus() {
        return childStatus;
    }

    public void setChildStatus(Integer childStatus) {
        this.childStatus = childStatus;
    }

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Integer getPolicy() {
        return policy;
    }

    public void setPolicy(Integer policy) {
        this.policy = policy;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSocialAccount() {
        return socialAccount;
    }

    public void setSocialAccount(String socialAccount) {
        this.socialAccount = socialAccount;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getAddFundAccount() {
        return addFundAccount;
    }

    public void setAddFundAccount(String addFundAccount) {
        this.addFundAccount = addFundAccount;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        this.employeeMobile = employeeMobile;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeZipCode() {
        return employeeZipCode;
    }

    public void setEmployeeZipCode(String employeeZipCode) {
        this.employeeZipCode = employeeZipCode;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyMobile() {
        return emergencyMobile;
    }

    public void setEmergencyMobile(String emergencyMobile) {
        this.emergencyMobile = emergencyMobile;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
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

    public Integer getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Integer eduLevel) {
        this.eduLevel = eduLevel;
    }

    public Integer getEmpType() {
        return empType;
    }

    public void setEmpType(Integer empType) {
        this.empType = empType;
    }

    public Integer getEmpIdentity() {
        return empIdentity;
    }

    public void setEmpIdentity(Integer empIdentity) {
        this.empIdentity = empIdentity;
    }

    public LocalDateTime getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDateTime workDate) {
        this.workDate = workDate;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "EmployeeInfoPO{" +
                "employeeId=" + employeeId +
                ", employeeName=" + employeeName +
                ", formerName=" + formerName +
                ", idCardType=" + idCardType +
                ", idNum=" + idNum +
                ", birthday=" + birthday +
                ", residentType=" + residentType +
                ", gender=" + gender +
                ", marriageStatus=" + marriageStatus +
                ", marriageDate=" + marriageDate +
                ", childStatus=" + childStatus +
                ", childNum=" + childNum +
                ", healthStatus=" + healthStatus +
                ", policy=" + policy +
                ", countryCode=" + countryCode +
                ", nationality=" + nationality +
                ", socialAccount=" + socialAccount +
                ", fundAccount=" + fundAccount +
                ", addFundAccount=" + addFundAccount +
                ", employeeEmail=" + employeeEmail +
                ", employeeMobile=" + employeeMobile +
                ", employeeAddress=" + employeeAddress +
                ", employeeZipCode=" + employeeZipCode +
                ", residenceAddress=" + residenceAddress +
                ", emergencyContactName=" + emergencyContactName +
                ", emergencyMobile=" + emergencyMobile +
                ", fileAddress=" + fileAddress +
                ", isActive=" + isActive +
                ", version=" + version +
                "}";
    }
}
