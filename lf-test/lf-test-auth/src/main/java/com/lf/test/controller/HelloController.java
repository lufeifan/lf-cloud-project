package com.lf.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lufeifan
 * @date 2021/10/25 10:35
 **/
@RestController
@RequestMapping("/auth")
public class HelloController {

    private String te;

    @PreAuthorize(value = "@pms.hasPermission('system:admin:show')")
    @GetMapping("/test1")
    public void test(){
        System.out.println("test1");
    }


    @PreAuthorize(value = "@pms.hasPermission('system')")
    @GetMapping("/test2")
    public Boolean test2(Authentication authentication){
//        if (authentication == null) {
//            return false;
//        }

        System.out.println(authentication);
        System.out.println(authentication.getAuthorities());
        System.out.println("test2");
        return true;
    }
}
