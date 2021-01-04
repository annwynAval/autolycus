package com.annwyn.autolycus.common.utils;

public interface ConstantUtils {

    /**
     * 默认的分页大小
     */
    int DEFAULT_PAGINATION_LIMIT = 25;

    /**
     * 默认的分页开始数
     */
    int DEFAULT_PAGINATION_OFFSET = 0;

    /**
     * 可用: 1
     */
    int STATUS_ENABLED = 1;

    /**
     * 不可用: 0
     */
    int STATUS_DISABLED = 0;

    String BACKEND_HEADER_AUTHORIZED_TOKEN = "authorized-token";

}
