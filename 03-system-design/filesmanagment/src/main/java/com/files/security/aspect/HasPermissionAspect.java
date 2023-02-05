package com.files.security.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.files.enums.FilesErrorEnum;
import com.files.exception.FilesManagmentException;
import com.files.security.service.AuthenticationService;

import lombok.AllArgsConstructor;

@Component
@Aspect
@AllArgsConstructor
public class HasPermissionAspect {
	
	private AuthenticationService authService;
	
	@Pointcut("execution(@HasPermission * *(..))")
	public static boolean hasPermissionMethods() {
		
		 return !AuthenticationService.isAdminUser();
	}
	
	@Before("hasPermissionMethods()")
	public void before(JoinPoint joinPoint) throws FilesManagmentException {
		
		if(!authService.hasEditPrivillages())
			throw new FilesManagmentException(FilesErrorEnum.INVALID_PERMISSION);
	}
}
