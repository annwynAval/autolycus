package com.annwyn.autolycus.platform.core.controller;

import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.core.service.RegisterService;
import com.annwyn.autolycus.platform.model.request.RegisterRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    /**
     * 验证邮箱正确性以及是否唯一, 并且给邮箱发送验证码
     * @param mailAddress 邮箱地址
     * @return .
     */
    @PostMapping("captcha.html")
    @ApiOperation("邮箱验证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mailAddress", value = "邮箱地址", paramType = "query", required = true)
    })
    public QueryResponse<?> captcha(@RequestParam("mailAddress") String mailAddress) {
        return this.registerService.captcha(mailAddress);
    }

    /**
     * 用户注册
     * @param registerRequest .
     * @return .
     */
    @PostMapping("register.html")
    @ApiOperation("用户注册")
    public QueryResponse<?> register(RegisterRequest registerRequest) {
        return this.registerService.register(registerRequest);
    }

}
