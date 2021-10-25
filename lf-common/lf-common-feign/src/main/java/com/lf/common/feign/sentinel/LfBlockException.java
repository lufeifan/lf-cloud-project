package com.lf.common.feign.sentinel;

import com.alibaba.csp.sentinel.slots.block.AbstractRule;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * BlockException
 *
 * @author lufeifan
 * @date 2021/10/22 09:48
 * @see BlockException
 **/
public class LfBlockException extends BlockException{

    public LfBlockException(String ruleLimitApp) {
        super(ruleLimitApp);
        System.out.println("限流配置");
    }

    public LfBlockException(String ruleLimitApp, AbstractRule rule) {
        super(ruleLimitApp, rule);
        System.out.println("限流配置");
    }

    public LfBlockException(String message, Throwable cause) {
        super(message, cause);
        System.out.println("限流配置");
    }

    public LfBlockException(String ruleLimitApp, String message) {
        super(ruleLimitApp, message);
        System.out.println("限流配置");
    }

    public LfBlockException(String ruleLimitApp, String message, AbstractRule rule) {
        super(ruleLimitApp, message, rule);
        System.out.println("限流配置");
    }
}
