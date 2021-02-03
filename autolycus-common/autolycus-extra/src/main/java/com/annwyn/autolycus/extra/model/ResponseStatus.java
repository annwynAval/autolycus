package com.annwyn.autolycus.extra.model;

public enum ResponseStatus {

    /**
     * 成功
     */
    STATUS_SUCCESS(0),
    /**
     * 失败
     */
    STATUS_ERROR(-1),
    /**
     * 未知异常
     */
    STATUS_UNKNOWN_ERROR(-99),
    /**
     * 参数不正确
     */
    STATUS_PARAMS_NOT_VALID(-101),
    /**
     * 不支持当前请求类型
     */
    STATUS_NOT_SUPPORT(-102)
    ;

    private final int code;

    ResponseStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

}
