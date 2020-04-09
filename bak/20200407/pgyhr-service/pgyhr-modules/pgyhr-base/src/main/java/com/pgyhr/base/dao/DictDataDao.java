package com.pgyhr.base.dao;

import com.pgyhr.base.entity.DictData;
import com.pgyhr.core.base.PgyhrBaseDao;

import java.util.List;

/**
 * @author cuixg
 * @title: DictDao
 * @projectName pgyhr-module
 * @description: 字典数据数据处理层
 * @date 2020/4/3  11:33
 */
public interface DictDataDao extends PgyhrBaseDao<DictData,String> {


    /**
     * 通过dictId和状态获取
     * @param dictId
     * @param status
     * @return
     */
    List<DictData> findByDictIdAndStatusOrderBySortOrder(String dictId, Integer status);

    /**
     * 通过dictId删除
     * @param dictId
     */
    void deleteByDictId(String dictId);
}