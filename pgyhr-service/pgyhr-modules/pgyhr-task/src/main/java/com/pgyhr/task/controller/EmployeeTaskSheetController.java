package com.pgyhr.task.controller;

import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.task.entity.dto.EmployeeInfoRequsetDTO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.service.EmployeeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;


/**
 * @author cuixg
 * @title: EmployeeTaskSheetController
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/20 19:50
 */
@Slf4j
@RestController
@Api(description = "雇员任务单")
@RequestMapping("/pgyhr/task")
@Transactional
public class EmployeeTaskSheetController<E, ID extends Serializable>{

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @RequestMapping(value = "/getEmployeeInfoById",method = RequestMethod.GET)
    @ApiOperation(value = "根据雇员ID取雇员信息")
    public Result<EmployeeInfoPO> getEmployeeInfoById(EmployeeInfoRequsetDTO employeeInfoRequsetDTO){
        EmployeeInfoPO employeeInfoPO = employeeInfoService.getById(employeeInfoRequsetDTO.getEmployeeId());
        return new ResultUtil<EmployeeInfoPO>().setData(employeeInfoPO);
    }

    @ApiOperation(value = "新增雇员信息")
    @PostMapping(value = "/addEmployeeInfo")
    public Result<E> addEmployeeInfoById(@RequestBody EmployeeInfoRequsetDTO employeeInfoRequsetDTO){
        EmployeeInfoPO employeeInfoPO = CommonTransform.convertToDTO(employeeInfoRequsetDTO,EmployeeInfoPO.class);
        if(employeeInfoService.save(employeeInfoPO)){
            return new ResultUtil<E>().setSuccessMsg("新增雇员成功！");
        }else{
            return new ResultUtil<E>().setErrorMsg("新增雇员失败！");
        }
    }
}
