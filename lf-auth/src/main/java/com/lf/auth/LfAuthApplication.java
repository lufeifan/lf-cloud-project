package com.lf.auth;

import com.lf.common.feign.annotation.EnableLfFeignClients;
import com.lf.common.swagger.annotation.EnableCustomSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * lf-auth 启动入口
 *
 * @author lufeifan
 * @date 2021/10/21 20:44
 **/
@EnableLfFeignClients
@EnableCustomSwagger
@EnableDiscoveryClient
@SpringBootApplication
public class LfAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LfAuthApplication.class,args);
    }
}
