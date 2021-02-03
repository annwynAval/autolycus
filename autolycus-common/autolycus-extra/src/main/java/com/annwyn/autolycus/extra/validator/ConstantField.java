package com.annwyn.autolycus.extra.validator;

import javax.validation.Payload;

public @interface ConstantField {

    String[] fields() default {};

    boolean required() default false;

    String message() default "参数{value}不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
