package com.pgyhr.company.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cuixg
 * @title: CompanyRequestDTO
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/5  12:33
 */
@Data
public class CompanyRequestDTO extends CommonListDTO implements Serializable {


	private static final long serialVersionUID = 7183532174241019677L;


	/**
	 * 客户公司ID
	 */
	private String companyCode;

	/**
	 * 客户公司名称
	 */
	private String companyName;

	/**
	 * 使用状态:1-使用，0-禁用
	 */
	private Boolean isActive;
}
