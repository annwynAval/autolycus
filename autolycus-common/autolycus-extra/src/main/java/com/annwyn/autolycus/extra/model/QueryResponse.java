package com.annwyn.autolycus.extra.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@ApiModel("统一返回信息结构")
public class QueryResponse<T> implements Serializable {

    @ApiModelProperty("状态值")
    private final int status;

    @ApiModelProperty("返回信息")
    private final String message;

    @ApiModelProperty("返回实体类")
    private final T model;

    @ApiModelProperty("返回集合")
    private final Collection<T> models;

    @ApiModelProperty("返回集合的总数")
    private final long total;

    private QueryResponse(int status, String message, T model, List<T> models, long total) {
        this.status = status;
        this.message = message;
        this.model = model;
        this.models = models;
        this.total = total;
    }

    public static <X> QueryResponse<X> build(ResponseStatus status, String message) {
        return new QueryResponse<>(status.getCode(), message, null, null, 0);
    }

    public static <X> QueryResponse<X> build(ResponseStatus status, String message, X model) {
        return new QueryResponse<>(status.getCode(), message, model, null, 0);
    }

    public static <X> QueryResponse<X> build(ResponseStatus status, long total, List<X> models) {
        return new QueryResponse<>(status.getCode(), null, null, models, total);
    }

    public static <X> QueryResponse<X> failed(String message) {
        return new QueryResponse<>(ResponseStatus.STATUS_ERROR.getCode(), message, null, null, 0);
    }

    public static <X> QueryResponse<X> success(String message) {
        return new QueryResponse<>(ResponseStatus.STATUS_SUCCESS.getCode(), message, null, null, 0);
    }
}
