package com.pgyhr.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pgyhr.task.dao.mapper.EmpCompanyMapper;
import com.pgyhr.task.entity.dto.EmpCompanyRequestDTO;
import com.pgyhr.task.entity.po.EmpCompanyPO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetPO;
import com.pgyhr.task.service.EmpCompanyService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 客户雇员表 服务实现类
 * </p>
 *
 * @author xiaoguang.cui
 * @since 2020-04-20
 */
@Service
public class EmpCompanyServiceImpl extends ServiceImpl<EmpCompanyMapper, EmpCompanyPO> implements EmpCompanyService {

    @Override
    public EmpCompanyPO getEmpCompanyInfoByParam(EmpCompanyRequestDTO empCompanyRequestDTO) {
        QueryWrapper<EmpCompanyPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id",empCompanyRequestDTO.getEmployeeId());
        queryWrapper.orderByDesc("created_time");
        List<EmpCompanyPO> empCompanyPOList = baseMapper.selectList(queryWrapper);
        if(!CollectionUtils.isEmpty(empCompanyPOList)){
            return  empCompanyPOList.get(0);
        }
        return null;
    }
}
