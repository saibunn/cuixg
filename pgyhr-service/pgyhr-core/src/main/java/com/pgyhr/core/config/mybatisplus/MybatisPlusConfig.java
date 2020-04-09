package com.pgyhr.core.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cuixg
 * @title: MybatisPlusConfig
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Configuration
@MapperScan({"com.pgyhr.*.mapper", "com.pgyhr.*.*.mapper","com.pgyhr.*.mapper-dto","com.pgyhr.*.*.mapper-dto"})
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
