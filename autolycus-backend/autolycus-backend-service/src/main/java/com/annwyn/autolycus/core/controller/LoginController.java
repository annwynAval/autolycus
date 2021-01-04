package com.annwyn.autolycus.core.controller;


import com.annwyn.autolycus.common.model.QueryResponse;
import com.annwyn.autolycus.common.model.ResponseStatus;
import com.annwyn.autolycus.common.utils.BeanUtils;
import com.annwyn.autolycus.common.utils.ConstantUtils;
import com.annwyn.autolycus.core.service.LoginService;
import com.annwyn.autolycus.core.service.impl.DefaultUserDetailsService;
import com.annwyn.autolycus.model.response.LoginResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("login.html")
    public QueryResponse<?> login(String username, String password) {
        DefaultUserDetailsService.DefaultUserDetails userDetails = this.loginService.login(username, password);

        LoginResponse loginResponse = BeanUtils.copyBean(userDetails.getManager(), new LoginResponse());
        loginResponse.setRoleName(userDetails.getRole().getRoleName());
        loginResponse.setClientToken(this.loginService.generatorClientToken(userDetails));

        return QueryResponse.build(ResponseStatus.STATUS_SUCCESS, "success", loginResponse);
    }

    @PostMapping("permission/managerDetail")
    public QueryResponse<?> getManagerDetail(@CookieValue(ConstantUtils.BACKEND_HEADER_AUTHORIZED_TOKEN) String token) {
        
        return null;
    }

}
