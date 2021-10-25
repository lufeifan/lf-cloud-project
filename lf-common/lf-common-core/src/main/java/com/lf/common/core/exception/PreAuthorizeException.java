package com.lf.common.core.exception;

public class PreAuthorizeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PreAuthorizeException() {
        this("权限异常");
    }

    public PreAuthorizeException(String message) {
        super(message);
    }
}