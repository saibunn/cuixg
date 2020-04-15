package com.pgyhr.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pgyhr.base.entity.po.WorldMapPO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-15
 */
public interface WorldMapService extends IService<WorldMapPO> {

    List<WorldMapPO> getCountryData();
}
