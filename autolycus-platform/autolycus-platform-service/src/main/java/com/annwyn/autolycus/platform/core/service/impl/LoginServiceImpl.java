package com.annwyn.autolycus.platform.core.service.impl;

import com.annwyn.autolycus.extra.exception.ServiceException;
import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.core.repository.MemberRepository;
import com.annwyn.autolycus.platform.core.service.LoginService;
import com.annwyn.autolycus.platform.utils.ConstantUtils;
import com.annwyn.autolycus.platform.utils.ParamUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    private final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private MemberRepository memberRepository;

    @Override
    public QueryResponse<String> login(String memberMail, String password) {

        return null;
    }

    @Override
    public QueryResponse<String> forgetPassword(String mailAddress) {
        try {
            if(this.memberRepository.countByMailAddress(mailAddress) != 0) {
                throw new ServiceException("当前邮箱未注册!");
            }

            String newPassword = ParamUtils.randomPassword();
            this.memberRepository.updatePassword(mailAddress, this.passwordEncoder.encode(newPassword));

            // 发送邮件
            MimeMessageHelper messageHelper = new MimeMessageHelper(this.javaMailSender.createMimeMessage(), true);
            messageHelper.setTo(mailAddress);
            messageHelper.setSubject("小米商城密码重置");
            messageHelper.setText(newPassword, true);
            return QueryResponse.success("新密码已经发送至邮箱, 请登录后立即修改密码!");
        } catch(Exception e) {
            this.logger.error("邮件发送失败: " + mailAddress, e);
            throw new ServiceException("发送邮件至{0}失败, 请联系管理员.", mailAddress);
        }
    }
}
