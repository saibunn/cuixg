package com.pgyhr.core.config.lock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @author cuixg
 * @title: RedisLockConfig
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Configuration
public class RedisLockConfig {

    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockRegistry(redisConnectionFactory, "pgyhr-lock");
    }
}