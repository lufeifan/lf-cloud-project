package com.lf.common.resource.auth.intercept;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 权限拦截
 *
 * @author lufeifan
 * @date 2021/10/25 10:51
 **/
@Aspect
public class AuthAspect {

    @Pointcut("@annotation(com.lf)")
    public void logPointCut() {
    }


}
