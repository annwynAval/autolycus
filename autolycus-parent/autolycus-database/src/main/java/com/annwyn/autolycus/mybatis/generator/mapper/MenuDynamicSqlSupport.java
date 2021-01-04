package com.annwyn.autolycus.mybatis.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MenuDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    public static final Menu menu = new Menu();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_id")
    public static final SqlColumn<Short> menuId = menu.menuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_name")
    public static final SqlColumn<String> menuName = menu.menuName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_type")
    public static final SqlColumn<Boolean> menuType = menu.menuType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.parent_menu_id")
    public static final SqlColumn<Short> parentMenuId = menu.parentMenuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_remark")
    public static final SqlColumn<String> menuRemark = menu.menuRemark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_order")
    public static final SqlColumn<Short> menuOrder = menu.menuOrder;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_icon")
    public static final SqlColumn<String> menuIcon = menu.menuIcon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_href")
    public static final SqlColumn<String> menuHref = menu.menuHref;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_permission")
    public static final SqlColumn<String> menuPermission = menu.menuPermission;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    public static final class Menu extends SqlTable {
        public final SqlColumn<Short> menuId = column("menu_id", JDBCType.SMALLINT);

        public final SqlColumn<String> menuName = column("menu_name", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> menuType = column("menu_type", JDBCType.BIT);

        public final SqlColumn<Short> parentMenuId = column("parent_menu_id", JDBCType.SMALLINT);

        public final SqlColumn<String> menuRemark = column("menu_remark", JDBCType.VARCHAR);

        public final SqlColumn<Short> menuOrder = column("menu_order", JDBCType.SMALLINT);

        public final SqlColumn<String> menuIcon = column("menu_icon", JDBCType.VARCHAR);

        public final SqlColumn<String> menuHref = column("menu_href", JDBCType.VARCHAR);

        public final SqlColumn<String> menuPermission = column("menu_permission", JDBCType.VARCHAR);

        public Menu() {
            super("mms_menu");
        }
    }
}