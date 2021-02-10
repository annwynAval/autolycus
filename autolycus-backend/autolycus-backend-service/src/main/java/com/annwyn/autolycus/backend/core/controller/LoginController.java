package com.annwyn.autolycus.backend.core.controller;

import com.annwyn.autolycus.backend.core.service.LoginService;
import com.annwyn.autolycus.backend.model.DefaultUserDetails;
import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.extra.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("login")
@Api(tags = "管理员登录api")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("login.html")
    @ApiOperation("管理员登录")
    @ApiImplicitParams({
        @ApiImplicitParam(value = "管理员邮箱", name = "managerMail", paramType = "query", dataType = "string"),
        @ApiImplicitParam(value = "管理员密码", name = "password", paramType = "query", dataType = "string")
    })
    @PreAuthorize("@authorize.hasPermission('', '')")
    public QueryResponse<String> login(String managerMail, String password) {
        DefaultUserDetails defaultUserDetails = this.loginService.login(managerMail, password);


        return null;
    }

    @PostMapping("login.html")
    @ApiOperation("管理员修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "管理员邮箱", name = "managerMail", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "管理员新密码", name = "password", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "管理员原密码", name = "validPassword", paramType = "query", dataType = "string"),
    })
    public QueryResponse<String> changePassword(String managerMail, String password, String validPassword) {
        return this.loginService.changePassword(managerMail, password, validPassword);
    }

}
