package com.lf.common.core.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 获取 HttpServlet 工具库
 * @author lufeifan
 */
public class ServletUtils {

    public static HttpServletRequest getHttpServletRequest() {
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) ra;
            HttpServletRequest request = requestAttributes.getRequest();
            return request;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getMethod(){
        HttpServletRequest request = getHttpServletRequest();
        return request.getMethod();
    }

    public static String getUrl(){
        HttpServletRequest request = getHttpServletRequest();
        return request.getRequestURL().toString();
    }

}
