package com.pgyhr.task.controller;

import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateDTO;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateListResponseDTO;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateResponseDTO;
import com.pgyhr.task.entity.po.SocialPolicyTemplatePO;
import com.pgyhr.task.service.SocialPolicyTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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
public class SocialPolicyTemplateController{

    @Autowired
    private SocialPolicyTemplateService socialPolicyTemplateService;

    @ApiOperation(value = "根据条件取社保字典明细")
    @RequestMapping(value = "/getSocialPolicyByParam",method = RequestMethod.GET)
    public Result<SocialPolicyTemplateListResponseDTO> getSocialPolicyByParam(SocialPolicyTemplateDTO socialPolicyTemplateDTO){
        List<SocialPolicyTemplatePO> socialPolicyTemplatePOList = socialPolicyTemplateService.getSocialPolicyByParam(socialPolicyTemplateDTO);
        SocialPolicyTemplateListResponseDTO socialPolicyTemplateListResponeDTO = new SocialPolicyTemplateListResponseDTO();
        socialPolicyTemplateListResponeDTO.setSocialPolicyTemplatePOList(
                socialPolicyTemplatePOList.stream().filter(a -> a.getPolicyType() == 1 ).collect(Collectors.toList()));
        socialPolicyTemplateListResponeDTO.setFundPolicyTemplatePOList(
                socialPolicyTemplatePOList.stream().filter(a -> a.getPolicyType() == 2 ).collect(Collectors.toList()));
        return new ResultUtil<SocialPolicyTemplateListResponseDTO>().setData(socialPolicyTemplateListResponeDTO);
    }

    @ApiOperation(value = "根据条件取社保字典")
    @RequestMapping(value = "/getSocialPolicyItemByParam",method = RequestMethod.GET)
    public Result<List<SocialPolicyTemplateResponseDTO>> getSocialPolicyItemByParam(SocialPolicyTemplateDTO socialPolicyTemplateDTO){
        List<SocialPolicyTemplateResponseDTO> socialPolicyTemplateResponeDTOList = socialPolicyTemplateService.getSocialPolicyItemByParam(socialPolicyTemplateDTO);
        return new ResultUtil<List<SocialPolicyTemplateResponseDTO>>().setData(socialPolicyTemplateResponeDTOList);
    }
}
