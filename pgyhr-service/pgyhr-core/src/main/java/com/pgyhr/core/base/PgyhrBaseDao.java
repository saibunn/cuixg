package com.pgyhr.core.base;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author cuixg
 * @title: PgyhrBaseDao
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/3  11:33
 */
// 自定义接口 不会创建接口的实例 必须加此注解
@NoRepositoryBean
public interface PgyhrBaseDao<E, ID extends Serializable> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {

}
