package com.lf.auth.server;

import com.alibaba.fastjson.JSON;
import com.lf.common.core.utils.R;
import com.lf.common.vo.UserDetail;
import com.lf.system.api.AdminFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminFeign adminFeign;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        R r = adminFeign.user(s);
        Object data = r.get("data");
        UserDetail details = JSON.parseObject(JSON.toJSONString(data), UserDetail.class);
        System.out.println(details);
        return details;
    }
}
