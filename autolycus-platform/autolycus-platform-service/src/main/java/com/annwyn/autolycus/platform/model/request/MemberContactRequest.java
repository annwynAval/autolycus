package com.annwyn.autolycus.platform.model.request;

import com.annwyn.autolycus.platform.mybatis.model.Member;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel("用户信息修改参数")
public class MemberContactRequest implements Serializable {

    /**
     * 电子邮箱
     */
    private String memberMail;
    /**
     * 用户名
     */
    private String memberName;
    /**
     * 手机号码
     */
    private String phone;

}
