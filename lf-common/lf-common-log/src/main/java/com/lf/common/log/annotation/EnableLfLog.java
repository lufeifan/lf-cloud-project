package com.lf.common.log.annotation;

import com.lf.common.log.LfLogAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启日志注解
 *
 * @author lufeifan
 * @date 2021/10/22 14:52
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(LfLogAutoConfiguration.class)
public @interface EnableLfLog {
}
