package com.annwyn.autolycus.core.service.impl;

import com.annwyn.autolycus.mybatis.repository.ManagerRepository;
import com.annwyn.autolycus.core.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    private final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public DefaultUserDetailsService.DefaultUserDetails login(String username, String password) throws AccountStatusException, BadCredentialsException {
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        return (DefaultUserDetailsService.DefaultUserDetails) authentication.getPrincipal();
    }

    @Override
    public String generatorClientToken(DefaultUserDetailsService.DefaultUserDetails userDetails) {
        return "";
    }
}
