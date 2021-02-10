package com.annwyn.autolycus.backend.mybatis.mapper;

import com.annwyn.autolycus.backend.model.dto.ManagerDetailDTO;
import com.annwyn.autolycus.backend.mybatis.model.Manager;

public interface ManagerMapper {

    /**
     * 根据邮箱检索用户详细信息, 包括权限信息
     * @param mailAddress .
     * @return .
     */
    Manager searchByMail(String mailAddress);

}
