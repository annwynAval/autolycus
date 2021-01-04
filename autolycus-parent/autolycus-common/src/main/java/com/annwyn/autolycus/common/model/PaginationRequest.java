package com.annwyn.autolycus.common.model;

import com.annwyn.autolycus.common.utils.ConstantUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@ApiModel("分页相关参数")
public class PaginationRequest implements Serializable {

    /**
     * 分页大小
     */
    @ApiModelProperty("分页大小")
    private int limit = ConstantUtils.DEFAULT_PAGINATION_LIMIT;

    /**
     * 默认的分页开始数
     */
    @ApiModelProperty("分页开始数")
    private int offset = ConstantUtils.DEFAULT_PAGINATION_OFFSET;


}
