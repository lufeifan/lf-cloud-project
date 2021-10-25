package com.lf.gateway;

import com.lf.common.swagger.annotation.EnableCustomSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关启动类
 *
 * @author lufeifan
 * @date 2021/10/21 20:54
 **/
@EnableCustomSwagger
@EnableDiscoveryClient
@SpringBootApplication
public class LfGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LfGatewayApplication.class,args);
    }
}
