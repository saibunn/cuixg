package com.pgyhr.task.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 雇员前道任务单表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-30
 */
@Data
public class EmpFrontTaskSheetResponseDTO implements Serializable{


    private static final long serialVersionUID = 5202749885303133990L;
    /**
     * 雇员前道任务单ID
     */
    private String empFrontTaskSheetCode;

    /**
     * 任务单域:0-前道，1-后道
     */
    private Integer taskArea;

    /**
     * 任务单状态:0-后道批退,1-前道提交,2-后道处理,3-后道部分完成,4-后道完成,
     */
    private Integer taskStatus;

    /**
     * 任务单类型:0-新增,1-调整,2-年度调整,3-终止,4-一次性费用,5-服务费调整
     */
    private Integer taskType;

    /**
     * 社保城市code
     */
    private String socialCityCode;

    /**
     * 社保城市名称
     */
    private String socialCityName;

    /**
     * 公积金城市code
     */
    private String fundCityCode;

    /**
     * 公积金城市名称
     */
    private String fundCityName;

    /**
     * 补充公积金城市code
     */
    private String addFundCityCode;

    /**
     * 补充公积金社保城市名称
     */
    private String addFundCityName;

    /**
     * 委托机构ID
     */
    private String entrustOrganizationId;

    /**
     * 委托机构名称
     */
    private String entrustOrganizationName;

    /**
     * 客户雇员ID
     */
    private String empCompanyId;

    /**
     * 雇员编号
     */
    private String employeeId;

    /**
     * 雇员姓名
     */
    private String employeeName;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 办理用工日期
     */
    private LocalDateTime employmentDate;

    /**
     * 合同开始日期
     */
    private LocalDateTime contractStartDate;

    /**
     * 合同结束日期
     */
    private LocalDateTime contractEndDate;

    /**
     * 雇员公积金账号
     */
    private String employeesFundAccount;

    /**
     * 雇员社保账号
     */
    private String employeesSocialAccount;

    /**
     * 雇员补充公积金账号
     */
    private String employeesAddFundAccount;

    /**
     * 社保福利办理方:1: 独立户, 2: 大库
     */
    private Integer socialUnit;

    /**
     * 公积金福利办理方:1: 独立户, 2: 大库
     */
    private Integer fundUnit;

    /**
     * 用退工福利办理方:1: 独立户, 2: 大库
     */
    private Integer hireUnit;

    /**
     * 服务产品反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private Integer serviceProductStatus;

    /**
     * 服务产品反馈日期
     */
    private LocalDateTime serviceProductStatusDate;

    /**
     * 服务产品执行年月
     */
    private LocalDateTime serviceProductStartDate;

    /**
     * 服务产品结束年月
     */
    private LocalDateTime serviceProductEndDate;

    /**
     * 档案所在地
     */
    private String fileAddress;

    /**
     * 档案保管费
     */
    private BigDecimal fileKeepFee;

    /**
     * 档案保管费反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private Integer fileKeepFeeStatus;

    /**
     * 档案保管费反馈日期
     */
    private LocalDateTime fileKeepFeeStatusDate;

    /**
     * 档案费执行年月
     */
    private LocalDateTime fileKeepFeeStartDate;

    /**
     * 档案费结束年月
     */
    private LocalDateTime fileKeepFeeEndDate;

    /**
     * 额外费用
     */
    private BigDecimal otherFee;

    /**
     * 额外费用反馈状态:0-取消委托，1-委托成功，2-委托办理
     */
    private Integer otherFeeStatus;

    /**
     * 额外费用反馈日期
     */
    private LocalDateTime otherFeeStatusDate;

    /**
     * 额外费用执行年月
     */
    private LocalDateTime otherFeeStartDate;

    /**
     * 额外费用结束年月
     */
    private LocalDateTime otherFeeEndDate;

    /**
     * 实际工资
     */
    private BigDecimal actualWage;

    /**
     * 服务费
     */
    private BigDecimal serviceFee;

    /**
     * 离职原因：1: 辞职,2: 协商解除,3: 公司解聘,4: 合同到期,5: 关闭,6: 出国,7: 退休,8: 工伤死亡,// 9: 取消入职,10: 死亡,11: 转科技人才,12: 转用工单位（翻牌）,13: 公司自行管理, 无需退工,14: 公司自行管理, 需办退工,15: 转其他公司管理, 无需退工,16: 转其他公司管理, 需办退工
     */
    private Integer outReason;

    /**
     * 离职原因：1: 辞职,2: 协商解除,3: 公司解聘,4: 合同到期,5: 关闭,6: 出国,7: 退休,8: 工伤死亡,// 9: 取消入职,10: 死亡,11: 转科技人才,12: 转用工单位（翻牌）,13: 公司自行管理, 无需退工,14: 公司自行管理, 需办退工,15: 转其他公司管理, 无需退工,16: 转其他公司管理, 需办退工
     */
    private String outReasonLabel;

    /**
     * 离职日期
     */
    private LocalDateTime outDate;

    /**
     * 批退审核结果
     */
    private String retreatExamineResult;

    /**
     * 批退原因
     */
    private String retreatReason;

    /**
     * 批退状态:0-正常，1-未处理，2-已拒绝，3-已批退
     */
    private Integer retreatStatus;

    /**
     * 批退状态:0-正常，1-未处理，2-已拒绝，3-已批退
     */
    private String retreatStatusLabel;

    /**
     * 备注
     */
    private String remark;

    /**
     * 服务协议ID
     */
    private String serviceAgreementId;

    /**
     * 是否可用:0-禁用 1-可用 
     */
    private Boolean isActive;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 任务单类型label
     */
    private String taskTypeLabel;

    /**
     * 任务单状态label
     */
    private String taskStatusLabel;


    private String createdBy;

    private LocalDateTime createdTime;
}
