package com.annwyn.autolycus.mybatis.generator.mapper;

import static com.annwyn.autolycus.mybatis.generator.mapper.ManagerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.annwyn.autolycus.mybatis.generator.model.Manager;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ManagerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    BasicColumn[] selectList = BasicColumn.columnList(managerId, managerName, managerMail, managerPhone, password, roleId, status, registerDate, updateDate);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Manager> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Manager> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ManagerResult")
    Optional<Manager> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ManagerResult", value = {
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="manager_name", property="managerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_mail", property="managerMail", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager_phone", property="managerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="register_date", property="registerDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Manager> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, manager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, manager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default int deleteByPrimaryKey(String managerId_) {
        return delete(c -> 
            c.where(managerId, isEqualTo(managerId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default int insert(Manager record) {
        return MyBatis3Utils.insert(this::insert, record, manager, c ->
            c.map(managerId).toProperty("managerId")
            .map(managerName).toProperty("managerName")
            .map(managerMail).toProperty("managerMail")
            .map(managerPhone).toProperty("managerPhone")
            .map(password).toProperty("password")
            .map(roleId).toProperty("roleId")
            .map(status).toProperty("status")
            .map(registerDate).toProperty("registerDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default int insertMultiple(Collection<Manager> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, manager, c ->
            c.map(managerId).toProperty("managerId")
            .map(managerName).toProperty("managerName")
            .map(managerMail).toProperty("managerMail")
            .map(managerPhone).toProperty("managerPhone")
            .map(password).toProperty("password")
            .map(roleId).toProperty("roleId")
            .map(status).toProperty("status")
            .map(registerDate).toProperty("registerDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default int insertSelective(Manager record) {
        return MyBatis3Utils.insert(this::insert, record, manager, c ->
            c.map(managerId).toPropertyWhenPresent("managerId", record::getManagerId)
            .map(managerName).toPropertyWhenPresent("managerName", record::getManagerName)
            .map(managerMail).toPropertyWhenPresent("managerMail", record::getManagerMail)
            .map(managerPhone).toPropertyWhenPresent("managerPhone", record::getManagerPhone)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(registerDate).toPropertyWhenPresent("registerDate", record::getRegisterDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", record::getUpdateDate)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default Optional<Manager> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, manager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default List<Manager> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, manager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default List<Manager> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, manager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default Optional<Manager> selectByPrimaryKey(String managerId_) {
        return selectOne(c ->
            c.where(managerId, isEqualTo(managerId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, manager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    static UpdateDSL<UpdateModel> updateAllColumns(Manager record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(managerId).equalTo(record::getManagerId)
                .set(managerName).equalTo(record::getManagerName)
                .set(managerMail).equalTo(record::getManagerMail)
                .set(managerPhone).equalTo(record::getManagerPhone)
                .set(password).equalTo(record::getPassword)
                .set(roleId).equalTo(record::getRoleId)
                .set(status).equalTo(record::getStatus)
                .set(registerDate).equalTo(record::getRegisterDate)
                .set(updateDate).equalTo(record::getUpdateDate);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Manager record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(managerId).equalToWhenPresent(record::getManagerId)
                .set(managerName).equalToWhenPresent(record::getManagerName)
                .set(managerMail).equalToWhenPresent(record::getManagerMail)
                .set(managerPhone).equalToWhenPresent(record::getManagerPhone)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(registerDate).equalToWhenPresent(record::getRegisterDate)
                .set(updateDate).equalToWhenPresent(record::getUpdateDate);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default int updateByPrimaryKey(Manager record) {
        return update(c ->
            c.set(managerName).equalTo(record::getManagerName)
            .set(managerMail).equalTo(record::getManagerMail)
            .set(managerPhone).equalTo(record::getManagerPhone)
            .set(password).equalTo(record::getPassword)
            .set(roleId).equalTo(record::getRoleId)
            .set(status).equalTo(record::getStatus)
            .set(registerDate).equalTo(record::getRegisterDate)
            .set(updateDate).equalTo(record::getUpdateDate)
            .where(managerId, isEqualTo(record::getManagerId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: mms_manager")
    default int updateByPrimaryKeySelective(Manager record) {
        return update(c ->
            c.set(managerName).equalToWhenPresent(record::getManagerName)
            .set(managerMail).equalToWhenPresent(record::getManagerMail)
            .set(managerPhone).equalToWhenPresent(record::getManagerPhone)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(roleId).equalToWhenPresent(record::getRoleId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(registerDate).equalToWhenPresent(record::getRegisterDate)
            .set(updateDate).equalToWhenPresent(record::getUpdateDate)
            .where(managerId, isEqualTo(record::getManagerId))
        );
    }
}