package com.annwyn.autolycus.platform.utils;

public class ConstantUtils {

    /**
     * 用户注册时, 验证码存储redis时的前缀
     */
    public static final String CAPTCHA_PREFIX = "captcha_";

    /**
     * 用户状态值: 0: 可用
     */
    public static final int MEMBER_STATUS_ENABLED = 0;

    /**
     * 用户状态值: 1: 废弃
     */
    public static final int MEMBER_STATUS_DISABLED = 1;


}
