package com.annwyn.autolycus.platform.utils;

import org.apache.ibatis.annotations.Param;

import java.util.concurrent.ThreadLocalRandom;

public final class ParamUtils {

    private static final int MAX_CAPTCHA_VALUE = 999999;

    /**
     * 生成随机6位数作为验证码
     * @return .
     */
    public static String makeCaptcha() {
        return String.format("%06d", ThreadLocalRandom.current().nextInt(MAX_CAPTCHA_VALUE));
    }

    /**
     * 生成随机的6位数作为重置的密码
     * @return .
     */
    public static String randomPassword() {
        return ParamUtils.makeCaptcha();
    }

}
