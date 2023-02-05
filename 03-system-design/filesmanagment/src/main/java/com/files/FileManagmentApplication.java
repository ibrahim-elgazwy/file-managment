package com.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.files.security.aspect.HasPermissionAspect;

@SpringBootApplication
public class FileManagmentApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(FileManagmentApplication.class, args);
	}
}
