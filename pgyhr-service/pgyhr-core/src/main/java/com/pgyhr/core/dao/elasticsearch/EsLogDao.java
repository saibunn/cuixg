package com.pgyhr.core.dao.elasticsearch;

import com.pgyhr.core.entity.elasticsearch.EsLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @author cuixg
 * @title: EsLogDao
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
public interface EsLogDao extends ElasticsearchRepository<EsLog, String> {

    /**
     * 通过类型获取
     * @param type
     * @return
     */
    Page<EsLog> findByLogType(Integer type, Pageable pageable);
}
