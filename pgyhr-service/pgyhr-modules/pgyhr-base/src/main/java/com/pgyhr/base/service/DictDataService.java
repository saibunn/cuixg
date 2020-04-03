package com.pgyhr.base.service;

import com.pgyhr.base.entity.DictData;
import com.pgyhr.core.base.PgyhrBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author cuixg
 * @title: DictDataService
 * @projectName pgyhr-module
 * @description: 字典数据接口
 * @date 2020/4/3  11:33
 */
public interface DictDataService extends PgyhrBaseService<DictData,String> {

    /**
     * 多条件获取
     * @param dictData
     * @param pageable
     * @return
     */
    Page<DictData> findByCondition(DictData dictData, Pageable pageable);

    /**
     * 通过dictId获取启用字典 已排序
     * @param dictId
     * @return
     */
    List<DictData> findByDictId(String dictId);

    /**
     * 通过dictId删除
     * @param dictId
     */
    void deleteByDictId(String dictId);
}