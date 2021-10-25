package com.lf.common.swagger.config;

import com.lf.common.swagger.provider.SwaggerResourceProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 *  网关swagger 配置类，仅在webflux 环境生效哦
 *
 * @author lufeifan
 */
@EnableAutoConfiguration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
@AutoConfigureAfter(SwaggerResourceController.class)
@Import(SwaggerResourceController.class)
@Primary
public class GatewaySwaggerAutoConfiguration implements CommandLineRunner {

    @Bean
    public RouterFunction<ServerResponse> staticResourceRouter() {
        return RouterFunctions.resources("/webjars/**", new ClassPathResource("webjars/"));
    }

    /**
     * @Description: 聚合各个服务的swagger接口
     * @author lufeifan
     * @date 2021/10/22 12:22
     */
    @Bean
    public SwaggerResourceProvider resourceProvider(){
        return new SwaggerResourceProvider();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("当前环境是 webflux GatewaySwaggerAutoConfiguration配置生效");
    }
}
