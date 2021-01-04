package com.annwyn.autolycus.common.validator;

import com.annwyn.autolycus.common.utils.ConstantUtils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collection;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConstantFieldValidator.class)
public @interface ConstantField {

    ConstantFieldEnum constantField();

    boolean required() default false;

    String message() default "参数{value}不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    enum ConstantFieldEnum {
        STATUS(Arrays.asList(ConstantUtils.STATUS_DISABLED, ConstantUtils.STATUS_ENABLED));

        private final Collection<Number> constants;

        ConstantFieldEnum(Collection<Number> constants) {
            this.constants = constants;
        }

        public Collection<Number> getConstants() {
            return this.constants;
        }
    }

}

