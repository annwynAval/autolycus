package com.annwyn.autolycus.core.component;

import com.annwyn.autolycus.common.utils.ConstantUtils;
import com.annwyn.autolycus.mybatis.generator.model.Manager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ClientTokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String clientToken = httpServletRequest.getHeader(ConstantUtils.BACKEND_HEADER_AUTHORIZED_TOKEN);
        if(!StringUtils.isEmpty(clientToken)) {
            String managerId = null, roleId = null;
            if(managerId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            }

        }

    }
}
