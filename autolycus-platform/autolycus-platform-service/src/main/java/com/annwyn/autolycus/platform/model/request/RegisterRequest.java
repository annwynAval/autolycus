package com.annwyn.autolycus.platform.model.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.MAIL_MAX_LENGTH;
import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.NAME_MAX_LENGTH;
import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.PASSWORD_MAX_LENGTH;
import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.PHONE_MAX_LENGTH;

@Getter
@Setter
@ApiModel("用户注册参数")
public class RegisterRequest implements Serializable {

    @ApiModelProperty("邮箱")
    @NotEmpty
    @Length(max = MAIL_MAX_LENGTH)
    private String memberMail;

    @ApiModelProperty("密码")
    @NotEmpty
    @Length(max = PASSWORD_MAX_LENGTH)
    private String password;

    @ApiModelProperty("用户名称")
    @NotEmpty
    @Length(max = NAME_MAX_LENGTH)
    private String memberName;

    @ApiModelProperty("用户电话")
    @NotEmpty
    @Length(max = PHONE_MAX_LENGTH)
    private String phone;

    @ApiModelProperty("邮箱验证码")
    @NotEmpty
    private String captcha;

}
