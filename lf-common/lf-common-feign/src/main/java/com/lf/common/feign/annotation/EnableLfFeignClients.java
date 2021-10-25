package com.lf.common.feign.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启Feign客户端
 *
 * @author lufeifan
 * @date 2021/10/21 22:23
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// 同一个包不需要配置扫描包
@EnableFeignClients(basePackages = "com.lf.system.api")
public @interface EnableLfFeignClients {

}
