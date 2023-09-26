package com.example.demo.customValidation;


import com.example.demo.utils.ApplicationProperties;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomibanValidator implements ConstraintValidator<CustomibanSize, String> {

private String Key;


@Override
public void initialize(CustomibanSize Customibn) {
	this.Key = Customibn.key();
}
@Override
public boolean isValid(String value, ConstraintValidatorContext context) {
	int Value;
	if(ApplicationProperties.INSTANCE.getValue(Key)==null) {
		Value=Integer.parseInt(Key);
	}else {
		Value=Integer.parseInt(ApplicationProperties.INSTANCE.getValue(Key));
	}
		
	if(StringUtils.isEmpty(value)||value.length()!= Value) {
			return false;
		}else {
		return true;
	}
	
}
}
