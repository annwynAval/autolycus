package com.annwyn.autolycus.platform.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@ApiModel("用户信息")
public class Member implements Serializable {

    @ApiModelProperty("主键")
    private String memberId;

    @ApiModelProperty("电子邮箱")
    private String memberMail;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名")
    private String memberName;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("状态值: 0: 可用, 1: 废弃")
    private Integer status;

    @ApiModelProperty("头像")
    private String memberIcon;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


}
