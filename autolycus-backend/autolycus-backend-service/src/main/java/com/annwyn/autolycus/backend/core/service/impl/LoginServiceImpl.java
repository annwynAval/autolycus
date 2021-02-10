package com.annwyn.autolycus.backend.core.service.impl;

import com.annwyn.autolycus.backend.core.service.LoginService;
import com.annwyn.autolycus.backend.model.DefaultUserDetails;
import com.annwyn.autolycus.extra.model.QueryResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public DefaultUserDetails login(String managerMail, String password) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(managerMail, password);
        return (DefaultUserDetails) this.authenticationManager.authenticate(authentication).getPrincipal();
    }

    @Override
    public QueryResponse<String> changePassword(String managerMail, String password, String validPassword) {
        return null;
    }
}
