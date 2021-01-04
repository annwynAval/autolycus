package com.annwyn.autolycus.mybatis.generator.model;

import java.io.Serializable;
import javax.annotation.Generated;

public class Menu implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_id")
    private Short menuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_name")
    private String menuName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_type")
    private Boolean menuType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.parent_menu_id")
    private Short parentMenuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_remark")
    private String menuRemark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_order")
    private Short menuOrder;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_icon")
    private String menuIcon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_href")
    private String menuHref;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_permission")
    private String menuPermission;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_menu")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_id")
    public Short getMenuId() {
        return menuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_id")
    public void setMenuId(Short menuId) {
        this.menuId = menuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_name")
    public String getMenuName() {
        return menuName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_name")
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_type")
    public Boolean getMenuType() {
        return menuType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_type")
    public void setMenuType(Boolean menuType) {
        this.menuType = menuType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.parent_menu_id")
    public Short getParentMenuId() {
        return parentMenuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.parent_menu_id")
    public void setParentMenuId(Short parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_remark")
    public String getMenuRemark() {
        return menuRemark;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_remark")
    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_order")
    public Short getMenuOrder() {
        return menuOrder;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_order")
    public void setMenuOrder(Short menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_icon")
    public String getMenuIcon() {
        return menuIcon;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_icon")
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_href")
    public String getMenuHref() {
        return menuHref;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_href")
    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_permission")
    public String getMenuPermission() {
        return menuPermission;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_menu.menu_permission")
    public void setMenuPermission(String menuPermission) {
        this.menuPermission = menuPermission;
    }
}