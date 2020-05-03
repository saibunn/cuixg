package com.pgyhr.task.entity.dto;

import com.pgyhr.task.entity.po.SocialPolicyTemplatePO;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 全国社保字典
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-24
 */
@Data
public class SocialPolicyTemplateListResponseDTO implements Serializable {


    private static final long serialVersionUID = -2695107002259155697L;
    private List<SocialPolicyTemplatePO> socialPolicyTemplatePOList;

    private List<SocialPolicyTemplatePO> fundPolicyTemplatePOList;

}
