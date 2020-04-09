package com.pgyhr.open.service;

import com.pgyhr.core.base.PgyhrBaseService;
import com.pgyhr.core.common.vo.SearchVo;
import com.pgyhr.open.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author cuixg
 * @title: ClientService
 * @projectName pgyhr-module
 * @description: 客户端接口
 * @date 2020/4/3  11:33
 */
public interface ClientService extends PgyhrBaseService<Client, String> {

    /**
    * 多条件分页获取
    * @param client
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<Client> findByCondition(Client client, SearchVo searchVo, Pageable pageable);

}