package com.annwyn.autolycus.extra.component;

import com.annwyn.autolycus.extra.exception.ServiceException;
import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.extra.model.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理请求参数格式错误.
     * 使用{@link org.springframework.web.bind.annotation.RequestBody}后, 将会抛出该异常
     *
     * @param e {@link MethodArgumentNotValidException}
     * @return {@link String}
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public QueryResponse<?> resolveMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        this.logger.error("参数验证出现错误!", e);
        String message = this.getValidateMessage(e.getBindingResult().getFieldErrors());
        return QueryResponse.build(ResponseStatus.STATUS_PARAMS_NOT_VALID, message);
    }

    /**
     * 处理请求参数格式错误.
     * get请求中, 使用{@link javax.validation.Valid}验证路径中的实体, 验证失败后抛出该异常
     *
     * @param e {@link MethodArgumentNotValidException}
     * @return {@link String}
     */
    @ExceptionHandler(BindException.class)
    public QueryResponse<?> resolveBindException(BindException e) {
        this.logger.error("参数验证出现错误!", e);
        String message = this.getValidateMessage(e.getBindingResult().getFieldErrors());
        return QueryResponse.build(ResponseStatus.STATUS_PARAMS_NOT_VALID, message);
    }

    private String getValidateMessage(List<FieldError> fieldErrors) {
        if(CollectionUtils.isEmpty(fieldErrors)) {
            return "参数检验时出现未知异常!";
        }
        return fieldErrors.stream() //
                .map(DefaultMessageSourceResolvable::getDefaultMessage) //
                .collect(Collectors.joining(","));
    }

    /**
     * 处理请求参数格式错误.
     * 使用{@link org.springframework.web.bind.annotation.RequestParam}后, 将会抛出该异常
     *
     * @param e {@link MethodArgumentNotValidException}
     * @return {@link String}
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public QueryResponse<?> resolveConstraintViolationException(ConstraintViolationException e) {
        this.logger.error("参数验证出现错误!", e);
        String message = this.getValidateMessage(e.getConstraintViolations());
        return QueryResponse.build(ResponseStatus.STATUS_PARAMS_NOT_VALID, message);
    }

    private String getValidateMessage(Set<ConstraintViolation<?>> constraintViolations) {
        if(CollectionUtils.isEmpty(constraintViolations)) {
            return "参数检验时出现未知异常!";
        }
        return constraintViolations.stream() //
                .map(ConstraintViolation::getMessage) //
                .collect(Collectors.joining(","));
    }

    /**
     * 业务处理时出现的异常
     * @param e {@link ServiceException}
     * @return {@link QueryResponse}
     */
    @ExceptionHandler(ServiceException.class)
    public QueryResponse<?> resolveServiceException(ServiceException e) {
        this.logger.error(e.getMessage(), e);
        return QueryResponse.failed(e.getMessage());
    }

    /**
     * 请求方式错误时的出现的异常信息
     * @param e {@link HttpRequestMethodNotSupportedException}
     * @return {@link QueryResponse}
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public QueryResponse<?> resolveHttpMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        this.logger.error(e.getMessage(), e);
        return QueryResponse.build(ResponseStatus.STATUS_NOT_SUPPORT, "当前请求方式不支持!");
    }

    /**
     * 未知异常出现时的异常信息
     * @param e {@link Exception}
     * @return {@link QueryResponse}
     */
    @ExceptionHandler(Exception.class)
    public QueryResponse<?> resolveUnCatchException(Exception e) {
        this.logger.error("程序出现异常. ", e);
        return QueryResponse.build(ResponseStatus.STATUS_UNKNOWN_ERROR, "程序出现未知异常. 请与管理员联系.");
    }




}
