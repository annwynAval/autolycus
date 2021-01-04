package com.annwyn.autolycus.mybatis.dynamic.mapper;

import com.annwyn.autolycus.mybatis.generator.model.Menu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuOperations {

    List<Menu> selectByRoleId(String roleId);

}
