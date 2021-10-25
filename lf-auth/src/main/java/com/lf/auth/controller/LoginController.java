package com.lf.auth.controller;

import com.lf.auth.vo.LoginUserVO;
import com.lf.common.core.utils.R;
import com.lf.system.api.AdminFeign;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author lufeifan
 */
@Api
@RequestMapping("/auth")
@RestController
public class LoginController {
    @Resource
    private ClientDetailsService clientDetailsService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Qualifier("tokenServices")
    @Resource
    private AuthorizationServerTokenServices  authorizationServerTokenServices;

    /**
     *  登录
     **/
    @PostMapping("/login")
    public R login(@RequestBody LoginUserVO userVO) {
        String username = userVO.getUsername();
        String password = userVO.getPassword();
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId("lf1");
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            // 通过 Client 信息和 请求参数, 获取一个 TokenRequest 对象
            TokenRequest tokenRequest = new TokenRequest(new HashMap<>(), "lf1", clientDetails.getScope(), "password");
            OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
            OAuth2Authentication oAuth2Request1 = new OAuth2Authentication(oAuth2Request, authenticate);
            OAuth2AccessToken accessToken = authorizationServerTokenServices.createAccessToken(oAuth2Request1);
            return R.setData(accessToken);
        }catch (Exception e){
            if (e instanceof DisabledException){
                return R.error("账号禁用");
            }
            if (e instanceof BadCredentialsException){
                return R.error("用户名或密码错误");
            }
            e.printStackTrace();

            return R.error(e.getMessage());
        }
    }

    /**
     *  用户信息
     **/
    @GetMapping("/info")
    public R userInfo(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return R.setData(principal);
    }
}
