package com.lf.common.log.aspect;

import com.lf.common.core.utils.ServletUtils;
import com.lf.common.core.utils.SpringContextHolder;
import com.lf.common.entity.SysLog;
import com.lf.common.log.annotation.Log;
import com.lf.common.log.event.SaveLogEvent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * 日志切面类
 *
 * @author lufeifan
 * @date 2021/10/22 14:55
 **/
@Aspect
public class SysLogAspect {


    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 切入点
     **/
    @Pointcut("@annotation(com.lf.common.log.annotation.Log)")
    public void logPointCut() {
    }


    /**
     * 使用环绕通知实现日志存储
     **/
    @Before(value = "logPointCut()")
    public void around(JoinPoint joinPoint) {
        String method = ServletUtils.getMethod();
        String uri = ServletUtils.getUrl();

        SysLog sysLog = new SysLog();
        sysLog.setMethod(method);
        sysLog.setUrl(uri);
        sysLog.setApplicationName(applicationName);
        setContent(joinPoint, sysLog);
        SpringContextHolder.publishEvent(new SaveLogEvent(sysLog));
//        logService.save(sysLog);
//    TODO    sysLog.setUsername();
    }

    /**
     * 发生异常
     **/
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void error(JoinPoint joinPoint, Exception e) {
//  TODO 发生异常
    }

    public static void setContent(JoinPoint joinPoint, SysLog sysLog) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
//      必须使用spring 提供的工具类才能获取 别名属性的值
        Log log = AnnotationUtils.getAnnotation(method, Log.class);
        sysLog.setTitle(log.title());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//      填充访问者
        if (Optional.ofNullable(authentication).isPresent()){
            String username = authentication.getName();
            sysLog.setUsername(username);
        }else {
            sysLog.setUsername("anonymousUser");
        }
    }
}
