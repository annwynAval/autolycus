package com.annwyn.autolycus.platform.core.service.impl;

import com.annwyn.autolycus.extra.exception.ServiceException;
import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.core.repository.MemberRepository;
import com.annwyn.autolycus.platform.core.service.MemberService;
import com.annwyn.autolycus.platform.model.request.MemberContactRequest;
import com.annwyn.autolycus.platform.mybatis.model.Member;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Objects;


@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberRepository memberRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public QueryResponse<String> changePassword(String memberMail, String password, String validPassword) {
        Member member = this.memberRepository.searchByMail(memberMail);
        if(member == null) {
            throw new ServiceException("没有找到登录用户的信息");
        }

        if(!Objects.equals(this.passwordEncoder.encode(validPassword), member.getPassword())) {
            throw new ServiceException("原密码不正确, 请重新输入!");
        }
        this.memberRepository.updatePassword(memberMail, this.passwordEncoder.encode(password));
        return QueryResponse.success("修改密码成功!");
    }

    @Override
    public QueryResponse<String> updateContact(String memberMail, String memberName, String phone) {
        Member member = new Member();
        member.setMemberMail(memberMail);
        member.setMemberName(memberName);
        member.setPhone(phone);

        this.memberRepository.updateByMailIfRequired(member);
        return QueryResponse.success("用户信息更新成功!");
    }

    @Override
    public QueryResponse<String> changeMemberIcon(MultipartFile multipartFile, String memberMail) {

        return null;
    }
}
