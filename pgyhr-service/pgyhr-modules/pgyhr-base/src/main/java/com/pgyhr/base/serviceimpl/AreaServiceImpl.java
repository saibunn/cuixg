package com.pgyhr.base.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.base.dao.mapper.AreaMapper;
import com.pgyhr.base.entity.dto.AreaDataDTO;
import com.pgyhr.base.entity.po.AreaPO;
import com.pgyhr.base.service.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地区码表 服务实现类
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-08
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaPO> implements AreaService {

    @Override
    public List<AreaDataDTO> getAreaData() {
        return baseMapper.queryAreaData();
    }

    @Override
    public List<AreaPO> getAllAreaData() {
        QueryWrapper<AreaPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("level",new Integer[]{1, 2});
        queryWrapper.ne("cityCode","[]");
        return baseMapper.selectList(queryWrapper);
    }
}
