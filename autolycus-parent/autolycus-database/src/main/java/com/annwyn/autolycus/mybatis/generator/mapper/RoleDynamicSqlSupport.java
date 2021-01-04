package com.annwyn.autolycus.mybatis.generator.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_role")
    public static final Role role = new Role();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_id")
    public static final SqlColumn<String> roleId = role.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_name")
    public static final SqlColumn<String> roleName = role.roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.role_remark")
    public static final SqlColumn<String> roleRemark = role.roleRemark;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: mms_role.status")
    public static final SqlColumn<Boolean> status = role.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_role")
    public static final class Role extends SqlTable {
        public final SqlColumn<String> roleId = column("role_id", JDBCType.VARCHAR);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public final SqlColumn<String> roleRemark = column("role_remark", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> status = column("\"status\"", JDBCType.BIT);

        public Role() {
            super("mms_role");
        }
    }
}