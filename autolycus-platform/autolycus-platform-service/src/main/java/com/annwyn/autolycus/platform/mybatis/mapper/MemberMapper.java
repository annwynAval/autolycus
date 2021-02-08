package com.annwyn.autolycus.platform.mybatis.mapper;

import com.annwyn.autolycus.platform.mybatis.model.Member;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

    /**
     * 保存数据
     * @param member .
     */
    void insert(@Param("member") Member member);

    /**
     * 更新数据 required
     * @param member .
     */
    void updateByMailIfRequired(@Param("member") Member member);

    /**
     * 更新密码
     * @param memberMail .
     * @param password .
     */
    void updatePassword(@Param("memberMail") String memberMail, @Param("password") String password);

    /**
     * 根据邮箱地址查询用户总数, 用于判断邮箱是否重复
     * @param mailAddress .
     * @return .
     */
    int countByMailAddress(@Param("mailAddress") String mailAddress);

    /**
     * 根据邮箱地址检索
     * @param mailAddress .
     * @return .
     */
    Member searchByMail(String mailAddress);

}
