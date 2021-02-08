package com.annwyn.autolycus.backend.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "a", tags = "b")
@RestController
@RequestMapping("login")
public class LoginController {

    @ApiOperation("login")
    @PostMapping("login.html")
    @ApiImplicitParams({
        @ApiImplicitParam(value = "管理员名称", name = "managerName", paramType = "query", dataType = "string"),
        @ApiImplicitParam(value = "管理员密码", name = "password", paramType = "query", dataType = "string")
    })
    public String login(String managerName, String password) {
        return "123";
    }


}
