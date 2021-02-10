package com.annwyn.autolycus.backend.core.repository;


import com.annwyn.autolycus.backend.model.dto.ManagerDetailDTO;
import com.annwyn.autolycus.backend.mybatis.mapper.ManagerMapper;
import com.annwyn.autolycus.backend.mybatis.model.Manager;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ManagerRepository {

    @Resource
    private ManagerMapper managerMapper;

    public Manager searchByMail(String mailAddress) {
        return this.managerMapper.searchByMail(mailAddress);
    }

}
