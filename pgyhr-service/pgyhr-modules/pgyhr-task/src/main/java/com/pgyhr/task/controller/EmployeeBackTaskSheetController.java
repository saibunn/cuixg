package com.pgyhr.task.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.CommonUtil;
import com.pgyhr.core.common.utils.DateUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.task.entity.CodePrefixUtil;
import com.pgyhr.task.entity.dto.*;
import com.pgyhr.task.entity.po.*;
import com.pgyhr.task.entity.translator.*;
import com.pgyhr.task.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author cuixg
 * @title: EmployeeTaskSheetController
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/20 19:50
 */
@Slf4j
@RestController
@Api(description = "雇员后道任务单")
@RequestMapping("/pgyhr/back/task")
@Transactional
public class EmployeeBackTaskSheetController<E, ID extends Serializable>{

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @Autowired
    private EmpCompanyService empCompanyService;

    @Autowired
    private EmpBackTaskSheetServiceAgreementService empBackTaskSheetServiceAgreementService;

    @Autowired
    private EmpBackTaskSheetService  empBackTaskSheetService;

    @Autowired
    private EmpFrontTaskSheetService  empFrontTaskSheetService;


    @Autowired
    private EmpBackTaskSheetSocialFeeSegmentService empBackTaskSheetSocialFeeSegmentService;

