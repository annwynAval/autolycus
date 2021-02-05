package com.annwyn.autolycus.platform.core.controller;


import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.core.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("login.html")
    public QueryResponse<?> login(String memberMail, String password) {
        return null;
    }

    @PostMapping("forgetPassword.html")
    public QueryResponse<?> forgetPassword(String memberMail) {
        return this.loginService.forgetPassword(memberMail);
    }

}
