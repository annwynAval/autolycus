package com.annwyn.autolycus.core.service.impl;

import com.annwyn.autolycus.mybatis.repository.MenuRepository;
import com.annwyn.autolycus.core.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuRepository menuRepository;

}

