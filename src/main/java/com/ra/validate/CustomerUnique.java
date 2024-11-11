package com.ra.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//validatedBy: validate bởi 1 class nào đó
@Constraint(validatedBy = CustomerValidate.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerUnique {
    String message() default "email duplicate entry";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
