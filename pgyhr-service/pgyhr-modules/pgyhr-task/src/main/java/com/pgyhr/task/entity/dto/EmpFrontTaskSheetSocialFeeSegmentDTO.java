package com.pgyhr.task.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 前道任务单社保费用段表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-26
 */
@Data
public class EmpFrontTaskSheetSocialFeeSegmentDTO implements Serializable {


    private static final long serialVersionUID = 5251848424917465544L;
    private Long empFrontTaskSheetSocialFeeSegmentId;

    /**
     * 任务单ID
     */
    private String empFrontTaskSheetCode;

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
    private Date socialStatusDate;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 办理日期
     */
    private Date handleDate;

    /**
     * 执行日期
     */
    private Date executeDate;

    /**
     * 缴纳开始月(yyyy-MM格式)
     */
    private Date startDate;

    /**
     * 缴纳结束月(yyyy-MM格式)
     */
    private Date endDate;

    /**
     * 缴纳开始月确认月(yyyy-MM格式)
     */
    private Date startConfirmDate;

    /**
     * 缴纳结束月确认月(yyyy-MM格式)
     */
    private Date endConfirmDate;

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
}
