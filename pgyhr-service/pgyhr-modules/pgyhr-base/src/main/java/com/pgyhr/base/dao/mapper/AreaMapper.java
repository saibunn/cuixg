package com.pgyhr.base.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pgyhr.base.entity.dto.AreaDataDTO;
import com.pgyhr.base.entity.po.AreaPO;

import java.util.List;

/**
 * <p>
 * 地区码表 Mapper 接口
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-08
 */
public interface AreaMapper extends BaseMapper<AreaPO> {

    List<AreaDataDTO> queryAreaData();
}
