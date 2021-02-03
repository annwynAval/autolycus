package com.annwyn.autolycus.extra.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
@Getter
@Setter
public class ServiceException extends RuntimeException {

    private static final short DEFAULT_SERVICE_STATUS = -1;

    private short status;
    private String message;
    private Object[] arguments;

    public ServiceException(String message) {
        this(DEFAULT_SERVICE_STATUS, message, (Object) null);
    }

    public ServiceException(String message, Object... arguments) {
        this(DEFAULT_SERVICE_STATUS, message, arguments);
    }

    public ServiceException(short status, String message) {
        this(status, message, (Object) null);
    }

    public ServiceException(short status, String message, Object... arguments) {
        this.status = status;
        this.message = message;
        this.arguments = arguments;
    }

}
