package com.annwyn.autolycus.core.controller;


import com.annwyn.autolycus.common.model.QueryResponse;
import com.annwyn.autolycus.core.service.ManagerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("manager")
public class ManagerController {

    @Resource
    private ManagerService managerService;

    @PostMapping("search.html")
    @PreAuthorize("@decide.hasPermission('sss')")
    private QueryResponse<?> search() {
        return QueryResponse.success("success");
    }


}
