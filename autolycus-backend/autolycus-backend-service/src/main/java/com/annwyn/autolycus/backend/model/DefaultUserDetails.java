package com.annwyn.autolycus.backend.model;

import com.annwyn.autolycus.backend.mybatis.model.Manager;
import com.annwyn.autolycus.backend.utils.ConstantUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class DefaultUserDetails implements UserDetails {

    private final Manager manager;

    public DefaultUserDetails(Manager manager) {
        this.manager = manager;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.manager.getPassword();
    }

    @Override
    public String getUsername() {
        return this.manager.getManagerName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(this.manager.getStatus(), ConstantUtils.MEMBER_STATUS_ENABLED);
    }
}
