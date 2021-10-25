package com.lf.common.swagger.annotation;


import com.lf.common.swagger.config.GatewaySwaggerAutoConfiguration;
import com.lf.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lufeifan
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SwaggerAutoConfiguration.class, GatewaySwaggerAutoConfiguration.class})
public @interface EnableCustomSwagger {
}
