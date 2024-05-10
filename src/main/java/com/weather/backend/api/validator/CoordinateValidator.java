package com.weather.backend.api.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class CoordinateValidator implements ConstraintValidator<ValidCoordinate, String> {
    private String message;
    private double min;
    private double max;

    @Override
    public void initialize(ValidCoordinate constraintAnnotation) {
        message = constraintAnnotation.message();
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String coordinate, ConstraintValidatorContext context) {
        if (Objects.isNull(coordinate) || isInvalidCoordinate(coordinate)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean isInvalidCoordinate(String coordinate) {
        try {
            double v = Double.parseDouble(coordinate);
            return v < min || v > max;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}