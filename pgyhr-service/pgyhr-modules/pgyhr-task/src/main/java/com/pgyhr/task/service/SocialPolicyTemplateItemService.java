package com.pgyhr.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentRequestDTO;
import com.pgyhr.task.entity.po.SocialPolicyTemplateItemPO;

import java.util.List;

/**
 * <p>
 * 全国社保字典明细 服务类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-24
 */
public interface SocialPolicyTemplateItemService extends IService<SocialPolicyTemplateItemPO> {

    List<SocialPolicyTemplateItemPO> getSocialPolicyTemplateItemByParentIds(EmpFrontTaskSheetSocialFeeSegmentRequestDTO empFrontTaskSheetSocialFeeSegmentRequestDTO);
}
