package com.pgyhr.core.service;


import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.core.common.vo.SearchVo;
import com.pgyhr.core.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author cuixg
 * @title: LogService
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
public interface LogService extends PgyhrBaseService<Log, String> {

    /**
     * 分页搜索获取日志
     * @param type
     * @param key
     * @param searchVo
     * @param pageable
     * @return
     */
    Page<Log> findByConfition(Integer type, String key, SearchVo searchVo, Pageable pageable);

    /**
     * 删除所有
     */
    void deleteAll();
}
