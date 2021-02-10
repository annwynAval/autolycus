package com.annwyn.autolycus.backend.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@ApiModel("管理员基本信息")
public class Manager implements Serializable {

    @ApiModelProperty("主键")
    private String managerId;

    @ApiModelProperty("管理员邮件")
    private String managerMail;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("管理员名称")
    private String managerName;

    @ApiModelProperty("管理员电话")
    private String managerPhone;

    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("状态值: 1.可用; 0:不可用")
    private Integer status;

    @ApiModelProperty("注册时间")
    private LocalDateTime registerDate;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateDate;

}
