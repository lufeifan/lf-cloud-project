package com.lf.common.datasource.annotation;


import com.lf.common.datasource.LfDynamicDataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启动态数据源
 *
 * @author lufeifan
 * @date 2021/10/21 21:43
 **/
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(LfDynamicDataSourceAutoConfiguration.class)
public @interface EnableLfDynamicDataSource {
}
