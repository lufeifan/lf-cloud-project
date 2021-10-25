package com.lf.test.log;

import com.lf.common.feign.annotation.EnableLfFeignClients;
import com.lf.common.log.annotation.EnableLfLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * 日志测试启动类
 *
 * @author lufeifan
 * @date 2021/10/22 15:14
 **/
@EnableLfFeignClients
@EnableLfLog
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
