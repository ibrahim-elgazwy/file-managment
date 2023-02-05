package com.files.rest.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileRequest {

	MultipartFile file;
	Long itemId;
}
