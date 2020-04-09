package com.pgyhr.company.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 全国客户公司表
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-07
 */
@TableName("p_company")
public class CompanyPO extends Model<CompanyPO> {

    private static final long serialVersionUID=1L;

    /**
     * 客户公司ID
     */
    @TableId(value = "company_code", type = IdType.AUTO)
    private Long companyCode;

    /**
     * 客户公司名称
     */
    @TableField(value = "company_name")
    private String companyName;

    /**
     * 客户公司城市ID
     */
    private String companyCityCode;

    /**
     * 客户公司城市名称
     */
    private String companyCityName;

    /**
     * 使用状态:0-使用，1-禁用
     */
    private Integer useStatus;

    /**
     * 使用次数
     */
    private Integer useCount;

    /**
     * 标准:0-政府，1-企业
     */
    private Integer standard;

    /**
     * 预收:0-是，1-否
     */
    private Integer advance;

    /**
     * 客户公司地址
     */
    private String companyAdress;

    /**
     * 客户公司邮编
     */
    private String companyZipCode;

    /**
     * 客户公司电话
     */
    private String companyZipTel;

    /**
     * 客户公司传真
     */
    private String companyZipFax;

    /**
     * 客户公司邮箱
     */
    private String companyMail;

    /**
     * 雇员服务联系人
     */
    private String employeeServicesContact;

    /**
     * 雇员服务联系电话
     */
    private String employeeServicesContactTel;

    /**
     * 雇员服务联系邮箱
     */
    private String employeeServicesContactMail;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系人电话
     */
    private String contactTel;

    /**
     * 联系人邮箱
     */
    private String contactMail;

    /**
     * 部门领导
     */
    private String departmentManager;

    /**
     * 部门领导电话
     */
    private String departmentManagerTel;

    /**
     * 部门领导邮箱
     */
    private String departmentManagerMail;

    /**
     * 公司领导
     */
    private String companyManager;

    /**
     * 公司领导电话
     */
    private String companyManagerTel;

    /**
     * 公司领导邮箱
     */
    private String companyManagerMail;

    /**
     * 开户名称
     */
    private String accountName;

    /**
     * 开户行
     */
    private String accountBank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 开户联行号
     */
    private String associatedAccount;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 纳税识别号
     */
    private String taxIdentificationNumber;

    /**
     * 三证合一号码
     */
    private String threeInOneCode;

    /**
     * 纳税人类型 1.一般纳税人 2.小规模纳税人
     */
    private String taxPayerType;

    /**
     * 客户开票类型：1.混合开票
     */
    private String customerInvoiceType;

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


    public Long getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Long companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCityCode() {
        return companyCityCode;
    }

    public void setCompanyCityCode(String companyCityCode) {
        this.companyCityCode = companyCityCode;
    }

    public String getCompanyCityName() {
        return companyCityName;
    }

