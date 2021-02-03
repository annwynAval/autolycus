package com.annwyn.autolycus.extra.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConstantFieldValidator implements ConstraintValidator<ConstantField, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return false;
    }
}
