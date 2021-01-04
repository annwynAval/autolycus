package com.annwyn.autolycus.common.validator;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ConstantFieldValidator implements ConstraintValidator<ConstantField, Number> {

    private ConstantField constantField;

    @Override
    public void initialize(ConstantField constraintAnnotation) {
        this.constantField = constraintAnnotation;
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if(value == null) {
            return this.constantField.required();
        }

        if(context instanceof HibernateConstraintValidatorContext) {
            context.unwrap(HibernateConstraintValidatorContext.class).addMessageParameter("value", value);
        }

        for(Number template : this.constantField.constantField().getConstants()) {
            if(Objects.equals(template, value)) {
                return true;
            }
        }
        return false;
    }
}
