package com.annwyn.autolycus.mybatis.generator.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.Generated;

public class Manager implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_id")
    private String managerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_name")
    private String managerName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_mail")
    private String managerMail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_phone")
    private String managerPhone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.role_id")
    private String roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.status")
    private Byte status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.register_date")
    private LocalDateTime registerDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.update_date")
    private LocalDateTime updateDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_id")
    public String getManagerId() {
        return managerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_id")
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_name")
    public String getManagerName() {
        return managerName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_name")
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_mail")
    public String getManagerMail() {
        return managerMail;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_mail")
    public void setManagerMail(String managerMail) {
        this.managerMail = managerMail;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_phone")
    public String getManagerPhone() {
        return managerPhone;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_phone")
    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.role_id")
    public String getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.role_id")
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.status")
    public Byte getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.status")
    public void setStatus(Byte status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.register_date")
    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.register_date")
    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.update_date")
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.update_date")
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}