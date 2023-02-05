package com.files.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.files.domain.File;
import com.files.domain.Item;
import com.files.enums.FilesErrorEnum;
import com.files.exception.FilesManagmentException;
import com.files.repository.FilesRepository;
import com.files.service.FileService;
import com.files.service.ItemService;
import com.files.util.FileUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
	
	private final ItemService itemService;
	private final FilesRepository filesRepository;

	@Override
	public void uploadFile(Long itemId, MultipartFile file) throws Exception {
		
		Item item = itemService.getItemById(itemId);
		
		File fileInfo = File.builder()
				.item(item)
                .binaryFile(FileUtils.compressImage(file.getBytes()))
                .build();
        
		filesRepository.save(fileInfo);
	}

	@Override
	public byte[] downloadFile(Long id) throws FilesManagmentException {
		
		File file = filesRepository.findById(id)
				.orElseThrow(() -> new FilesManagmentException(FilesErrorEnum.FILE_NOT_FOUNDED));
		
        byte[] data = FileUtils.decompressImage(file.getBinaryFile());
        
        return data;
	}

}
