package com.pgyhr.task.service.impl;

import com.pgyhr.task.entity.dto.SocialPolicyTemplateDTO;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateResponeDTO;
import com.pgyhr.task.entity.po.SocialPolicyTemplatePO;
import com.pgyhr.task.dao.mapper.SocialPolicyTemplateMapper;
import com.pgyhr.task.service.SocialPolicyTemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 全国社保字典 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-24
 */
@Service
public class SocialPolicyTemplateServiceImpl extends ServiceImpl<SocialPolicyTemplateMapper, SocialPolicyTemplatePO> implements SocialPolicyTemplateService {

    @Override
    public List<SocialPolicyTemplateResponeDTO> getSocialPolicyByParam(SocialPolicyTemplateDTO socialPolicyTemplateDTO) {
        return baseMapper.querySocialPolicyByParam(socialPolicyTemplateDTO);
    }
}
