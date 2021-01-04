package com.annwyn.autolycus.mybatis.repository;

import com.annwyn.autolycus.mybatis.dynamic.mapper.MenuOperations;
import com.annwyn.autolycus.mybatis.generator.mapper.MenuDynamicSqlSupport;
import com.annwyn.autolycus.mybatis.generator.mapper.MenuMapper;
import com.annwyn.autolycus.mybatis.generator.model.Menu;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.util.Buildable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MenuRepository {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private MenuOperations menuOperations;

    public List<Menu> searchByRoleId(String roleId) {
        return this.menuOperations.selectByRoleId(roleId);
    }

}
