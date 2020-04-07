package com.pgyhr.company.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pgyhr.company.business.CompanyService;
import com.pgyhr.company.entity.dto.CompanyRequestDTO;
import com.pgyhr.company.entity.po.CompanyPO;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author cuixg
 * @title: CompanyController
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/5 17:50
 */
@Slf4j
@RestController
@Api(description = "客户公司")
@RequestMapping("/pgyhr/company")
@Transactional
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/getCompanyPage",method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取用户列表")
    public Result<Page<CompanyPO>> getCompanyPage(CompanyRequestDTO companyRequestDTO){

        Page<CompanyPO> companyPOPage = new Page<>(companyRequestDTO.getCurrentPage(),companyRequestDTO.getSize());
        companyPOPage = companyService.getCompanyPageByParam(companyPOPage,companyRequestDTO);
        System.out.print("test");
        return new ResultUtil<Page<CompanyPO>>().setData(companyPOPage);
    }
}
