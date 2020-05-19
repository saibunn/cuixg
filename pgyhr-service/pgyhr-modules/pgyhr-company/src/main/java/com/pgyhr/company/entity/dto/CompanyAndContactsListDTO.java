package com.pgyhr.company.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.pgyhr.company.entity.po.CompanyContacts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@ApiModel(value="CompanyAndContactsListDTO对象", description="")
@TableName("p_company")
public class CompanyAndContactsListDTO implements Serializable{

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "客户公司ID")
    private String companyCode;

    @ApiModelProperty(value = "客户公司名称")
    private String companyName;

    @ApiModelProperty(value = "客户公司级别（0:母公司1:子公司）")
    private Integer companyLevel;

    @ApiModelProperty(value = "客户公司所属母公司（关联主键）")
    @TableField("company_parentId")
    private String companyParentid;

    @ApiModelProperty(value = "纳税类型（1.一般纳税人、2.小规模企业）")
    private Integer taxTypes;

    @ApiModelProperty(value = "营业执照复印件")
    private String photocopyBusinessLicence;

    @ApiModelProperty(value = "注册地址所在地")
    private String companyRegisteredLocation;

    @ApiModelProperty(value = "注册详情地址")
    private String detailedAddressRegistered;

    @ApiModelProperty(value = "实际办公地址")
    private String companyRealityLocation;

    @ApiModelProperty(value = "实际详情地址")
    private String detailedAddressReality;

    @ApiModelProperty(value = "是否社保代办户（0：否1：是）")
    private Integer socialSecurityAgent;

    @ApiModelProperty(value = "养老账户")
    private String pensionAccount;

    @ApiModelProperty(value = "医疗账户")
    private String medicalAccount;

    @ApiModelProperty(value = "失业账户")
    private String unemploymentAccount;

    @ApiModelProperty(value = "工伤账户")
    private String inductrialInjuryAccounts;

    @ApiModelProperty(value = "生育账户")
    private String familyAccount;

    @ApiModelProperty(value = "是否公积金代办户（0：否1：是）")
    private Integer housingFundAgent;

    @ApiModelProperty(value = "基本公积金账户")
    private String basicHousingFundAgent;

    @ApiModelProperty(value = "补充公积金账户")
    private String replenishHousingFundAgent;

    @ApiModelProperty(value = "签约销售id")
    private String signedSalesId;

    @ApiModelProperty(value = "签约销售")
    private String signedSales;

    @ApiModelProperty(value = "服务开始时间")
    private LocalDateTime serviceStartTime;

    @ApiModelProperty(value = "责任客服id")
    private String responsibilityServiceId;

    @ApiModelProperty(value = "责任客服")
    private String responsibilityService;

    @ApiModelProperty(value = "收费方式（1.预收款2.垫款）")
    private Integer chargeType;

    @ApiModelProperty(value = "社保代理内部价格")
    private Double socialSecurityInteriorCharge;

    @ApiModelProperty(value = "社保代理外部价格")
    private Double socialSecurityExternalCharge;

    @ApiModelProperty(value = "开户行名称")
    private String openingBank;

    @ApiModelProperty(value = "银行账号")
    private String bankAccount;

    @ApiModelProperty(value = "开票联系")
    private String invoiceContacter;

    @ApiModelProperty(value = "开具发票类型（1.收据、2.增值税专用发票、3.增值税普通纸质发票、4.增值税普通电子发票）")
    private Integer invoiceType;

    @ApiModelProperty(value = "开具周期（1.月结、2.季结）")
    private Integer invoicePeriod;

    @ApiModelProperty(value = "使用状态:0-使用，1-禁用")
    private Integer useStatus;

    @ApiModelProperty(value = "使用次数")
    private Integer useCount;

    @ApiModelProperty(value = "是否可用:0-禁用 1-可用 ")
    private Boolean isActive;

    @ApiModelProperty(value = "版本号")
    private Long version;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    private String createdTime;

    @ApiModelProperty(value = "修改人")
    private String modifiedBy;

    @ApiModelProperty(value = "最后修改时间")
    private String modifiedTime;


    //private String signedSales;


    //private String responsibilityServiceName;

    @TableField(exist=false)
    private List<CompanyContacts> companyContactsDTOList;

}