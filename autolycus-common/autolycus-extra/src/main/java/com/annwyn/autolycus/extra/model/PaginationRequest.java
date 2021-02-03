package com.annwyn.autolycus.extra.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 分页请求头
 */
@Setter
@Getter
@ApiModel("分页相关参数")
public class PaginationRequest implements Serializable {

    public static final int DEFAULT_PAGINATION_LIMIT = 25;
    public static final int DEFAULT_PAGINATION_OFFSET = 0;

    /**
     * 分页大小
     */
    @ApiModelProperty("分页大小")
    private Integer limit = PaginationRequest.DEFAULT_PAGINATION_LIMIT;

    /**
     * 默认的分页开始数
     */
    @ApiModelProperty("分页开始数")
    private Integer offset = PaginationRequest.DEFAULT_PAGINATION_OFFSET;

}