    /**
     * 获取委托单列表分页
     * @author xiaoguang cui
     * @param empBackTaskSheetSearchRequestDTO
     * @return 所请求的分页数据
     */
    @RequestMapping(value = "/queryEmployeeBackTaskSheetPage",method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取雇员后道任务单列表")
    public Result<Page<EmpBackTaskSheetResponseDTO>> queryEmployeeBackTaskSheetPage(EmpBackTaskSheetSearchRequestDTO empBackTaskSheetSearchRequestDTO) {
        log.info("获取委托单列表分页","委托单列表查询条件"+empBackTaskSheetSearchRequestDTO);
        Page<EmpBackTaskSheetPO> empBackTaskSheetPOPage = new Page<>(empBackTaskSheetSearchRequestDTO.getCurrentPage(),empBackTaskSheetSearchRequestDTO.getSize());
        empBackTaskSheetPOPage = empBackTaskSheetService.getEmployeeBackTaskSheetPageByParam(empBackTaskSheetPOPage,empBackTaskSheetSearchRequestDTO);
        List<EmpBackTaskSheetResponseDTO> resultList = empBackTaskSheetPOPage.getRecords()
                .stream()
                .map(EmpBackTaskSheetTranslator::toTaskSheetResponseDTO)
                .collect(Collectors.toList());
        Page<EmpBackTaskSheetResponseDTO> resultPage = new Page<>(empBackTaskSheetPOPage.getCurrent(), empBackTaskSheetPOPage.getSize());
        resultPage.setTotal(empBackTaskSheetPOPage.getTotal());
        resultPage.setRecords(resultList);

        return new ResultUtil<Page<EmpBackTaskSheetResponseDTO>>().setData(resultPage);
    }

    /**
     * 获取后道雇员任务单详情
     * @author xiaoguang cui
     * @param empBackTaskSheetSearchRequestDTO
     * @return 后道雇员任务单详情数据
     */
    @RequestMapping(value = "/getEmployeeBackTaskSheetDetail",method = RequestMethod.GET)
    @ApiOperation(value = "雇员任务单取雇员信息")
    public Result<EmpBackTaskResponseDTO> getEmployeeTaskSheetDetail(EmpBackTaskSheetSearchRequestDTO empBackTaskSheetSearchRequestDTO) {
        EmpBackTaskResponseDTO empBackTaskResponseDTO = new EmpBackTaskResponseDTO();

        EmpBackTaskSheetPO empBackTaskSheetPO = empBackTaskSheetService.getEmpBackTaskSheetByKey(empBackTaskSheetSearchRequestDTO.getEmpBackTaskSheetCode());

        EmployeeInfoPO employeeInfoPO = employeeInfoService.getemployeeInfoByKey(empBackTaskSheetSearchRequestDTO.getEmployeeId());


        EmpBackTaskSheetSocialFeeSegmentResponseDTO empBackTaskSheetSocialFeeSegmentResponseDTO = new EmpBackTaskSheetSocialFeeSegmentResponseDTO();
        empBackTaskSheetSocialFeeSegmentResponseDTO.setEmpBackTaskSheetCode(empBackTaskSheetSearchRequestDTO.getEmpBackTaskSheetCode());
        List<EmpBackTaskSheetSocialFeeSegmentPO> empBackTaskSheetSocialFeeSegmentPOList =
                empBackTaskSheetSocialFeeSegmentService.getEmpBackTaskSheetSocialFeeSegmentByParam(empBackTaskSheetSocialFeeSegmentResponseDTO);

        if(empBackTaskSheetPO != null){
            empBackTaskResponseDTO.setEmpBackTaskSheetResponseDTO(EmpBackTaskSheetTranslator.toTaskSheetResponseDTO(empBackTaskSheetPO));
        }
        if(employeeInfoPO != null){
            empBackTaskResponseDTO.setEmployeeInfoResponseDTO(EmployeeInfoTranslator.toEmployeeInfoResponseDTO(employeeInfoPO));
        }

        if(!CollectionUtils.isEmpty(empBackTaskSheetSocialFeeSegmentPOList)){
            empBackTaskResponseDTO.setEmpBackTaskSheetSocialFeeSegmentResponseDTOList(empBackTaskSheetSocialFeeSegmentPOList
                    .stream()
                    .map(EmpBackTaskSheetSocialFeeSegmentTranslator::toEmpBackTaskSheetSocialFeeSegmentResponseDTO)
                    .collect(Collectors.toList()));
        }
        return new ResultUtil<EmpBackTaskResponseDTO>().setData(empBackTaskResponseDTO);
    }

    @ApiOperation(value = "后道客服确认")
    @PostMapping(value = "/submitBackServiceConfirm")
    public Result<E> submitBackServiceConfirm(@RequestBody EmpBackTaskSheetSearchRequestDTO empBackTaskSheetSearchRequestDTO){
        EmpBackTaskSheetPO empBackTaskSheetPO = empBackTaskSheetService.getEmpBackTaskSheetByKey(empBackTaskSheetSearchRequestDTO.getEmpBackTaskSheetCode());
        empBackTaskSheetPO.setTaskStatus(2);
        if(empBackTaskSheetService.updateById(empBackTaskSheetPO)){
            return new ResultUtil<E>().setSuccessMsg("后道客服确认成功！");
        }else{
            return new ResultUtil<E>().setErrorMsg("后道客服确认失败！");
        }
    }

    @ApiOperation(value = "后道专员确认")
    @PostMapping(value = "/submitBackCommissionerConfirm")
    public Result<E> submitBackCommissionerConfirm(@RequestBody EmpBackTaskSheetSearchRequestDTO empBackTaskSheetSearchRequestDTO){
        EmpBackTaskSheetPO empBackTaskSheetPO = empBackTaskSheetService.getEmpBackTaskSheetByKey(empBackTaskSheetSearchRequestDTO.getEmpBackTaskSheetCode());
        empBackTaskSheetPO.setTaskStatus(3);
        if(empBackTaskSheetService.updateById(empBackTaskSheetPO)){
            return new ResultUtil<E>().setSuccessMsg("后道专员确认成功！");
        }else{
            return new ResultUtil<E>().setErrorMsg("后道专员确认失败！");
        }
    }

    @ApiOperation(value = "后道专员确认")
    @PostMapping(value = "/rejectBackTaskSheetToFront")
    public Result<E> rejectBackTaskSheetToFront(@RequestBody EmpBackTaskSheetSearchRequestDTO empBackTaskSheetSearchRequestDTO){
        EmpBackTaskSheetPO empBackTaskSheetPO = empBackTaskSheetService.getEmpBackTaskSheetByKey(empBackTaskSheetSearchRequestDTO.getEmpBackTaskSheetCode());
        empBackTaskSheetPO.setTaskStatus(0);
        empBackTaskSheetPO.setRetreatReason(empBackTaskSheetSearchRequestDTO.getRetreatReason());
        if(empBackTaskSheetService.updateById(empBackTaskSheetPO)){
            return new ResultUtil<E>().setSuccessMsg("后道退单成功！");
        }else{
            return new ResultUtil<E>().setErrorMsg("后道退单失败！");
        }
    }


    @ApiOperation(value = "后道雇员任务单提交")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @PostMapping(value = "/submitEmpBackTaskSheetInfo")
    public Result<E> submitEmpBackTaskSheetInfo(@RequestBody EmpBackTaskSaveRequestDTO empBackTaskSaveRequestDTO){
        Boolean saveResult = true;
        if(empBackTaskSaveRequestDTO.getEmpBackTaskSheetSearchRequestDTO() != null){
            EmpBackTaskSheetPO empBackTaskSheetPO = empBackTaskSheetService.getEmpBackTaskSheetByKey(empBackTaskSaveRequestDTO.getEmpBackTaskSheetSearchRequestDTO().getEmpBackTaskSheetCode());
            //后道部分完成 todo
            empBackTaskSheetPO.setTaskStatus(5);
            empBackTaskSheetPO.setRemark(empBackTaskSaveRequestDTO.getEmpBackTaskSheetSearchRequestDTO().getRemark());
            empBackTaskSheetPO.setServiceFee(empBackTaskSaveRequestDTO.getEmpBackTaskSheetSearchRequestDTO().getServiceFee());
            if(empBackTaskSheetService.updateById(empBackTaskSheetPO)){

                //后道任务单社保费用段表
                List<EmpBackTaskSheetSocialFeeSegmentPO> empBackTaskSheetSocialFeeSegmentPOList =
                        CommonTransform.convertToDTOs(empBackTaskSaveRequestDTO.getEmpBackTaskSheetSocialFeeSegmentRequestDTOList(),EmpBackTaskSheetSocialFeeSegmentPO.class);

                if(!CollectionUtils.isEmpty(empBackTaskSheetSocialFeeSegmentPOList)){
                    empBackTaskSheetSocialFeeSegmentPOList.stream().forEach(item->{
                                item.setSocialStatus(1);
                            }
                    );
                    if(!empBackTaskSheetSocialFeeSegmentService.updateBatchById(empBackTaskSheetSocialFeeSegmentPOList)){
                        log.error("后道任务单社保费用段表表保存失败:" + empBackTaskSheetPO.toString());
                        saveResult = false;
                    }
                }

                if(saveResult) {
                    //回写前道任务单社保费用明细
                    saveResult = empFrontTaskSheetService.changeEmpFrontTaskSheetStatus(empBackTaskSheetPO,empBackTaskSheetSocialFeeSegmentPOList);
                }

            }else{
                saveResult = false;

            }
        }


        if(!saveResult){
            return new ResultUtil<E>().setErrorMsg("雇员新增任务单失败！");
        }
        return new ResultUtil<E>().setSuccessMsg("雇员新增任务单成功！");

    }


}
