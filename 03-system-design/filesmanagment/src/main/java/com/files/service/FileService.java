package com.files.service;

import org.springframework.web.multipart.MultipartFile;

import com.files.exception.FilesManagmentException;

public interface FileService {
	
	void uploadFile(Long itemId, MultipartFile file) throws Exception;

	byte[] downloadFile(Long id) throws FilesManagmentException;
}
