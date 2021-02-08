package com.annwyn.autolycus.platform.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Component
public final class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * redis中添加验证码信息
     */
    public String setCaptcha(String mailAddress, String captcha) {
        final String cacheKey = ConstantUtils.CAPTCHA_PREFIX + mailAddress;
        this.redisTemplate.opsForValue().set(cacheKey, captcha, 10, TimeUnit.MINUTES);
        return captcha;
    }

    /**
     * redis删除验证码
     */
    public void deleteCaptcha(String mailAddress) {
        this.redisTemplate.delete(ConstantUtils.CAPTCHA_PREFIX + mailAddress);
    }

    /**
     * 从redis中获取验证码
     */
    public String getCaptcha(String mailAddress) {
        return (String) this.redisTemplate.opsForValue().get(ConstantUtils.CAPTCHA_PREFIX + mailAddress);
    }


}