    public void setCompanyCityName(String companyCityName) {
        this.companyCityName = companyCityName;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Integer getAdvance() {
        return advance;
    }

    public void setAdvance(Integer advance) {
        this.advance = advance;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }

    public String getCompanyZipCode() {
        return companyZipCode;
    }

    public void setCompanyZipCode(String companyZipCode) {
        this.companyZipCode = companyZipCode;
    }

    public String getCompanyZipTel() {
        return companyZipTel;
    }

    public void setCompanyZipTel(String companyZipTel) {
        this.companyZipTel = companyZipTel;
    }

    public String getCompanyZipFax() {
        return companyZipFax;
    }

    public void setCompanyZipFax(String companyZipFax) {
        this.companyZipFax = companyZipFax;
    }

    public String getCompanyMail() {
        return companyMail;
    }

    public void setCompanyMail(String companyMail) {
        this.companyMail = companyMail;
    }

    public String getEmployeeServicesContact() {
        return employeeServicesContact;
    }

    public void setEmployeeServicesContact(String employeeServicesContact) {
        this.employeeServicesContact = employeeServicesContact;
    }

    public String getEmployeeServicesContactTel() {
        return employeeServicesContactTel;
    }

    public void setEmployeeServicesContactTel(String employeeServicesContactTel) {
        this.employeeServicesContactTel = employeeServicesContactTel;
    }

    public String getEmployeeServicesContactMail() {
        return employeeServicesContactMail;
    }

    public void setEmployeeServicesContactMail(String employeeServicesContactMail) {
        this.employeeServicesContactMail = employeeServicesContactMail;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager;
    }

    public String getDepartmentManagerTel() {
        return departmentManagerTel;
    }

    public void setDepartmentManagerTel(String departmentManagerTel) {
        this.departmentManagerTel = departmentManagerTel;
    }

    public String getDepartmentManagerMail() {
        return departmentManagerMail;
    }

    public void setDepartmentManagerMail(String departmentManagerMail) {
        this.departmentManagerMail = departmentManagerMail;
    }

    public String getCompanyManager() {
        return companyManager;
    }

    public void setCompanyManager(String companyManager) {
        this.companyManager = companyManager;
    }

    public String getCompanyManagerTel() {
        return companyManagerTel;
    }

    public void setCompanyManagerTel(String companyManagerTel) {
        this.companyManagerTel = companyManagerTel;
    }

    public String getCompanyManagerMail() {
        return companyManagerMail;
    }

    public void setCompanyManagerMail(String companyManagerMail) {
        this.companyManagerMail = companyManagerMail;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAssociatedAccount() {
        return associatedAccount;
    }

    public void setAssociatedAccount(String associatedAccount) {
        this.associatedAccount = associatedAccount;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getThreeInOneCode() {
        return threeInOneCode;
    }

    public void setThreeInOneCode(String threeInOneCode) {
        this.threeInOneCode = threeInOneCode;
    }

    public String getTaxPayerType() {
        return taxPayerType;
    }

    public void setTaxPayerType(String taxPayerType) {
        this.taxPayerType = taxPayerType;
    }

    public String getCustomerInvoiceType() {
        return customerInvoiceType;
    }

    public void setCustomerInvoiceType(String customerInvoiceType) {
        this.customerInvoiceType = customerInvoiceType;
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
    protected Serializable pkVal() {
        return this.companyCode;
    }

    @Override
    public String toString() {
        return "Company{" +
        "companyCode=" + companyCode +
        ", companyName=" + companyName +
        ", companyCityCode=" + companyCityCode +
        ", companyCityName=" + companyCityName +
        ", useStatus=" + useStatus +
        ", useCount=" + useCount +
        ", standard=" + standard +
        ", advance=" + advance +
        ", companyAdress=" + companyAdress +
        ", companyZipCode=" + companyZipCode +
        ", companyZipTel=" + companyZipTel +
        ", companyZipFax=" + companyZipFax +
        ", companyMail=" + companyMail +
        ", employeeServicesContact=" + employeeServicesContact +
        ", employeeServicesContactTel=" + employeeServicesContactTel +
        ", employeeServicesContactMail=" + employeeServicesContactMail +
        ", contactPerson=" + contactPerson +
        ", contactTel=" + contactTel +
        ", contactMail=" + contactMail +
        ", departmentManager=" + departmentManager +
        ", departmentManagerTel=" + departmentManagerTel +
        ", departmentManagerMail=" + departmentManagerMail +
        ", companyManager=" + companyManager +
        ", companyManagerTel=" + companyManagerTel +
        ", companyManagerMail=" + companyManagerMail +
        ", accountName=" + accountName +
        ", accountBank=" + accountBank +
        ", bankAccount=" + bankAccount +
        ", associatedAccount=" + associatedAccount +
        ", invoiceTitle=" + invoiceTitle +
        ", taxIdentificationNumber=" + taxIdentificationNumber +
        ", threeInOneCode=" + threeInOneCode +
        ", taxPayerType=" + taxPayerType +
        ", customerInvoiceType=" + customerInvoiceType +
        ", remark=" + remark +
        ", isActive=" + isActive +
        ", version=" + version +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", modifiedBy=" + modifiedBy +
        ", modifiedTime=" + modifiedTime +
        "}";
    }
}
