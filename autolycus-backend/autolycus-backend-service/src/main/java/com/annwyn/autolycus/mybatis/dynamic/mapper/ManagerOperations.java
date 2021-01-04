package com.annwyn.autolycus.mybatis.dynamic.mapper;

import com.annwyn.autolycus.mybatis.dynamic.model.ManagerModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ManagerOperations {

    ManagerModel searchByMail(@Param("managerMail") String managerMail);


}
