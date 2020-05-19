package com.pgyhr.task.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.CommonUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.task.entity.CodePrefixUtil;
import com.pgyhr.task.entity.dto.EmpCompanyRequestDTO;
import com.pgyhr.task.entity.dto.EmpCompanyWhereDTO;
import com.pgyhr.task.entity.dto.EmployeeInfoRequsetDTO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.service.EmpCompanyDTOService;
import com.pgyhr.task.service.EmployeeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * @author cuixg
 * @title: EmployeeController
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/20 17:50
 */
@Slf4j
@RestController
@Api(description = "雇员信息")
@RequestMapping("/pgyhr/employee")
@Transactional
public class EmployeeController <E, ID extends Serializable>{

    @Autowired
    private EmployeeInfoService employeeInfoService;
    @Autowired
    private EmpCompanyDTOService empCompanyDTOService;

    @ApiOperation(value = "根据雇员ID取雇员信息")
    @RequestMapping(value = "/getEmployeeInfoById",method = RequestMethod.GET)
    public Result<EmployeeInfoPO> getEmployeeInfoById(EmployeeInfoRequsetDTO employeeInfoRequsetDTO){
        EmployeeInfoPO employeeInfoPO = employeeInfoService.getById(employeeInfoRequsetDTO.getEmployeeId());
        return new ResultUtil<EmployeeInfoPO>().setData(employeeInfoPO);
    }

    @ApiOperation(value = "新增雇员信息")
    @PostMapping(value = "/saveEmployeeInfo")
    public Result<EmployeeInfoPO> addEmployeeInfoById(@RequestBody EmployeeInfoRequsetDTO employeeInfoRequsetDTO){
        EmployeeInfoPO employeeInfoPO = CommonTransform.convertToDTO(employeeInfoRequsetDTO,EmployeeInfoPO.class);
        List<EmployeeInfoPO> employeeInfoPOList  = employeeInfoService.selectEmployeeInfoByParam(employeeInfoRequsetDTO);
        if(CollectionUtils.isEmpty(employeeInfoPOList)){
            employeeInfoPO.setEmployeeId(CommonUtil.buildId(CodePrefixUtil.EMP_CODE_PREFIX));
            if(employeeInfoService.save(employeeInfoPO)) {
                Result<EmployeeInfoPO> result = new ResultUtil<EmployeeInfoPO>().setData(employeeInfoPO);
                result.setMessage("新增雇员成功");
                return result;
            }else {

                return new ResultUtil<EmployeeInfoPO>().setErrorMsg("新增雇员失败！");
            }
        }else{
            return new ResultUtil<EmployeeInfoPO>().setErrorMsg("新增雇员已存在");
        }
    }

    @ApiOperation(value = "多条件分页获取雇员信息")
    @RequestMapping(value = "/getEmpCompanyDTOPage",method = RequestMethod.GET)
    public Result<IPage<EmpCompanyRequestDTO>> getEmpCompanyDTOPage(EmpCompanyWhereDTO empCompanyWhereDTO){
        System.out.println(empCompanyWhereDTO);
        IPage<EmpCompanyRequestDTO> empCompanyRequestDTOIPage = new Page<>(empCompanyWhereDTO.getCurrentPage(),empCompanyWhereDTO.getSize());
        empCompanyRequestDTOIPage = empCompanyDTOService.getEmpCompany(empCompanyRequestDTOIPage,empCompanyWhereDTO);
        System.out.println(empCompanyRequestDTOIPage.getRecords()+"***************************");
        return new ResultUtil<IPage<EmpCompanyRequestDTO>>().setData(empCompanyRequestDTOIPage);
    }
}
