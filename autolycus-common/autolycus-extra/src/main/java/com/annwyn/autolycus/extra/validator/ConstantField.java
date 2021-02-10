package com.annwyn.autolycus.extra.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Inherited
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConstantFieldValidator.class)
public @interface ConstantField {

    String[] fields() default {};

    boolean required() default false;

    String message() default "参数{value}验证不通过";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
