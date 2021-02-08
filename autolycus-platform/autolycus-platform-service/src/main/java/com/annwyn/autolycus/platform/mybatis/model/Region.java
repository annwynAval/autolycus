package com.annwyn.autolycus.platform.mybatis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@ApiModel("中国省市区级联信息")
public class Region implements Serializable {

    @ApiModelProperty("省市区id")
    private Integer regionId;

    @ApiModelProperty("省市区名称")
    private String regionName;

    @ApiModelProperty("省市区父级id")
    private Integer parentId;

    @ApiModelProperty("省市区级别. 1: 省. 2: 市. 3: 区. 4: 街道")
    private Integer regionLevel;


}
