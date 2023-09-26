package com.example.demo.customValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = CustomibanValidator.class)
public @interface CustomibanSize {

	String message() default "Value can't be ooooooo";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload()default {};
	String key() default "24";
	
}
