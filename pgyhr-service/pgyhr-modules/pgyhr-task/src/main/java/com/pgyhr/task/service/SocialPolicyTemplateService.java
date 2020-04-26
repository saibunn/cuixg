package com.pgyhr.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateDTO;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateResponeDTO;
import com.pgyhr.task.entity.po.SocialPolicyTemplatePO;

import java.util.List;

/**
 * <p>
 * 全国社保字典 服务类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-24
 */
public interface SocialPolicyTemplateService extends IService<SocialPolicyTemplatePO> {

    List<SocialPolicyTemplatePO> getSocialPolicyByParam(SocialPolicyTemplateDTO socialPolicyTemplateDTO);

    List<SocialPolicyTemplateResponeDTO> getSocialPolicyItemByParam(SocialPolicyTemplateDTO socialPolicyTemplateDTO);
}
