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
import com.pgyhr.task.entity.translator.EmpBackTaskSheetTranslator;
import com.pgyhr.task.entity.translator.EmpFrontTaskSheetSocialFeeSegmentTranslator;
import com.pgyhr.task.entity.translator.EmpFrontTaskSheetTranslator;
import com.pgyhr.task.entity.translator.EmployeeInfoTranslator;
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
}
