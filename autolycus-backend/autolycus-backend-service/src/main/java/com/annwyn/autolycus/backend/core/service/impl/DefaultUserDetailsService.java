package com.annwyn.autolycus.backend.core.service.impl;

import com.annwyn.autolycus.backend.core.repository.ManagerRepository;
import com.annwyn.autolycus.backend.model.DefaultUserDetails;
import com.annwyn.autolycus.backend.mybatis.model.Manager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Resource
    private ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("邮箱不能为空!");
        }
        Manager manager = this.managerRepository.searchByMail(username);
        if(manager == null) {
            throw new UsernameNotFoundException("没有找到对应的管理员信息");
        }

        return new DefaultUserDetails(manager, );
    }

    private List<String> ss() {

    }

}
