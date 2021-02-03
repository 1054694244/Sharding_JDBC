package com.shenzc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @shenzc
 * @2021/2/3 9:16
 * 文件说明：
 */
@SpringBootApplication
@MapperScan("com.shenzc.mapper")
public class ShardingJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class,args);
    }
}
