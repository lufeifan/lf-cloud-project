package com.lf.auth.config;

import com.lf.auth.exception.BootOauth2WebResponseExceptionTranslator;
import com.lf.common.vo.UserDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lufeifan
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServer implements AuthorizationServerConfigurer {

    @Resource
    private DataSource dataSource;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private BootOauth2WebResponseExceptionTranslator bootOAuth2WebResponseExceptionTranslator;

    @Resource
    private TokenStore tokenStore;

    @Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    ClientDetailsService clientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
        securityConfigurer.checkTokenAccess("permitAll()").allowFormAuthenticationForClients();
    }

    /**
     *  从数据库获取配置信息
     **/
    @Override
    public void configure(ClientDetailsServiceConfigurer detailsServiceConfigurer) throws Exception {
        detailsServiceConfigurer.withClientDetails(clientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) throws Exception {
        endpointsConfigurer.authenticationManager(authenticationManager)
                .tokenServices(tokenServices())
                .exceptionTranslator(bootOAuth2WebResponseExceptionTranslator)
                .pathMapping("/oauth/check_token","/auth/oauth/check_token");
//        将 /oauth/token 改为 login
//                .pathMapping("/oauth/token","/login");
    }

    @Bean
    AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService());
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore);
        /**
         *  需要提醒一句，其实我们配置的 JwtAccessTokenConverter 也是 TokenEnhancer 的一个实例
         *
         * 配置完成之后，我们还需要在 AuthorizationServer 中修改 AuthorizationServerTokenServices 实例
         **/
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(tokenEnhancer());
        tokenEnhancers.add(jwtAccessTokenConverter);

        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);
        services.setTokenEnhancer(tokenEnhancerChain);

        return services;
    }


    /**
     * JWT内容增强
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            Map<String, Object> additionalInfo = new HashMap<>();
            UserDetail userDetail = (UserDetail) authentication.getPrincipal();
            additionalInfo.put("username",userDetail.getUsername());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

}
