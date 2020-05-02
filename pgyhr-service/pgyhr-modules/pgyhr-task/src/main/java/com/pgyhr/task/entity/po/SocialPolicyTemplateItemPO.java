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
 * 全国社保字典明细
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-24
 */
@TableName("dict_social_policy_template_item")
public class SocialPolicyTemplateItemPO extends PgyhrBaseEntityNoId<SocialPolicyTemplateItemPO> {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "social_policy_item_code", type = IdType.AUTO)
    private Long socialPolicyItemCode;

    /**
     * 社保模板CODE
     */
    private String socialPolicyCode;

    /**
     * 社保类型：1-社保 2-公积金 3-补充公积金
     */
    private Integer policyType;

    /**
     * 社保产品 CODE
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
     * 生效月份,当IsCombined=1时有效
     */
    private LocalDateTime effectiveMonth;

    /**
     * 所属社保年份
     */
    private String policyYear;

    /**
     * 市平均工资
     */
    private BigDecimal cityAvgSalary;

    /**
     * 省平均工资
     */
    private BigDecimal provinceAvgSalary;

    /**
     * 最低工资
     */
    private BigDecimal minSalary;

    /**
     * 固定支付月份：1-12的数字，如果每月支付就是0
     */
    private Integer payMonth;

    /**
     * 支付方：1- 公司缴纳  2-个人缴纳
     */
    private Integer payer;

    /**
     * 基数上限，如果无上限则存null
     */
    private BigDecimal baseMax;

    /**
     * 基数下限,当IsCombined=1时有效
     */
    private BigDecimal baseMin;

    /**
     * 对缴费基数的尾数做奇数偶数校验 0 不做校验 1 必须为偶数 2必须为奇数
     */
    private Integer checkTailFlag;

    /**
     * 缴纳金额上限，如果无上限则存null
     */
    private BigDecimal payMax;

    /**
     * 排序序号
     */
    private Integer sort;

    /**
     * 计算方式: 1 基数*比例, 2 固定金额,3 基数*比例+固定金额, 4 （全公司的basement合计）*比例
     */
    private Integer calculateMethod;

    /**
     * 缴费比例类型 :1-固定比例,2-区间比例(有上下限,3-多值(多个比例值中选一个)
     */
    private Integer rateType;

    /**
     * 固定比例,RateType=1时有效
     */
    private BigDecimal fixedRate;

    /**
     * 步长
     */
    private BigDecimal step;

    /**
     * 缴费比例下限,RateType=2时有效
     */
    private BigDecimal rateMin;

    /**
     * 缴费比例上限,,RateType=2时有效
     */
    private BigDecimal rateMax;

    /**
     * 逗号分隔的多值比例,RateType=3时有效 例：0.03,005
     */
    private String multiRate;

    /**
     * 固定金额,CalculateMethod=2,3时有效
     */
    private BigDecimal fixedValue;

    /**
     * 小数进位方式:1见分进角，2见角进元，3进位到元，4进位偶数，5舍去角，6舍去分，7舍去厘，8四舍五入到分，9四舍五入到角，10四舍五入到元
     */
    private Integer roundType;

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



    public Long getSocialPolicyItemCode() {
        return socialPolicyItemCode;
    }

    public void setSocialPolicyItemCode(Long socialPolicyItemCode) {
        this.socialPolicyItemCode = socialPolicyItemCode;
    }

    public String getSocialPolicyCode() {
        return socialPolicyCode;
    }

    public void setSocialPolicyCode(String socialPolicyCode) {
        this.socialPolicyCode = socialPolicyCode;
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

    public LocalDateTime getEffectiveMonth() {
        return effectiveMonth;
    }

    public void setEffectiveMonth(LocalDateTime effectiveMonth) {
        this.effectiveMonth = effectiveMonth;
    }

    public String getPolicyYear() {
        return policyYear;
    }

    public void setPolicyYear(String policyYear) {
        this.policyYear = policyYear;
    }

    public BigDecimal getCityAvgSalary() {
        return cityAvgSalary;
    }

    public void setCityAvgSalary(BigDecimal cityAvgSalary) {
        this.cityAvgSalary = cityAvgSalary;
    }

    public BigDecimal getProvinceAvgSalary() {
        return provinceAvgSalary;
    }

    public void setProvinceAvgSalary(BigDecimal provinceAvgSalary) {
        this.provinceAvgSalary = provinceAvgSalary;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(Integer payMonth) {
        this.payMonth = payMonth;
    }

    public Integer getPayer() {
        return payer;
    }

    public void setPayer(Integer payer) {
        this.payer = payer;
    }

    public BigDecimal getBaseMax() {
        return baseMax;
    }

    public void setBaseMax(BigDecimal baseMax) {
        this.baseMax = baseMax;
    }

    public BigDecimal getBaseMin() {
        return baseMin;
    }

    public void setBaseMin(BigDecimal baseMin) {
        this.baseMin = baseMin;
    }

    public Integer getCheckTailFlag() {
        return checkTailFlag;
    }

    public void setCheckTailFlag(Integer checkTailFlag) {
        this.checkTailFlag = checkTailFlag;
    }

    public BigDecimal getPayMax() {
        return payMax;
    }

    public void setPayMax(BigDecimal payMax) {
        this.payMax = payMax;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCalculateMethod() {
        return calculateMethod;
    }

    public void setCalculateMethod(Integer calculateMethod) {
        this.calculateMethod = calculateMethod;
    }

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    public BigDecimal getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(BigDecimal fixedRate) {
        this.fixedRate = fixedRate;
    }

    public BigDecimal getStep() {
        return step;
    }

    public void setStep(BigDecimal step) {
        this.step = step;
    }

    public BigDecimal getRateMin() {
        return rateMin;
    }

    public void setRateMin(BigDecimal rateMin) {
        this.rateMin = rateMin;
    }

    public BigDecimal getRateMax() {
        return rateMax;
    }

    public void setRateMax(BigDecimal rateMax) {
        this.rateMax = rateMax;
    }

    public String getMultiRate() {
        return multiRate;
    }

    public void setMultiRate(String multiRate) {
        this.multiRate = multiRate;
    }

    public BigDecimal getFixedValue() {
        return fixedValue;
    }

    public void setFixedValue(BigDecimal fixedValue) {
        this.fixedValue = fixedValue;
    }

    public Integer getRoundType() {
        return roundType;
    }

    public void setRoundType(Integer roundType) {
        this.roundType = roundType;
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
        return this.socialPolicyItemCode;
    }

    @Override
    public String toString() {
        return "SocialPolicyTemplateItemPO{" +
        "socialPolicyItemCode=" + socialPolicyItemCode +
        ", socialPolicyCode=" + socialPolicyCode +
        ", policyType=" + policyType +
        ", itemCode=" + itemCode +
        ", itemName=" + itemName +
        ", cityCode=" + cityCode +
        ", cityName=" + cityName +
        ", effectiveMonth=" + effectiveMonth +
        ", policyYear=" + policyYear +
        ", cityAvgSalary=" + cityAvgSalary +
        ", provinceAvgSalary=" + provinceAvgSalary +
        ", minSalary=" + minSalary +
        ", payMonth=" + payMonth +
        ", payer=" + payer +
        ", baseMax=" + baseMax +
        ", baseMin=" + baseMin +
        ", checkTailFlag=" + checkTailFlag +
        ", payMax=" + payMax +
        ", sort=" + sort +
        ", calculateMethod=" + calculateMethod +
        ", rateType=" + rateType +
        ", fixedRate=" + fixedRate +
        ", step=" + step +
        ", rateMin=" + rateMin +
        ", rateMax=" + rateMax +
        ", multiRate=" + multiRate +
        ", fixedValue=" + fixedValue +
        ", roundType=" + roundType +
        ", remark=" + remark +
        ", isActive=" + isActive +
        ", version=" + version +
        "}";
    }
}
