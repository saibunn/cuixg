package com.pgyhr.task.entity.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 雇员信息表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-20
 */
@Data
public class EmployeeInfoResponseDTO implements Serializable {

    private static final long serialVersionUID = -2455744427439466423L;
    /**
     * 雇员编号
     */
    private String employeeId;

    /**
     * 雇员姓名
     */
    private String employeeName;

    /**
     * 曾用名
     */
    private String formerName;

    /**
     * 证件类型:1: 身份证, 2: 护照, 3: 军(警)官证, 4: 士兵证, 5: 台胞证, 6: 回乡证, 7: 其他
     */
    private Integer idCardType;

    /**
     * 证件类型:1: 身份证, 2: 护照, 3: 军(警)官证, 4: 士兵证, 5: 台胞证, 6: 回乡证, 7: 其他
     */
    private String idCardTypeLabel;

    /**
     * 证件号码
     */
    private String idNum;

    /**
     * 雇员出生日期
     */
    private LocalDateTime birthday;

    /**
     * 户口性质:1: 非农业户口, 2: 农业户口
     */
    private Integer residentType;

    /**
     * 户口性质:1: 非农业户口, 2: 农业户口
     */
    private String residentTypeLabel;

    /**
     * 雇员性别:0,男性，1，女性    2，中性
     */
    private Integer gender;

    /**
     * 雇员性别:0,男性，1，女性    2，中性
     */
    private String genderLabel;

    /**
     * 婚姻状况:0: 未婚, 1: 已婚，2：离异3：丧偶
     */
    private Integer marriageStatus;

    /**
     * 婚姻状况:0: 未婚, 1: 已婚，2：离异3：丧偶
     */
    private String marriageStatusLabel;

    /**
     * 结婚日期
     */
    private LocalDateTime marriageDate;

    /**
     * 子女情况:0:无子女 1:独生子女 2:有子女但非独生子女
     */
    private Integer childStatus;

    /**
     * 子女情况:0:无子女 1:独生子女 2:有子女但非独生子女
     */
    private String childStatusLabel;

    /**
     * 子女数量
     */
    private Integer childNum;

    /**
     * 健康状况:0:健康或良好 1:残疾 2:一般或软弱 3: 有疾病, 4: 有生理缺陷
     */
    private Integer healthStatus;

    /**
     * 健康状况:0:健康或良好 1:残疾 2:一般或软弱 3: 有疾病, 4: 有生理缺陷
     */
    private String healthStatusLabel;

    /**
     * 政治面貌：0: 群众, 1: 党员，2：团员
     */
    private Integer policy;

    /**
     * 政治面貌：0: 群众, 1: 党员，2：团员
     */
    private Integer policyLabel;

    /**
     * 国籍
     */
    private String countryCode;

    /**
     * 国籍
     */
    private String countryCodeLabel;

    /**
     * 民族
     */
    private String nationality;

    /**
     * 社保账号
     */
    private String socialAccount;

    /**
     * 公积金账号
     */
    private String fundAccount;

    /**
     * 补充公积金账号
     */
    private String addFundAccount;

    /**
     * 雇员邮箱
     */
    private String employeeEmail;

    /**
     * 雇员手机号码
     */
    private String employeeMobile;

    /**
     * 雇员联系地址
     */
    private String employeeAddress;

    /**
     * 雇员邮编
     */
    private String employeeZipCode;

    /**
     * 户籍地址
     */
    private String residenceAddress;

    /**
     * 紧急联系人
     */
    private String emergencyContactName;

    /**
     * 紧急联系人电话
     */
    private String emergencyMobile;

    /**
     * 档案所在地址
     */
    private String fileAddress;

}
