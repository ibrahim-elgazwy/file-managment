package com.files.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.files.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

	private final FileService fileService;
	
	@PostMapping("/upload/{itemId}")
	public ResponseEntity<String> createItem(
			@PathVariable Long itemId,
			@RequestParam("file") MultipartFile file) throws Exception {
		
		fileService.uploadFile(itemId, file);
		return ResponseEntity.ok("File Uploaded Successfuly!!");
	}
	
	@GetMapping("/download/{fileId}")
	public ResponseEntity<?> getItem(@PathVariable Long fileId) throws Exception {
		
		byte[] file = fileService.downloadFile(fileId);
		
		final HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    
		return ResponseEntity.status(HttpStatus.OK)
				.headers(httpHeaders)
				.body(file);
	}
}
