package com.lf.system.admin.controller;

import com.lf.common.core.utils.R;
import com.lf.common.entity.SysLog;
import com.lf.system.admin.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志Controller
 *
 * @author lufeifan
 * @date 2021/10/25 14:56
 **/
@RestController
@RequestMapping("/system")
public class LogController {

    @Autowired
    private SysLogService service;

    @PostMapping("/saveLog")
    public R saveLog(@RequestBody SysLog log){
        service.save(log);
        return R.ok("日志保存成功");
    }
}
