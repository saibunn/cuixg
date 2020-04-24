package com.pgyhr.task.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 全国社保字典
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-24
 */
@TableName("dict_social_policy_template")
public class SocialPolicyTemplatePO extends PgyhrBaseEntityNoId<SocialPolicyTemplatePO> {

    private static final long serialVersionUID=1L;

    /**
     * 社保模板CODE
     */
    private String socialPolicyCode;

    /**
     * 社保模板名称
     */
    private String socialPolicyName;

    /**
     * 社保模板类型：1-国家，2-企业
     */
    private Integer socialPolicyType;

    /**
     * 社保类型：1-社保 2-公积金 3-补充公积金
     */
    private Integer policyType;

    /**
     * 社保城市CODE
     */
    private String cityCode;

    /**
     * 社保城市名称
     */
    private String cityName;

    /**
     * 失效月份
     */
    private LocalDateTime expirationMonth;

    /**
     * 失效备注
     */
    private String expirationRemark;

    /**
     * 人员属性ID
     */
    private String personalPropertyId;

    /**
     * 是否五险合一: 0-不是，1-是
     */
    private Integer isCombined;

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


    public String getSocialPolicyCode() {
        return socialPolicyCode;
    }

    public void setSocialPolicyCode(String socialPolicyCode) {
        this.socialPolicyCode = socialPolicyCode;
    }

    public String getSocialPolicyName() {
        return socialPolicyName;
    }

    public void setSocialPolicyName(String socialPolicyName) {
        this.socialPolicyName = socialPolicyName;
    }

    public Integer getSocialPolicyType() {
        return socialPolicyType;
    }

    public void setSocialPolicyType(Integer socialPolicyType) {
        this.socialPolicyType = socialPolicyType;
    }

    public Integer getPolicyType() {
        return policyType;
    }

    public void setPolicyType(Integer policyType) {
        this.policyType = policyType;
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

    public LocalDateTime getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(LocalDateTime expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationRemark() {
        return expirationRemark;
    }

    public void setExpirationRemark(String expirationRemark) {
        this.expirationRemark = expirationRemark;
    }

    public String getPersonalPropertyId() {
        return personalPropertyId;
    }

    public void setPersonalPropertyId(String personalPropertyId) {
        this.personalPropertyId = personalPropertyId;
    }

    public Integer getIsCombined() {
        return isCombined;
    }

    public void setIsCombined(Integer isCombined) {
        this.isCombined = isCombined;
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
        return this.socialPolicyCode;
    }

    @Override
    public String toString() {
        return "SocialPolicyTemplatePO{" +
        "socialPolicyCode=" + socialPolicyCode +
        ", socialPolicyName=" + socialPolicyName +
        ", socialPolicyType=" + socialPolicyType +
        ", policyType=" + policyType +
        ", cityCode=" + cityCode +
        ", cityName=" + cityName +
        ", expirationMonth=" + expirationMonth +
        ", expirationRemark=" + expirationRemark +
        ", personalPropertyId=" + personalPropertyId +
        ", isCombined=" + isCombined +
        ", remark=" + remark +
        ", isActive=" + isActive +
        ", version=" + version +
        "}";
    }
}
