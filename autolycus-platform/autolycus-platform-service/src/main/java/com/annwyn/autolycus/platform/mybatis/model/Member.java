package com.annwyn.autolycus.platform.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
public class Member implements Serializable {

    /**
     * 主键
     */
    private String memberId;
    /**
     * 电子邮箱
     */
    private String memberMail;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String memberName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 状态值: 0: 可用, 1: 废弃
     */
    private Integer status;
    /**
     * 头像
     */
    private String memberIcon;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
