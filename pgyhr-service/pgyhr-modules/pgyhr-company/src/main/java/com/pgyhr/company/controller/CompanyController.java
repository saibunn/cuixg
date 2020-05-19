package com.pgyhr.company.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pgyhr.company.business.CompanyContactsService;
import com.pgyhr.company.business.CompanyDTOService;
import com.pgyhr.company.business.CompanyService;
import com.pgyhr.company.entity.dto.CompanyAndContactsListDTO;
import com.pgyhr.company.entity.dto.CompanyContactsDTO;
import com.pgyhr.company.entity.dto.CompanyRequestDTO;
import com.pgyhr.company.entity.po.CompanyContacts;
import com.pgyhr.company.entity.po.CompanyPO;
import com.pgyhr.core.common.utils.CommonUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.core.entity.User;
import com.pgyhr.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


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
    @Autowired
    private CompanyContactsService companyContactsService;
    @Autowired
    private CompanyDTOService companyDTOService;
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/getCompanyAll",method = RequestMethod.GET)
    @ApiOperation(value = "获取公司信息")
    public Result<List<CompanyPO>> getCompanyAll(){
        List<CompanyPO> companyPOAll = companyService.list();
        String key = "Company::";
        //查缓存
        String v = redisTemplate.opsForValue().get(key);
        if(StrUtil.isNotBlank(v) && !"[]".equals(v)){
            System.out.println("进缓存");
            companyPOAll = new Gson().fromJson(v, new TypeToken<List<CompanyPO>>(){}.getType());
            return new ResultUtil<List<CompanyPO>>().setData(companyPOAll);
        }
        //添加缓存
        redisTemplate.opsForValue().set(key, new Gson().toJson(companyPOAll), 15L, TimeUnit.DAYS);
        return new ResultUtil<List<CompanyPO>>().setData(companyPOAll);
    }

    @RequestMapping(value = "/getCompanyPage",method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取公司信息")
    public Result<Page<CompanyPO>> getCompanyPage(CompanyRequestDTO companyRequestDTO){
        Page<CompanyPO> companyPOPage = new Page<>(companyRequestDTO.getCurrentPage(),companyRequestDTO.getSize());
        companyPOPage = companyService.getCompanyPageByParam(companyPOPage,companyRequestDTO);
        return new ResultUtil<Page<CompanyPO>>().setData(companyPOPage);
    }

    /*@RequestMapping(value = "/getCompanyPage",method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取公司信息")
    public Result<IPage<CompanyAndContactsListDTO>> getCompanyPage(CompanyRequestDTO companyRequestDTO){
        IPage<CompanyAndContactsListDTO> companyDTOPage = new Page<>(companyRequestDTO.getCurrentPage(),companyRequestDTO.getSize());
        companyDTOPage = companyDTOService.getCompanyDTO(companyDTOPage,companyRequestDTO);
        System.out.println(companyDTOPage);
        return new ResultUtil<IPage<CompanyAndContactsListDTO>>().setData(companyDTOPage);
    }*/

    @RequestMapping(value = "/saveCompany",method = RequestMethod.POST)
    @ApiOperation(value = "添加公司")
    public Result<Object> saveCompany(@RequestBody CompanyAndContactsListDTO companyAndContactsListDTO){
        System.out.println(companyAndContactsListDTO.getCompanyParentid()+"************************");
        companyAndContactsListDTO.setCompanyCode(CommonUtil.buildId("C"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        companyAndContactsListDTO.setCreatedTime(df.format(new Date()));
        System.out.println(companyAndContactsListDTO.getCompanyContactsDTOList());
        companyDTOService.insertDetails(companyAndContactsListDTO);
        redisTemplate.delete("Company::");
        return ResultUtil.success("提交成功");
    }

    @RequestMapping(value = "/getCompanyLevel",method = RequestMethod.GET)
    @ApiOperation(value = "获取母公司列表")
    @ResponseBody
    public Result<List<CompanyPO>> getCompanyLevel(@RequestParam(required=false) int level){
        System.out.println(level);
        List<CompanyPO> companyPOLevel = companyService.getCompanyPOLevel(level);
        System.out.print(companyPOLevel);
        return new ResultUtil<List<CompanyPO>>().setData(companyPOLevel);
    }

    @RequestMapping(value = "/getCompanyCode",method = RequestMethod.GET)
    @ApiOperation(value = "根据code获取公司主从")
    @ResponseBody
    public Result<CompanyAndContactsListDTO> getCompanyCode(@RequestParam(required=false) String compamyCode){
        System.out.println(compamyCode);
        CompanyAndContactsListDTO companyAndContactsListDTO = companyDTOService.queryCompanyCode(compamyCode);
        System.out.println(companyAndContactsListDTO+"-------------------");
        return new ResultUtil<CompanyAndContactsListDTO>().setData(companyAndContactsListDTO);
    }

    @RequestMapping(value = "/updCompany",method = RequestMethod.PUT)
    @ApiOperation(value = "修改公司信息")
    public Result<Object> updCompany(@RequestBody CompanyAndContactsListDTO companyAndContactsListDTO){
        System.out.println(companyAndContactsListDTO);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        companyAndContactsListDTO.setModifiedTime(df.format(new Date()));
        int count = companyDTOService.updateCompany(companyAndContactsListDTO);
        if(count>0){
            int countUpdAdd = companyContactsService.deleteAdd(companyAndContactsListDTO);
        }
        redisTemplate.delete("Company::");
        return ResultUtil.success("提交成功");
    }

    @RequestMapping(value = "/delCompany",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据客户code删除公司主从信息")
    public Result<Object> delCompany(@RequestParam(required=false) String compamyCode){
        System.out.println(compamyCode);
        companyContactsService.delCompanyC(compamyCode);
        companyService.delCompany(compamyCode);
        redisTemplate.delete("Company::");
        return ResultUtil.success("提交成功");
    }

}
