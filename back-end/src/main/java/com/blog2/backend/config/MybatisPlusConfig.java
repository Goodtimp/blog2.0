package com.blog2.backend.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: goodtimp
 * @Date: 2019/10/10 14:15
 * @description :  mybatisPlus配置，分页
 */
@EnableTransactionManagement
@Configuration
@MapperScan({"com.blog2.backend.dao.*.mapper"})
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
