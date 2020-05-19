package com.pgyhr.company.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 全国客户公司表
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-13
 */
@TableName("p_company")
public class CompanyPO extends Model<CompanyPO> {

    private static final long serialVersionUID=1L;

    /**
     * 客户公司ID
     */
    private String companyCode;

    /**
     * 客户公司名称
     */
    private String companyName;


    /**
     * 客户公司级别（0:母公司1:子公司）
     */
    private Integer companyLevel;

    /**
     * 客户公司所属母公司（关联主键）
     */
    @TableField("company_parentId")
    private String companyParentid;

    /**
     * 纳税类型（1.一般纳税人、2.小规模企业）
     */
    private Integer taxTypes;

    /**
     * 营业执照复印件
     */
    private String photocopyBusinessLicence;

    /**
     * 注册地址所在地
     */
    private String companyRegisteredLocation;

    /**
     * 注册详情地址
     */
    private String detailedAddressRegistered;

    /**
     * 实际办公地址
     */
    private String companyRealityLocation;

    /**
     * 实际详情地址
     */
    private String detailedAddressReality;

    /**
     * 是否社保代办户（0：否1：是）
     */
    private Integer socialSecurityAgent;

    /**
     * 养老账户
     */
    private String pensionAccount;

    /**
     * 医疗账户
     */
    private String medicalAccount;

    /**
     * 失业账户
     */
    private String unemploymentAccount;

    /**
     * 工伤账户
     */
    private String inductrialInjuryAccounts;

    /**
     * 生育账户
     */
    private String familyAccount;

    /**
     * 是否公积金代办户（0：否1：是）
     */
    private Integer housingFundAgent;

    /**
     * 基本公积金账户
     */
    private String basicHousingFundAgent;

    /**
     * 补充公积金账户
     */
    private String replenishHousingFundAgent;

    /**
     * 签约销售id
     */
    private String signedSalesId;

    /**
     * 签约销售
     */
    private String signedSales;

    /**
     * 合同扫描件
     */
    private String contractScanning;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 合约开始时间
     */
    private LocalDateTime contractStartTime;

    /**
     * 合约结束时间
     */
    private LocalDateTime contractEndTime;

    /**
     * 签约公司
     */
    private Integer contractingCompany;

    /**
     * 服务公司
     */
    private Integer serviceCompany;

    /**
     * 承接城市
     */
    private Integer undertakeCity;

    /**
     * 备注
     */
    private String comment;

    /**
     * 服务开始时间
     */
    private LocalDateTime serviceStartTime;

    /**
     * 责任客服
     */
    private String responsibilityServiceId;

    /**
     * 责任客服
     */
    private String responsibilityService;

    /**
     * 收费方式（1.预收款2.垫款）
     */
    private Integer chargeType;

    /**
     * 社保代理内部价格
     */
    private Double socialSecurityInteriorCharge;

    /**
     * 社保代理外部价格
     */
    private Double socialSecurityExternalCharge;

    /**
     * 开户行名称
     */
    private String openingBank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 开票联系
     */
    private String invoiceContacter;

    /**
     * 开具发票类型（1.收据、2.增值税专用发票、3.增值税普通纸质发票、4.增值税普通电子发票）
     */
    private Integer invoiceType;

    /**
     * 开具周期（1.月结、2.季结）
     */
    private Integer invoicePeriod;

    /**
     * 使用状态:0-使用，1-禁用
     */
    private Integer useStatus;

    /**
     * 使用次数
     */
    private Integer useCount;

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
    private String createdTime;

    /**
     * 修改人
     */
    private String modifiedBy;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifiedTime;

    public String getSignedSales() {
        return signedSales;
    }


    public void setSignedSales(String signedSales) {
        this.signedSales = signedSales;
    }

    public String getResponsibilityServiceId() {
        return responsibilityServiceId;
    }

