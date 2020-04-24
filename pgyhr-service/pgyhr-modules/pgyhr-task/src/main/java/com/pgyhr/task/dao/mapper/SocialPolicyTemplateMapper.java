package com.pgyhr.task.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateDTO;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateResponeDTO;
import com.pgyhr.task.entity.po.SocialPolicyTemplatePO;

import java.util.List;

/**
 * <p>
 * 全国社保字典 Mapper 接口
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-24
 */
public interface SocialPolicyTemplateMapper extends BaseMapper<SocialPolicyTemplatePO> {

    List<SocialPolicyTemplateResponeDTO> querySocialPolicyByParam(SocialPolicyTemplateDTO socialPolicyTemplateDTO);
}
