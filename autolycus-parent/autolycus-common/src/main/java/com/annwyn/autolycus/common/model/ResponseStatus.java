package com.annwyn.autolycus.common.model;

public enum ResponseStatus {

    STATUS_ERROR(-1),
    STATUS_SUCCESS(0),
    STATUS_UNKNOWN_ERROR(-99),
    STATUS_PARAMS_NOT_VALID(-101),
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
