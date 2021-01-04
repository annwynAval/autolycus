package com.annwyn.autolycus.core.service.impl;

import com.annwyn.autolycus.mybatis.repository.RoleRepository;
import com.annwyn.autolycus.core.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository;


}

