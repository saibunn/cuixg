package com.pgyhr.company.entity.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CompanyContactsDTO对象", description="")
@TableName("p_company_contacts")
public class CompanyContactsDTO implements Serializable{

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "联系人ID")
    private Integer contactId;

    @ApiModelProperty(value = "客户ID（关联主表）")
    private String companyCode;

    @ApiModelProperty(value = "联系人名称")
    private String contactName;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "固定电话")
    private String telephone;

    @ApiModelProperty(value = "职务")
    private String duty;

    @ApiModelProperty(value = "QQ号")
    private String qqnumber;

    @ApiModelProperty(value = "邮箱")
    private String mail;

    @ApiModelProperty(value = "联系人上级")
    private String companySupName;

    @ApiModelProperty(value = "上级手机号码")
    private String mobileSup;

    @ApiModelProperty(value = "上级固定电话")
    private String telephoneSup;

    @ApiModelProperty(value = "上级职务")
    private String dutySup;

    @ApiModelProperty(value = "上级QQ号")
    private String qqnumberSup;

    @ApiModelProperty(value = "上级邮箱")
    private String mailSup;

    @ApiModelProperty(value = "联系人城市")
    private String contactLocation;

    @ApiModelProperty(value = "联系人详情地址")
    private String contactDetailedAddress;

}
