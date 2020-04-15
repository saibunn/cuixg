package com.pgyhr.base.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.base.dao.mapper.WorldMapMapper;
import com.pgyhr.base.entity.po.WorldMapPO;
import com.pgyhr.base.service.WorldMapService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-15
 */
@Service
public class WorldMapServiceImpl extends ServiceImpl<WorldMapMapper, WorldMapPO> implements WorldMapService {

    @Override
    public List<WorldMapPO> getCountryData() {
        return baseMapper.selectList(new QueryWrapper<>());
    }
}
