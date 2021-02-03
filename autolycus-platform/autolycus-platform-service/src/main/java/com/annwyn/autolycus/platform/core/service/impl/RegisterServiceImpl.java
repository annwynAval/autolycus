package com.annwyn.autolycus.platform.core.service.impl;

import com.annwyn.autolycus.extra.exception.ServiceException;
import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.extra.utils.generator.IdGeneratorUtils;
import com.annwyn.autolycus.extra.utils.generator.ShortIdGeneratorUtils;
import com.annwyn.autolycus.platform.core.service.RegisterService;
import com.annwyn.autolycus.platform.model.RegisterRequest;
import com.annwyn.autolycus.platform.utils.ConstantUtils;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.TimeUnit;


@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private IdGeneratorUtils generatorUtils;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    @Override
    public QueryResponse<String> captcha(String mailAddress) {
        try {
            String captcha = this.generatorUtils.generator();
            this.redisTemplate.opsForValue().set(ConstantUtils.CAPTCHA_PREFIX + mailAddress, captcha, 10, TimeUnit.MINUTES);

            MimeMessageHelper messageHelper = new MimeMessageHelper(this.javaMailSender.createMimeMessage(), true);
            messageHelper.setTo(mailAddress);
            messageHelper.setSubject("小米商城激活码");
            messageHelper.setText(captcha, true);
            return QueryResponse.success("验证码已经发送至邮箱, 请注意查收!");
        } catch(MessagingException e) {
            this.redisTemplate.delete(ConstantUtils.CAPTCHA_PREFIX + mailAddress);
            throw new ServiceException("发送邮件出现错误, 请联系管理员.");
        }
    }

    @Override
    public QueryResponse<String> register(RegisterRequest registerRequest) {
        return null;
    }
}
