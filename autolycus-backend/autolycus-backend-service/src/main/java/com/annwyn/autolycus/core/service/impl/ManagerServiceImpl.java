package com.annwyn.autolycus.core.service.impl;

import com.annwyn.autolycus.mybatis.repository.ManagerRepository;
import com.annwyn.autolycus.core.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerRepository managerRepository;



}

