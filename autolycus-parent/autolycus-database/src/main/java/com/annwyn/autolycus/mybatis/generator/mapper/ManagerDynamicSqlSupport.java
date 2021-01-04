package com.annwyn.autolycus.mybatis.generator.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ManagerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    public static final Manager manager = new Manager();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_id")
    public static final SqlColumn<String> managerId = manager.managerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_name")
    public static final SqlColumn<String> managerName = manager.managerName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_mail")
    public static final SqlColumn<String> managerMail = manager.managerMail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.manager_phone")
    public static final SqlColumn<String> managerPhone = manager.managerPhone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.password")
    public static final SqlColumn<String> password = manager.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.role_id")
    public static final SqlColumn<String> roleId = manager.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.status")
    public static final SqlColumn<Byte> status = manager.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.register_date")
    public static final SqlColumn<LocalDateTime> registerDate = manager.registerDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_manager.update_date")
    public static final SqlColumn<LocalDateTime> updateDate = manager.updateDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    public static final class Manager extends SqlTable {
        public final SqlColumn<String> managerId = column("manager_id", JDBCType.VARCHAR);

        public final SqlColumn<String> managerName = column("manager_name", JDBCType.VARCHAR);

        public final SqlColumn<String> managerMail = column("manager_mail", JDBCType.VARCHAR);

        public final SqlColumn<String> managerPhone = column("manager_phone", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("\"password\"", JDBCType.VARCHAR);

        public final SqlColumn<String> roleId = column("role_id", JDBCType.VARCHAR);

        public final SqlColumn<Byte> status = column("\"status\"", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> registerDate = column("register_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public Manager() {
            super("mms_manager");
        }
    }
}