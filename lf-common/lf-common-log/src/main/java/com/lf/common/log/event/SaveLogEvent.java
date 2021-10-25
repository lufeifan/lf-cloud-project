package com.lf.common.log.event;

import org.springframework.context.ApplicationEvent;

/**
 * 保存日志时间
 *
 * @author lufeifan
 * @date 2021/10/22 16:33
 **/
public class SaveLogEvent extends ApplicationEvent {

    public SaveLogEvent(Object source) {
        super(source);
    }
}
