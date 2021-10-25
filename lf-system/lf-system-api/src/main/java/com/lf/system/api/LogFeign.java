package com.lf.system.api;

import com.lf.common.entity.SysLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 日志 Feign 接口
 *
 * @author lufeifan
 * @date 2021/10/22 15:26
 **/

@FeignClient(name = "lf-system-admin",contextId = "logFeign")
public interface LogFeign {

    /**
     * 调用日志存储
     * @param sysLog 日志实体类
     */
    @PostMapping("/system/saveLog")
    void saveLog(@RequestBody SysLog sysLog);

}
