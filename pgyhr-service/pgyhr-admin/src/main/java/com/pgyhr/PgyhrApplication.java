package com.pgyhr;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author cuixg
 * @title: PgyhrApplication
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/3  11:33
 */
@SpringBootApplication
//启用JPA审计
@EnableJpaAuditing
//启用缓存
@EnableCaching
//启用异步
@EnableAsync
//启用自带定时任务
@EnableScheduling
// 启用Admin监控
@EnableAdminServer
public class PgyhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(PgyhrApplication.class, args);
    }
}
