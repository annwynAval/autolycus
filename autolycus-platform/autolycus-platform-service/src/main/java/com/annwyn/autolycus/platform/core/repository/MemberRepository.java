package com.annwyn.autolycus.platform.core.repository;

import com.annwyn.autolycus.extra.exception.ServiceException;
import com.annwyn.autolycus.extra.utils.generator.IdGeneratorUtils;
import com.annwyn.autolycus.platform.mybatis.mapper.MemberMapper;
import com.annwyn.autolycus.platform.mybatis.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;

@Repository
public class MemberRepository {

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private IdGeneratorUtils generatorUtils;

    /**
     * 根据邮箱地址查询用户总数, 用于判断邮箱是否重复
     * @return .
     */
    public int countByMailAddress(String mailAddress) {
        return this.memberMapper.countByMailAddress(mailAddress);
    }

    /**
     * 保存用户信息
     * @param member .
     */
    public void insertMember(Member member) {
        if(StringUtils.isEmpty(member.getMemberId())) {
            member.setMemberId(this.generatorUtils.generator());
        }
        this.memberMapper.insert(member);
    }

    /**
     * 根据邮箱更新对应的用户信息
     * @param member .
     */
    public void updateByMailIfRequired(Member member) {
        if(StringUtils.isEmpty(member.getMemberMail())) {
            throw new ServiceException("未找到用户邮箱信息, 无法更新数据.");
        }
        this.memberMapper.updateByMailIfRequired(member);
    }

    /**
     * 更新密码
     * @param memberMail .
     * @param password .
     */
    public void updatePassword(String memberMail, String password) {
        this.memberMapper.updatePassword(memberMail, password);
    }

    /**
     * 根据邮箱地址检索
     * @param mailAddress .
     * @return .
     */
    public Member searchByMail(String mailAddress) {
        return this.memberMapper.searchByMail(mailAddress);
    }

}
