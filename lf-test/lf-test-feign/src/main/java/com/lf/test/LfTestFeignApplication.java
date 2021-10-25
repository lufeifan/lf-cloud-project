package com.lf.test;

import com.lf.common.feign.annotation.EnableLfFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义 Feign 测试
 *
 * @author lufeifan
 * @date 2021/10/22 09:59
 **/
@EnableLfFeignClients
@SpringBootApplication
public class LfTestFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(LfTestFeignApplication.class,args);
    }
}
