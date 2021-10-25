package com.lf.test.log;

import com.lf.common.core.utils.R;
import com.lf.common.core.utils.ServletUtils;
import com.lf.common.entity.SysLog;
import com.lf.common.log.annotation.Log;
import com.lf.system.api.LogFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志测试
 *
 * @author lufeifan
 * @date 2021/10/22 15:17
 **/
@RestController
public class HelloController {

    @Autowired
    LogFeign logFeign;

    @GetMapping("/test")
    @Log("测试")
    public R test(){
        return R.ok();
    }

    @Log
    @GetMapping("/test2")
    public void test2(){
        SysLog log = new SysLog();
        log.setUrl(ServletUtils.getUrl());
        logFeign.saveLog(log);
    }
}
