package com.pgyhr.task.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;
import lombok.Data;

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
@Data
public class SocialPolicyTemplateItemDTO implements Serializable {


    private static final long serialVersionUID = -4458587613185065459L;
    /**
     * ID
     */
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

}
