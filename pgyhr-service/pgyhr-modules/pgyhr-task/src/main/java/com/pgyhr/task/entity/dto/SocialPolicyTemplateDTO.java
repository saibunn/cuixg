package com.pgyhr.task.entity.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pgyhr.core.base.PgyhrBaseEntityNoId;
import lombok.Data;

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
@Data
public class SocialPolicyTemplateDTO implements Serializable {


    private static final long serialVersionUID = 8490944097602202118L;
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

}
