package com.lf.common.resource.auth.config;

import com.lf.common.resource.auth.AuthProperties;
import com.lf.common.resource.auth.config.AccessTokenConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.List;
import java.util.Optional;

/**
 * @author lufeifan
 */
@AutoConfigureAfter(AccessTokenConfig.class)
@EnableConfigurationProperties({AuthProperties.class})
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    TokenStore tokenStore;

    @Autowired
    AuthProperties authProperties;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("res1").tokenStore(tokenStore);
    }

    /**
     * 如果没有配置权限列表，默认所有路径都不需要认证
     **/
    @Override
    public void configure(HttpSecurity http) throws Exception {
        List<String> list = authProperties.getList();
        if (Optional.ofNullable(list).isPresent()) {
            String[] s = list.toArray(new String[list.size()]);
            http.authorizeRequests().antMatchers(s).authenticated().anyRequest().permitAll();
        } else {
            http.authorizeRequests().anyRequest().permitAll();
        }
        System.out.println("需要权限认证的路径:" + list);
    }


    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy("admin > user > test");
        return hierarchy;
    }
}
