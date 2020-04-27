package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentRequestDTO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.entity.po.SocialPolicyTemplateItemPO;
import com.pgyhr.task.dao.mapper.SocialPolicyTemplateItemMapper;
import com.pgyhr.task.service.SocialPolicyTemplateItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

/**
 * <p>
 * 全国社保字典明细 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-24
 */
@Service
public class SocialPolicyTemplateItemServiceImpl extends ServiceImpl<SocialPolicyTemplateItemMapper, SocialPolicyTemplateItemPO> implements SocialPolicyTemplateItemService {

    @Override
    public List<SocialPolicyTemplateItemPO> getSocialPolicyTemplateItemByParentIds(EmpFrontTaskSheetSocialFeeSegmentRequestDTO empFrontTaskSheetSocialFeeSegmentRequestDTO) {
        String [] socialPolicyCodeArr = {empFrontTaskSheetSocialFeeSegmentRequestDTO.getSocialPolicyCode(),empFrontTaskSheetSocialFeeSegmentRequestDTO.getFundlPolicyCode()};
        QueryWrapper<SocialPolicyTemplateItemPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("social_policy_code",socialPolicyCodeArr);
        return baseMapper.selectList(queryWrapper);
    }
}
