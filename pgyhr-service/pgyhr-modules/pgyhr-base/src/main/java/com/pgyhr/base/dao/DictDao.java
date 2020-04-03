package com.pgyhr.base.dao;

import com.pgyhr.base.entity.Dict;
import com.pgyhr.core.base.PgyhrBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author cuixg
 * @title: DictDao
 * @projectName pgyhr-module
 * @description: 字典数据处理层
 * @date 2020/4/3  11:33
 */
public interface DictDao extends PgyhrBaseDao<Dict,String> {

    /**
     * 排序获取全部
     * @return
     */
    @Query(value = "select * from t_dict d order by d.sort_order", nativeQuery = true)
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
    @Query(value = "select * from t_dict d where d.title like %:key% or d.type like %:key% order by d.sort_order", nativeQuery = true)
    List<Dict> findByTitleOrTypeLike(@Param("key") String key);
}