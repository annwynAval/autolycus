package com.annwyn.autolycus.mybatis.repository;

import com.annwyn.autolycus.mybatis.dynamic.mapper.ManagerOperations;
import com.annwyn.autolycus.mybatis.dynamic.model.ManagerModel;
import com.annwyn.autolycus.mybatis.generator.mapper.ManagerMapper;
import com.annwyn.autolycus.mybatis.generator.model.Manager;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ManagerRepository {

    @Resource
    private ManagerMapper managerMapper;

    @Resource
    private ManagerOperations managerOperations;

    public Manager searchByMail(String managerMail) {
        return null;
    }


}
