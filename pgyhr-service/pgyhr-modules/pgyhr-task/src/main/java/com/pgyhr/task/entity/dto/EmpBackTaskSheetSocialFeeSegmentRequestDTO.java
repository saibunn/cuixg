package com.pgyhr.task.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 后道任务单社保费用段表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-14
 */
@Data
public class EmpBackTaskSheetSocialFeeSegmentRequestDTO implements Serializable{

    private static final long serialVersionUID = 966482256987328120L;
    /**
     * ID
     */
    private Long empBackTaskSheetSocialFeeSegmentId;

    /**
     * 任务单ID
     */
    private String empBackTaskSheetCode;

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
     * 反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private String socialStatusLabel;

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
     * 公司付款方式:1-公司自付，2-管理费
     */
    private String companyPayMethodLabel;

    /**
     * 雇员付款方式:0-个人工资，2-管理费
     */
    private Integer employeePayMethod;

    /**
     * 雇员付款方式:0-个人工资，2-管理费
     */
    private String employeePayMethodLabel;

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

}