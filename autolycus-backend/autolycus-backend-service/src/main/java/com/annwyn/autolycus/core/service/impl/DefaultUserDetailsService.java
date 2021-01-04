package com.annwyn.autolycus.core.service.impl;

import com.annwyn.autolycus.common.utils.ConstantUtils;
import com.annwyn.autolycus.mybatis.generator.model.Manager;
import com.annwyn.autolycus.mybatis.generator.model.Menu;
import com.annwyn.autolycus.mybatis.generator.model.Role;
import com.annwyn.autolycus.mybatis.repository.ManagerRepository;
import com.annwyn.autolycus.mybatis.repository.MenuRepository;
import com.annwyn.autolycus.mybatis.repository.RoleRepository;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DefaultUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(DefaultUserDetailsService.class);

    @Resource
    private ManagerRepository managerRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private MenuRepository menuRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("username is empty");
        }
        Manager manager = this.managerRepository.searchByMail(username);
        if(manager == null) {
            throw new UsernameNotFoundException("username: " + username + " not found");
        }
        return new DefaultUserDetails(this.roleRepository.searchByRoleId(manager.getRoleId()), manager, this.findPermissions(manager.getRoleId()));
    }

    private Collection<? extends GrantedAuthority> findPermissions(String roleId) {
        List<Menu> menus = this.menuRepository.searchByRoleId(roleId); // todo cache zjl
        return menus.stream().filter(item -> Objects.equals(item.getMenuType(), ""))
                .map(item -> new SimpleGrantedAuthority(item.getMenuPermission()))
                .collect(Collectors.toSet());
    }

    public static class DefaultUserDetails implements UserDetails {

        @Getter
        private final Manager manager;
        @Getter
        private final Role role;

        private final Collection<? extends GrantedAuthority> grantedAuthorities;

        protected DefaultUserDetails(Role role, Manager manager, Collection<? extends GrantedAuthority> grantedAuthorities) {
            this.role = role;
            this.manager = manager;
            this.grantedAuthorities = grantedAuthorities;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.grantedAuthorities;
        }

        @Override
        public String getPassword() {
            return this.manager.getPassword();
        }

        @Override
        public String getUsername() {
            return this.manager.getManagerMail();
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
            return Objects.equals(this.manager.getStatus(), ConstantUtils.STATUS_ENABLED);
        }

    }

}
