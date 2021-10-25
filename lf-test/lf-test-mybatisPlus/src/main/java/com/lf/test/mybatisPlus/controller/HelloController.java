package com.lf.test.mybatisPlus.controller;


import com.lf.common.entity.SysLog;
import com.lf.test.mybatisPlus.service.SysLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author lufeifan
 * @date 2021/10/22 11:53
 **/
@Api("lf-test-mybatisPlus")
@RestController
public class HelloController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping("/test")
    public void test(){
        SysLog sysLog = new SysLog();
        sysLog.setUrl("http");
        sysLogService.save(sysLog);
    }

    @PostMapping("/test2")
    public void test2(@RequestBody SysLog sysLog){
        sysLogService.save(sysLog);
    }
}
