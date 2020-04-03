package com.pgyhr.core.common.lock;

/**
 * @author cuixg
 * @title: Callback
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/3  11:33
 */
public interface Callback {

    /**
     * 成功获取锁后执行方法
     * @return
     * @throws InterruptedException
     */
    Object onGetLock() throws InterruptedException;

    /**
     * 获取锁超时回调
     * @return
     * @throws InterruptedException
     */
    Object onTimeout() throws InterruptedException;
}
