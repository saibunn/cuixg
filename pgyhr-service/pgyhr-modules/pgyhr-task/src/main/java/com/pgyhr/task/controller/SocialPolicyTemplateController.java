package com.pgyhr.task.controller;

import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.CommonUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.task.entity.CodePrefixUtil;
import com.pgyhr.task.entity.dto.EmployeeInfoRequsetDTO;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateDTO;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateResponeDTO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.service.EmployeeInfoService;
import com.pgyhr.task.service.SocialPolicyTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


/**
 * @author cuixg
 * @title: EmployeeController
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/24 17:50
 */
@Slf4j
@RestController
@Api(description = "全国社保字典")
@RequestMapping("/pgyhr/socialPolicy")
@Transactional
public class SocialPolicyTemplateController<E, ID extends Serializable>{

    @Autowired
    private SocialPolicyTemplateService socialPolicyTemplateService;

    @ApiOperation(value = "根据条件取社保政策")
    @RequestMapping(value = "/getSocialPolicyByParam",method = RequestMethod.GET)
    public Result<List<SocialPolicyTemplateResponeDTO>> getSocialPolicyByParam(SocialPolicyTemplateDTO socialPolicyTemplateDTO){
        List<SocialPolicyTemplateResponeDTO> socialPolicyTemplateResponeDTOList = socialPolicyTemplateService.getSocialPolicyByParam(socialPolicyTemplateDTO);
        return new ResultUtil<List<SocialPolicyTemplateResponeDTO>>().setData(socialPolicyTemplateResponeDTOList);
    }
}
