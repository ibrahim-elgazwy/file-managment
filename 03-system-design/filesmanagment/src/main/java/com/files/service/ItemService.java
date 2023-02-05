package com.files.service;

import java.util.List;

import com.files.domain.Item;
import com.files.exception.FilesManagmentException;
import com.files.rest.request.ItemRequest;
import com.files.rest.response.ItemResponse;

public interface ItemService {

	ItemResponse create(ItemRequest itemRequest) throws Exception;
	
	List<ItemResponse> findItemStructure(Long itemId);
	
	Item getItemById(Long id) throws FilesManagmentException;
}
