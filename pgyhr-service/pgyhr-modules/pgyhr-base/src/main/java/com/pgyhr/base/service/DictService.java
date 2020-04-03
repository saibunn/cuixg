package com.pgyhr.base.service;

import com.pgyhr.base.entity.Dict;
import com.pgyhr.core.base.PgyhrBaseService;

import java.util.List;

/**
 * @author cuixg
 * @title: DictService
 * @projectName pgyhr-module
 * @description: 字典接口
 * @date 2020/4/3  11:33
 */
public interface DictService extends PgyhrBaseService<Dict,String> {

    /**
     * 排序获取全部
     * @return
     */
    List<Dict> findAllOrderBySortOrder();

    /**
     * 通过type获取
     * @param type
     * @return
     */
    Dict findByType(String type);

    /**
     * 模糊搜索
     * @param key
     * @return
     */
    List<Dict> findByTitleOrTypeLike(String key);
}