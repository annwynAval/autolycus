package com.annwyn.autolycus.platform.core.service.impl;

import com.annwyn.autolycus.extra.exception.ServiceException;
import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.extra.utils.BeanUtils;
import com.annwyn.autolycus.extra.utils.generator.IdGeneratorUtils;
import com.annwyn.autolycus.platform.core.component.PlatformMemberProperties;
import com.annwyn.autolycus.platform.core.repository.MemberRepository;
import com.annwyn.autolycus.platform.core.service.RegisterService;
import com.annwyn.autolycus.platform.model.request.RegisterRequest;
import com.annwyn.autolycus.platform.mybatis.model.Member;
import com.annwyn.autolycus.platform.utils.ConstantUtils;
import com.annwyn.autolycus.platform.utils.ParamUtils;
import com.annwyn.autolycus.platform.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


@Service
public class RegisterServiceImpl implements RegisterService {

    private final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private MemberRepository memberRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private PlatformMemberProperties memberProperties;

    @Override
    public QueryResponse<String> captcha(String mailAddress) {
        try {
            if(this.memberRepository.countByMailAddress(mailAddress) != 0) {
                throw new ServiceException("该邮箱已经被注册, 请使用该邮箱进行登录");
            }
            // 生成验证码
            final String captcha = this.redisUtils.setCaptcha(mailAddress, ParamUtils.makeCaptcha());
            // 发送邮件
            MimeMessageHelper messageHelper = new MimeMessageHelper(this.javaMailSender.createMimeMessage(), true);
            messageHelper.setTo(mailAddress);
            messageHelper.setSubject("小米商城激活码");
            messageHelper.setText(captcha, true);
            return QueryResponse.success("验证码已经发送至邮箱, 请注意查收!");
        } catch(MessagingException e) {
            this.logger.error("邮件发送失败: " + mailAddress, e);
            // 邮件发送失败, 直接删除redis中的验证码
            this.redisUtils.deleteCaptcha(mailAddress);
            throw new ServiceException("发送邮件至" + mailAddress + "失败, 请联系管理员.");
        }
    }

    @Override
    public QueryResponse<String> register(RegisterRequest registerRequest) {
        // 从redis中获取验证码并比对.
        String redisCaptcha = this.redisUtils.getCaptcha(registerRequest.getMemberMail());
        if(!Objects.equals(redisCaptcha, registerRequest.getCaptcha())) {
            throw new ServiceException("验证码不正确, 请在当前注册的邮箱内查看验证码!");
        }

        Member member = BeanUtils.copyBean(registerRequest, new Member());
        member.setMemberIcon(this.memberProperties.getDefaultMemberIcon());
        member.setPassword(this.passwordEncoder.encode(member.getPassword()));
        member.setStatus(ConstantUtils.MEMBER_STATUS_ENABLED);

        this.memberRepository.insertMember(member);
        this.redisUtils.deleteCaptcha(registerRequest.getMemberMail());
        return QueryResponse.success("用户注册成功.");
    }
}
