package com.lf.system.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author lufeifan
 * @date 2021/10/25 09:43
 **/

@MapperScan(basePackages = "com.lf.system.admin.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class LfSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LfSystemApplication.class,args);
    }
}
