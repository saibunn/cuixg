package com.pgyhr.your;

import com.pgyhr.core.common.annotation.RateLimiter;
import com.pgyhr.core.common.lock.Callback;
import com.pgyhr.core.common.lock.RedisLockTemplate;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author cuixg
 * @title: TestController
 * @projectName pgyhr-module
 * @description: 测试接口实现
 * @date 2020/4/3  11:33
 */
@Slf4j
@Controller
@Api(description = "测试接口")
@Transactional
@RequestMapping(value = "/pgyhr/test")
public class TestController {

    @Autowired
    private RedisLockTemplate redisLockTemplate;

    @RequestMapping(value = "/lockAndLimit", method = RequestMethod.GET)
    @RateLimiter(limit = 1, timeout = 5000)
    @ApiOperation(value = "同步锁限流测试")
    @ResponseBody
    public Result<Object> test1(HttpServletRequest request) {

        redisLockTemplate.execute("订单流水号", 3, TimeUnit.SECONDS, new Callback() {
            @Override
            public Object onGetLock() throws InterruptedException {
                // TODO 获得锁后要做的事
                log.info("生成订单流水号");
                return null;
            }

            @Override
            public Object onTimeout() throws InterruptedException {
                // TODO 未获取到锁（获取锁超时）后要做的事
                log.info("oops 没拿到锁");
                return null;
            }
        });

        return ResultUtil.data(null);
    }
}

