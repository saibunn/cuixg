package com.pgyhr.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.base.entity.dto.AreaDataDTO;
import com.pgyhr.base.entity.po.AreaPO;

import java.util.List;

/**
 * <p>
 * 地区码表 服务类
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-08
 */
public interface AreaService extends IService<AreaPO> {

    List<AreaDataDTO> getAreaData();

    List<AreaPO> getAllAreaData();
}
