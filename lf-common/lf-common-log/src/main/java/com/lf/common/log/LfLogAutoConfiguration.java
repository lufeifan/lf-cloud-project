package com.lf.common.log;

import com.lf.common.log.aspect.SysLogAspect;
import com.lf.common.log.event.SaveLogListener;
import org.springframework.context.annotation.Import;

/**
 * 日志自动配置类
 *
 * @author lufeifan
 * @date 2021/10/22 14:53
 **/
@Import({SysLogAspect.class, SaveLogListener.class})
public class LfLogAutoConfiguration {
}
