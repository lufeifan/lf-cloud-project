package com.lf.common.log.event;

import com.lf.common.entity.SysLog;
import com.lf.system.api.LogFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

/**
 * 日志监听器
 *
 * @author lufeifan
 * @date 2021/10/22 16:34
 **/
public class SaveLogListener {

    @Autowired
    LogFeign logFeign;

    // TODO	@Async 异步事件

    @EventListener(SaveLogEvent.class)
    public void saveSysLog(SaveLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        System.out.println("日志监听器");
        logFeign.saveLog(sysLog);
    }
}
