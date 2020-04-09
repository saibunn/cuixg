package com.pgyhr.base.controller.common;

import com.pgyhr.base.entity.dto.AreaDataDTO;
import com.pgyhr.base.service.AreaService;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cuixg
 * @title: areaDataController
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/8  19:33
 */
@Slf4j
@RestController
@Api(description = "地区接口")
@RequestMapping("/pgyhr/common")
@Transactional
public class AreaDataController {


    @Autowired
    private AreaService areaService;



    @RequestMapping(value = "/getAreaData", method = RequestMethod.GET)
    @ApiOperation(value = "地区信息")
    public Result<List<AreaDataDTO>> getAreaData() {
        List<AreaDataDTO> areaDataDTOList = areaService.getAreaData();
        return new ResultUtil<List<AreaDataDTO>>().setData(areaDataDTOList);
    }
}