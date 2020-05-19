package com.pgyhr.company.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-13
 */
@TableName("p_company_contacts")
public class CompanyContacts extends Model<CompanyContacts> {

    private static final long serialVersionUID=1L;

    /**
     * 联系人ID
     */
    private Integer contactId;

    /**
     * 客户ID（关联主表）
     */
    private String companyCode;

    /**
     * 联系人名称
     */
    private String contactName;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 职务
     */
    private String duty;

    /**
     * QQ号
     */
    private String qqnumber;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 联系人上级
     */
    private String companySupName;

    /**
     * 上级手机号码
     */
    private String mobileSup;

    /**
     * 上级固定电话
     */
    private String telephoneSup;

    /**
     * 上级职务
     */
    private String dutySup;

    /**
     * 上级QQ号
     */
    private String qqnumberSup;

    /**
     * 上级邮箱
     */
    private String mailSup;

    /**
     * 联系人城市
     */
    private String contactLocation;

    /**
     * 联系人详情地址
     */
    private String contactDetailedAddress;

    public String getContactLocation() {
        return contactLocation;
    }

    public void setContactLocation(String contactLocation) {
        this.contactLocation = contactLocation;
    }

    public String getContactDetailedAddress() {
        return contactDetailedAddress;
    }

    public void setContactDetailedAddress(String contactDetailedAddress) {
        this.contactDetailedAddress = contactDetailedAddress;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompanySupName() {
        return companySupName;
    }

    public void setCompanySupName(String companySupName) {
        this.companySupName = companySupName;
    }

    public String getMobileSup() {
        return mobileSup;
    }

    public void setMobileSup(String mobileSup) {
        this.mobileSup = mobileSup;
    }

    public String getTelephoneSup() {
        return telephoneSup;
    }

    public void setTelephoneSup(String telephoneSup) {
        this.telephoneSup = telephoneSup;
    }

    public String getDutySup() {
        return dutySup;
    }

    public void setDutySup(String dutySup) {
        this.dutySup = dutySup;
    }

    public String getQqnumberSup() {
        return qqnumberSup;
    }

    public void setQqnumberSup(String qqnumberSup) {
        this.qqnumberSup = qqnumberSup;
    }

    public String getMailSup() {
        return mailSup;
    }

    public void setMailSup(String mailSup) {
        this.mailSup = mailSup;
    }

    @Override
    protected Serializable pkVal() {
        return this.contactId;
    }

    @Override
    public String toString() {
        return "CompanyContacts{" +
        "contactId=" + contactId +
        ", companyCode=" + companyCode +
        ", contactName=" + contactName +
        ", mobile=" + mobile +
        ", telephone=" + telephone +
        ", duty=" + duty +
        ", qqnumber=" + qqnumber +
        ", mail=" + mail +
        ", companySupName=" + companySupName +
        ", mobileSup=" + mobileSup +
        ", telephoneSup=" + telephoneSup +
        ", dutySup=" + dutySup +
        ", qqnumberSup=" + qqnumberSup +
        ", mailSup=" + mailSup +
        ", contactLocation=" + contactLocation +
        ", contactDetailedAddress=" + contactDetailedAddress +
        "}";
    }
}
