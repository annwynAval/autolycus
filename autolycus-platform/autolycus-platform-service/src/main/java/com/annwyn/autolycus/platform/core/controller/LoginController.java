package com.annwyn.autolycus.platform.core.controller;


import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.core.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.MAIL_MAX_LENGTH;
import static com.annwyn.autolycus.platform.utils.ConstantUtils.MemberValidUtils.PASSWORD_MAX_LENGTH;


@RestController
@RequestMapping("login")
@Api(tags = "登录相关api")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("login.html")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberMail", value = "登录邮箱", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "用户密码", paramType = "query", required = true)
    })
    public QueryResponse<String> login(@NotEmpty @Length(max = MAIL_MAX_LENGTH) @RequestParam String memberMail,
                                       @NotEmpty @Length(max = PASSWORD_MAX_LENGTH) @RequestParam String password) {
        return this.loginService.login(memberMail, password);
    }

    @PostMapping("forgetPassword.html")
    @ApiOperation("用户密码重置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberMail", value = "登录邮箱", paramType = "query", required = true)
    })
    public QueryResponse<String> forgetPassword(@NotEmpty @Length(max = MAIL_MAX_LENGTH) @RequestParam String memberMail) {
        return this.loginService.forgetPassword(memberMail);
    }

}
