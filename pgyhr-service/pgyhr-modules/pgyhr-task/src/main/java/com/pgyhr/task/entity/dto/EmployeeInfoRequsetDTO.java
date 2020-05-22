package com.pgyhr.task.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 雇员信息表
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-20
 */
@Data
public class EmployeeInfoRequsetDTO implements Serializable{


    private static final long serialVersionUID = 8767213848073302933L;
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
     * 证件号码
     */
    private String idNum;

    /**
     * 雇员出生日期
     */
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birthday;

    /**
     * 户口性质:1: 非农业户口, 2: 农业户口
     */
    private Integer residentType;

    /**
     * 雇员性别:0,男性，1，女性    2，中性
     */
    private Integer gender;

    /**
     * 婚姻状况:0: 未婚, 1: 已婚，2：离异3：丧偶
     */
    private Integer marriageStatus;

    /**
     * 结婚日期
     */
    private LocalDateTime marriageDate;

    /**
     * 子女情况:0:无子女 1:独生子女 2:有子女但非独生子女
     */
    private Integer childStatus;

    /**
     * 子女数量
     */
    private Integer childNum;

    /**
     * 健康状况:0:健康或良好 1:残疾 2:一般或软弱 3: 有疾病, 4: 有生理缺陷
     */
    private Integer healthStatus;
    /**
     * 教育程度：1.博士后,2.博士研究生,3.硕士,4.硕士研究生,5.大学本科,6.大学专科,7.中专,8.中等专科,9.职业高中,10.技工学校,11.技校,12.普通高中,13.职高,14.职专,15.初中,16.小学,17.文盲或半文盲,18.其他
     */
    private Integer eduLevel;

    /**
     * 人员类别:1.新成长失业人员,2.就业转失业人员,3.其他失业人员,4.在业人员,5.退休人员,6.在学人员,7.退伍军人,8.农村劳动力,9.外来劳动力	10.其他
     */
    private Integer empType;

    /**
     * 个人身份:1.工人,2.原工商业者,3.农民,4.学生,5.干部,6.现役军人,7.无业人员,8.其他
     */
    private Integer empIdentity;

    /**
     * 参加工作日期
     */
    private LocalDateTime workDate;

    /**
     * 政治面貌：0: 群众, 1: 党员，2：团员
     */
    private Integer policy;

    /**
     * 国籍code
     */
    private String countryCode;


    /**
     * 国籍
     */
    private String countryName;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /**
     * 修改人
     */
    private String modifiedBy;

    /**
     * 最后修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

}
