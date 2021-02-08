package com.annwyn.autolycus.platform.utils;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public final class ConstantUtils {

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

    /**
     * 图片文件的后缀名
     */
    public static final List<String> IMAGE_SUFFIXES = Arrays.asList("jpg", "png", "jpeg");

    /**
     * 图片上传的最大大小
     */
    public static final long IMAGE_MAX_SIZE = 15 * 1024 * 1024;

    /**
     * 用户信息验证规则
     */
    public static final class MemberValidUtils {

        public static final int MAIL_MAX_LENGTH = 32;

        public static final int NAME_MAX_LENGTH = 32;

        public static final int PASSWORD_MAX_LENGTH = 12;

        public static final int PHONE_MAX_LENGTH = 16;

    }

    /**
     * 城市数据的相关字段验证规则
     */
    public static final class RegionValidUtils {

        public static final int NAME_MAX_LENGTH = 16;
    }

}
