package com.lf.test.mybatisPlus;

import com.lf.common.swagger.annotation.EnableCustomSwagger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lufeifan
 * @date 2021/10/22 11:30
 **/
@EnableCustomSwagger
@MapperScan("com.lf.test.mybatisPlus.mapper")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
