package com.weather.backend.api.validator;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CoordinateValidator.class)
@Retention(RUNTIME)
@Target({ElementType.PARAMETER})
public @interface ValidCoordinate {
    double min() default -180;

    double max() default 180;

    String message() default "Invalid coordinate";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}