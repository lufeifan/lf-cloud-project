package com.lf.common.core.exception;

public class LoggerException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public LoggerException() {
        this("日志异常");
    }

    public LoggerException(String message) {
        super(message);
    }
}
