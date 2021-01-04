package com.annwyn.autolycus.mybatis.generator.mapper;

import static com.annwyn.autolycus.mybatis.generator.mapper.MenuDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.annwyn.autolycus.mybatis.generator.model.Menu;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface MenuMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    BasicColumn[] selectList = BasicColumn.columnList(menuId, menuName, menuType, parentMenuId, menuRemark, menuOrder, menuIcon, menuHref, menuPermission);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MenuResult")
    Optional<Menu> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MenuResult", value = {
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.BIT),
        @Result(column="parent_menu_id", property="parentMenuId", jdbcType=JdbcType.SMALLINT),
        @Result(column="menu_remark", property="menuRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_order", property="menuOrder", jdbcType=JdbcType.SMALLINT),
        @Result(column="menu_icon", property="menuIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_href", property="menuHref", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_permission", property="menuPermission", jdbcType=JdbcType.VARCHAR)
    })
    List<Menu> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, menu, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    default Optional<Menu> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, menu, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    default List<Menu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, menu, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    default List<Menu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, menu, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    default Optional<Menu> selectByPrimaryKey(Short menuId_) {
        return selectOne(c ->
            c.where(menuId, isEqualTo(menuId_))
        );
    }
}