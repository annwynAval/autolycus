package com.annwyn.autolycus.mybatis.generator.model;

import java.io.Serializable;
import javax.annotation.Generated;

public class Role implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_id")
    private String roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_name")
    private String roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_remark")
    private String roleRemark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_role")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_id")
    public String getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_id")
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_name")
    public String getRoleName() {
        return roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_name")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_remark")
    public String getRoleRemark() {
        return roleRemark;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_remark")
    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}