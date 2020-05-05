package com.pgyhr.task.entity.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 客户雇员表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-05-05
 */
public class EmpCompanyResponseDTO implements Serializable{


    private static final long serialVersionUID = -1573632225504524037L;
    /**
     * 客户雇员ID
     */
    private String empCompanyId;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 雇员ID
     */
    private String employeeId;

    /**
     * 雇员名称
     */
    private String employeeName;

    /**
     * 管理方ID
     */
    private String managementId;

    /**
     * 旧雇员ID
     */
    private String oldEmployeeId;

    /**
     * 渠道ID
     */
    private String channelId;

    /**
     * 雇员类型1: 派遣, 2: 代理, 3: 业务外包
     */
    private Integer templateType;

    /**
     * 雇员类型1: 派遣, 2: 代理, 3: 业务外包
     */
    private String templateTypeLabel;

    /**
     * 入职日期
     */
    private LocalDateTime inDate;

    /**
     * 是否代办银行卡0 ：不是，1：是
     */
    private Integer isTransActBankCard;

    /**
     * 是否需要银行卡信息:0 ：不需要，1：需要
     */
    private Integer isNeedBankCard;

    /**
     * 银行卡种类:1: 建设银行, 2: 工商银行，3：招商银行4：中国银行 5:其他银行
     */
    private Integer bankType;

    /**
     * 银行卡号
     */
    private String bankCode;

    /**
     * 薪资
     */
    private BigDecimal salary;

    /**
     * 工资支付方式:0: 用工单位, 1: 蒲公英
     */
    private Integer salaryPayType;

    /**
     * 工资支付方式:0: 用工单位, 1: 蒲公英
     */
    private String salaryPayTypeLabel;

    /**
     * 合同开始时间
     */
    private LocalDateTime laborStartDate;

    /**
     * 合同结束时间
     */
    private LocalDateTime laborEndDate;

    /**
     * 合同签订方:1: 蒲公英, 2: 蒲公英外包, 3: 客户代签, 4: 客户自签
     */
    private Integer laborSide;

    /**
     * 合同签订方:1: 蒲公英, 2: 蒲公英外包, 3: 客户代签, 4: 客户自签
     */
    private String laborSideLabel;

    /**
     * 部门
     */
    private String deptName;

    /**
     * 员工编号
     */
    private String empCode;

    /**
     * 职务
     */
    private String position;

    /**
     * 员工公司邮箱
     */
    private String empPost;

    /**
     * 员工职业
     */
    private String empProfession;

    /**
     * 试用薪资
     */
    private BigDecimal trySalary;

    /**
     * 试用期开始时间
     */
    private LocalDateTime tryStartDate;

    /**
     * 试用期结束时间
     */
    private LocalDateTime tryEndDate;

    /**
     * 工时种类：0: 标准工时, 1: 不定时工时, 2: 综合工时
     */
    private Integer workType;

    /**
     * 工时种类：0: 标准工时, 1: 不定时工时, 2: 综合工时
     */
    private String workTypeLabel;

    /**
     * 入职类型: 1: 常规入职, 2: 集体转入
     */
    private Integer postType;

    /**
     * 用工形式:1: 全日制, 2: 非全日制
     */
    private Integer employStyle;

    /**
     * 社保福利办理方:1: 独立户, 2: 大库
     */
    private Integer socialUnit;

    /**
     * 社保福利办理方:1: 独立户, 2: 大库
     */
    private String socialUnitLabel;

    /**
     * 社保福利办理方:1: 独立户, 2: 大库
     */
    private Integer fundUnit;

    /**
     * 社保福利办理方:1: 独立户, 2: 大库
     */
    private String fundUnitLabel;

    /**
     * 用退工福利办理方:1: 独立户, 2: 大库
     */
    private Integer hireUnit;

    /**
     * 用退工福利办理方:1: 独立户, 2: 大库
     */
    private String hireUnitLabel;

    /**
     * 工作城市CODE
     */
    private String workCityCode;

    /**
     * 工作城市名称
     */
    private String workCityName;

    /**
     * 社保缴纳城市CODE
     */
    private String socialCityCode;

    /**
     * 社保缴纳城市名称
     */
    private String socialCityName;

    /**
     * 公积金缴城市CODE
     */
    private String fundCityCode;

    /**
     * 公积金缴城市名称
     */
    private String fundCityName;

    /**
     * 离职时间
     */
    private LocalDateTime outDate;

    /**
     * 离职原因：1: 辞职,2: 协商解除,3: 公司解聘,4: 合同到期,5: 关闭,6: 出国,7: 退休,8: 工伤死亡,// 9: 取消入职,10: 死亡,11: 转科技人才,12: 转用工单位（翻牌）,13: 公司自行管理, 无需退工,14: 公司自行管理, 需办退工,15: 转其他公司管理, 无需退工,16: 转其他公司管理, 需办退工
     */
    private Integer outReason;

    /**
     * 离职原因：1: 辞职,2: 协商解除,3: 公司解聘,4: 合同到期,5: 关闭,6: 出国,7: 退休,8: 工伤死亡,// 9: 取消入职,10: 死亡,11: 转科技人才,12: 转用工单位（翻牌）,13: 公司自行管理, 无需退工,14: 公司自行管理, 需办退工,15: 转其他公司管理, 无需退工,16: 转其他公司管理, 需办退工
     */
    private String outReasonLabel;

    /**
     * 社保停缴方式:1: 转出, 2: 封存
     */
    private Integer socialStopType;

    /**
     * 公积金停缴方式:1: 转出, 2: 封存
     */
    private Integer fundStopType;

    /**
     * 雇员材料位置
     */
    private String materialPosition;

    /**
     * 雇员入表方式:1:预录用2:雇员新增3:雇员翻牌
     */
    private Integer empInType;

    /**
     * 雇员入表方式:1:预录用2:雇员新增3:雇员翻牌
     */
    private String empInTypeLabel;

    /**
     * 状态1:预录用 2:雇员信息确认中 3:在职 4:离职
     */
    private Integer status;

    /**
     * 状态1:预录用 2:雇员信息确认中 3:在职 4:离职
     */
    private String statusLabel;

    /**
     * 紧急联系人
     */
    private String sos;

    /**
     * 紧急联系人电话
     */
    private String sosPhone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 离职备注
     */
    private String remarkOut;

    /**
     * 是否需要微信信息:0 ：不需要，1：需要
     */
    private Integer isUploadWechatData;

    /**
     * 微信ID
     */
    private String wechatCode;

    /**
     * 是否可用:0-禁用 1-可用 
     */
    private Boolean isActive;

    /**
     * 雇员上级ID
     */
    private String leadershipId;

    /**
     * 雇员上级姓名
     */
    private String leadershipName;

    /**
     * 劳动合同CODE
     */
    private String laborContractCode;

    /**
     * 岗位描述
     */
    private String jobContent;

    /**
     * 派遣期限
     */
    private String dispatchingTerm;

}
