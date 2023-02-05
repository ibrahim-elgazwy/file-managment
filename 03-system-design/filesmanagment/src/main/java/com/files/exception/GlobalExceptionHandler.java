package com.files.exception;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.files.enums.FilesErrorEnum;
import com.files.enums.StatusEnum;
import com.files.rest.response.RestResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FilesManagmentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestResponse handleFileManagmentException(FilesManagmentException filesManagmentException) {
	
		return new RestResponse(filesManagmentException.getErrorCode(), 
				                filesManagmentException.getErrorDescription());
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestResponse handleUsernameNotFoundException(UsernameNotFoundException UsernameNotFoundException) {
		
		return new RestResponse("INVALID_USER_CREDINTIOAL", 
				UsernameNotFoundException.getMessage());
	}
	
    
//	@ExceptionHandler(SQLException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public @ResponseBody RestResponse handleException(SQLException filesManagmentException) {
//		System.out.println(filesManagmentException.getCause());
//		return new RestResponse(filesManagmentException.getMessage());
//	}
	
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResponse handleConstraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
    	
			List<ValidationError> messages = ex.getConstraintViolations()
					.stream().map(ValidationError::getValidationError)
					.collect(Collectors.toList());
			
			return new RestResponse(StatusEnum.ERROR, messages, FilesErrorEnum.INVALID_FIELDS);
	}
}
