package com.pgyhr.core.common.lock;

import java.util.concurrent.TimeUnit;


/**
 * @author cuixg
 * @title: DistributedLockTemplate
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
public interface DistributedLockTemplate {

    /**
     * 执行方法
     * @param lockId 锁id(对应业务唯一ID)
     * @param timeout 最大等待获取锁时间
     * @param unit 等待时间单位
     * @param callback 回调方法
     * @return
     */
    Object execute(String lockId, Integer timeout, TimeUnit unit, Callback callback);
}