    public void setResponsibilityServiceId(String responsibilityServiceId) {
        this.responsibilityServiceId = responsibilityServiceId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCompanyLevel() {
        return companyLevel;
    }

    public void setCompanyLevel(Integer companyLevel) {
        this.companyLevel = companyLevel;
    }

    public String getCompanyParentid() {
        return companyParentid;
    }

    public void setCompanyParentid(String companyParentid) {
        this.companyParentid = companyParentid;
    }

    public Integer getTaxTypes() {
        return taxTypes;
    }

    public void setTaxTypes(Integer taxTypes) {
        this.taxTypes = taxTypes;
    }

    public String getPhotocopyBusinessLicence() {
        return photocopyBusinessLicence;
    }

    public void setPhotocopyBusinessLicence(String photocopyBusinessLicence) {
        this.photocopyBusinessLicence = photocopyBusinessLicence;
    }

    public String getCompanyRegisteredLocation() {
        return companyRegisteredLocation;
    }

    public void setCompanyRegisteredLocation(String companyRegisteredLocation) {
        this.companyRegisteredLocation = companyRegisteredLocation;
    }

    public String getDetailedAddressRegistered() {
        return detailedAddressRegistered;
    }

    public void setDetailedAddressRegistered(String detailedAddressRegistered) {
        this.detailedAddressRegistered = detailedAddressRegistered;
    }

    public String getCompanyRealityLocation() {
        return companyRealityLocation;
    }

    public void setCompanyRealityLocation(String companyRealityLocation) {
        this.companyRealityLocation = companyRealityLocation;
    }

    public String getDetailedAddressReality() {
        return detailedAddressReality;
    }

    public void setDetailedAddressReality(String detailedAddressReality) {
        this.detailedAddressReality = detailedAddressReality;
    }

    public Integer getSocialSecurityAgent() {
        return socialSecurityAgent;
    }

    public void setSocialSecurityAgent(Integer socialSecurityAgent) {
        this.socialSecurityAgent = socialSecurityAgent;
    }

    public String getPensionAccount() {
        return pensionAccount;
    }

    public void setPensionAccount(String pensionAccount) {
        this.pensionAccount = pensionAccount;
    }

    public String getMedicalAccount() {
        return medicalAccount;
    }

    public void setMedicalAccount(String medicalAccount) {
        this.medicalAccount = medicalAccount;
    }

    public String getUnemploymentAccount() {
        return unemploymentAccount;
    }

    public void setUnemploymentAccount(String unemploymentAccount) {
        this.unemploymentAccount = unemploymentAccount;
    }

    public String getInductrialInjuryAccounts() {
        return inductrialInjuryAccounts;
    }

    public void setInductrialInjuryAccounts(String inductrialInjuryAccounts) {
        this.inductrialInjuryAccounts = inductrialInjuryAccounts;
    }

    public String getFamilyAccount() {
        return familyAccount;
    }

    public void setFamilyAccount(String familyAccount) {
        this.familyAccount = familyAccount;
    }

    public Integer getHousingFundAgent() {
        return housingFundAgent;
    }

    public void setHousingFundAgent(Integer housingFundAgent) {
        this.housingFundAgent = housingFundAgent;
    }

    public String getBasicHousingFundAgent() {
        return basicHousingFundAgent;
    }

    public void setBasicHousingFundAgent(String basicHousingFundAgent) {
        this.basicHousingFundAgent = basicHousingFundAgent;
    }

    public String getReplenishHousingFundAgent() {
        return replenishHousingFundAgent;
    }

    public void setReplenishHousingFundAgent(String replenishHousingFundAgent) {
        this.replenishHousingFundAgent = replenishHousingFundAgent;
    }

    public String getSignedSalesId() {
        return signedSalesId;
    }

    public void setSignedSalesId(String signedSalesId) {
        this.signedSalesId = signedSalesId;
    }

    public String getContractScanning() {
        return contractScanning;
    }

    public void setContractScanning(String contractScanning) {
        this.contractScanning = contractScanning;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public LocalDateTime getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(LocalDateTime contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public LocalDateTime getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(LocalDateTime contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    public Integer getContractingCompany() {
        return contractingCompany;
    }

    public void setContractingCompany(Integer contractingCompany) {
        this.contractingCompany = contractingCompany;
    }

    public Integer getServiceCompany() {
        return serviceCompany;
    }

    public void setServiceCompany(Integer serviceCompany) {
        this.serviceCompany = serviceCompany;
    }

    public Integer getUndertakeCity() {
        return undertakeCity;
    }

    public void setUndertakeCity(Integer undertakeCity) {
        this.undertakeCity = undertakeCity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(LocalDateTime serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public String getResponsibilityService() {
        return responsibilityService;
    }

    public void setResponsibilityService(String responsibilityService) {
        this.responsibilityService = responsibilityService;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Double getSocialSecurityInteriorCharge() {
        return socialSecurityInteriorCharge;
    }

    public void setSocialSecurityInteriorCharge(Double socialSecurityInteriorCharge) {
        this.socialSecurityInteriorCharge = socialSecurityInteriorCharge;
    }

    public Double getSocialSecurityExternalCharge() {
        return socialSecurityExternalCharge;
    }

    public void setSocialSecurityExternalCharge(Double socialSecurityExternalCharge) {
        this.socialSecurityExternalCharge = socialSecurityExternalCharge;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getInvoiceContacter() {
        return invoiceContacter;
    }

    public void setInvoiceContacter(String invoiceContacter) {
        this.invoiceContacter = invoiceContacter;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getInvoicePeriod() {
        return invoicePeriod;
    }

    public void setInvoicePeriod(Integer invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
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
                ", companyLevel=" + companyLevel +
                ", companyParentid=" + companyParentid +
                ", taxTypes=" + taxTypes +
                ", photocopyBusinessLicence=" + photocopyBusinessLicence +
                ", companyRegisteredLocation=" + companyRegisteredLocation +
                ", detailedAddressRegistered=" + detailedAddressRegistered +
                ", companyRealityLocation=" + companyRealityLocation +
                ", detailedAddressReality=" + detailedAddressReality +
                ", socialSecurityAgent=" + socialSecurityAgent +
                ", pensionAccount=" + pensionAccount +
                ", medicalAccount=" + medicalAccount +
                ", unemploymentAccount=" + unemploymentAccount +
                ", inductrialInjuryAccounts=" + inductrialInjuryAccounts +
                ", familyAccount=" + familyAccount +
                ", housingFundAgent=" + housingFundAgent +
                ", basicHousingFundAgent=" + basicHousingFundAgent +
                ", replenishHousingFundAgent=" + replenishHousingFundAgent +
                ", signedSalesId=" + signedSalesId +
                ", signedSales=" + signedSales +
                ", contractScanning=" + contractScanning +
                ", contractNo=" + contractNo +
                ", contractStartTime=" + contractStartTime +
                ", contractEndTime=" + contractEndTime +
                ", contractingCompany=" + contractingCompany +
                ", serviceCompany=" + serviceCompany +
                ", undertakeCity=" + undertakeCity +
                ", comment=" + comment +
                ", serviceStartTime=" + serviceStartTime +
                ", responsibilityServiceId=" + responsibilityServiceId +
                ", responsibilityService=" + responsibilityService +
                ", chargeType=" + chargeType +
                ", socialSecurityInteriorCharge=" + socialSecurityInteriorCharge +
                ", socialSecurityExternalCharge=" + socialSecurityExternalCharge +
                ", openingBank=" + openingBank +
                ", bankAccount=" + bankAccount +
                ", invoiceContacter=" + invoiceContacter +
                ", invoiceType=" + invoiceType +
                ", invoicePeriod=" + invoicePeriod +
                ", useStatus=" + useStatus +
                ", useCount=" + useCount +
                ", isActive=" + isActive +
                ", version=" + version +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", modifiedBy=" + modifiedBy +
                ", modifiedTime=" + modifiedTime +
                "}";
    }
}
