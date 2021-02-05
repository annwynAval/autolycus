package com.annwyn.autolycus.platform.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@ApiModel("注册接口参数对象")
public class RegisterRequest implements Serializable {

    @ApiModelProperty("邮箱")
    private String memberMail;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名称")
    private String memberName;

    @ApiModelProperty("用户电话")
    private String phone;

    @ApiModelProperty("邮箱验证码")
    private String captcha;

}
