package com.pgyhr.task.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.task.entity.dto.EmployeeInfoRequsetDTO;
import com.pgyhr.task.entity.dto.EmployeeRequestDTO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.service.EmployeeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Slf4j
@RestController
@Api(description = "雇员信息")
@RequestMapping("/pgyhr/employeeInfo")
@Transactional
public class EmployeeInfoController <E, ID extends Serializable>{
    @Autowired
    private EmployeeInfoService employeeInfoService;

    @ApiOperation(value = "多条件分页获取雇员信息")
    @RequestMapping(value = "/getEmployeeInfoPage",method = RequestMethod.GET)
    public Result<Page<EmployeeInfoPO>> getEmployeeInfoPage(EmployeeRequestDTO employeeRequestDTO){
        Page<EmployeeInfoPO> employeeInfoPOPage = new Page<>(employeeRequestDTO.getCurrentPage(),employeeRequestDTO.getSize());
        employeeInfoPOPage = employeeInfoService.getEmployeeInfoPageByParam(employeeInfoPOPage,employeeRequestDTO);
        return new ResultUtil<Page<EmployeeInfoPO>>().setData(employeeInfoPOPage);
    }

    @ApiOperation(value = "根据Id查询雇员信息")
    @RequestMapping(value = "/getEmployeeId",method = RequestMethod.GET)
    @ResponseBody
    public Result<EmployeeInfoPO> getEmployeeId(@RequestParam(required=false) String employeeId){
        System.out.println(employeeId+"--------ID");
        EmployeeInfoPO employeeInfoPO = employeeInfoService.getById(employeeId);
        return new ResultUtil<EmployeeInfoPO>().setData(employeeInfoPO);
    }

    @ApiOperation(value = "修改雇员")
    @PutMapping(value = "/updEmployee")
    public Result<E> updEmployee(@RequestBody EmployeeInfoRequsetDTO employeeInfoRequsetDTO){
        System.out.println(employeeInfoRequsetDTO.getBirthday());
        EmployeeInfoPO employeeInfoPO = CommonTransform.convertToDTO(employeeInfoRequsetDTO,EmployeeInfoPO.class);
        boolean count = employeeInfoService.updateById(employeeInfoPO);
        if(count){
            return new ResultUtil<E>().setSuccessMsg("修改雇员成功！");
        }else{
            return new ResultUtil<E>().setErrorMsg("修改雇员失败！");
        }
    }
}
