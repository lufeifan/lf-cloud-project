package com.lf.common.resource.auth;

import com.lf.common.resource.auth.config.AccessTokenConfig;
import com.lf.common.resource.auth.config.ResourceServerConfig;
import com.lf.common.resource.auth.intercept.PermissionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 资源服务自动装配
 *
 * @author lufeifan
 * @date 2021/10/25 10:47
 **/
@Import(value = {AccessTokenConfig.class, ResourceServerConfig.class})
public class LfResourceAuthAutoConfiguration {

    @Bean("pms")
    public PermissionService permissionService() {
        return new PermissionService();
    }
}
