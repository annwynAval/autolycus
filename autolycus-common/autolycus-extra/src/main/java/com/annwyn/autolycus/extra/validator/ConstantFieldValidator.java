package com.annwyn.autolycus.extra.validator;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * 常量检验
 */
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
        String convertValue = String.valueOf(value);
        for(String template : this.constantField.fields()) {
            if(Objects.equals(convertValue, template)) {
                return true;
            }
        }
        return false;
    }

}
