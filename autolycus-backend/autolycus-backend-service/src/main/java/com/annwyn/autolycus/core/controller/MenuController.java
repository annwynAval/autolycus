package com.annwyn.autolycus.core.controller;

import com.annwyn.autolycus.core.service.MenuService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class MenuController {

    @Resource
    private MenuService menuService;


}
