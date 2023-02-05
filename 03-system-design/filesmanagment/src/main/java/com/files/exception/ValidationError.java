package com.files.exception;

import jakarta.validation.ConstraintViolation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationError {

	private String field;
	private String error;
	
	public static ValidationError getValidationError(ConstraintViolation<?> constraint) {
		
		return ValidationError.builder()
			.field(constraint.getPropertyPath().toString())
			.error(constraint.getMessage())
			.build();
	}
}
