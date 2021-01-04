package com.annwyn.autolycus.core.service;

import com.annwyn.autolycus.core.service.impl.DefaultUserDetailsService;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;

public interface LoginService {

    /**
     * 用户登录处理逻辑
     * @param username 用户名称
     * @param password 用户密码
     * @return {@link com.annwyn.autolycus.core.service.impl.DefaultUserDetailsService.DefaultUserDetails}
     * @throws AccountStatusException 账户状态不正确: 被锁定, 无效等
     * @throws BadCredentialsException 用户密码不正确
     */
    DefaultUserDetailsService.DefaultUserDetails login(String username, String password) throws AccountStatusException, BadCredentialsException;

    String generatorClientToken(DefaultUserDetailsService.DefaultUserDetails userDetails);
}
