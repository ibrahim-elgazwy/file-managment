package com.files.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.files.domain.Item;
import com.files.domain.PermissionGroup;
import com.files.enums.FilesErrorEnum;
import com.files.enums.ItemTypeEnum;
import com.files.enums.PermissionGroupEnum;
import com.files.exception.FilesManagmentException;
import com.files.repository.ItemRepository;
import com.files.rest.request.ItemRequest;
import com.files.rest.response.ItemResponse;
import com.files.security.aspect.HasPermission;
import com.files.service.ItemService;
import com.files.service.PermissionGroupService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
	
	private final ItemRepository itemRepository;
	private final PermissionGroupService permissionGroupService;

	@Override
	@HasPermission
	public ItemResponse create(ItemRequest itemRequest) throws Exception {
		
		PermissionGroup permissionGroup = permissionGroupService
				.findByGroupName(PermissionGroupEnum.ADMIN_GROUP.toString());
		
		Item item = Item.builder()
			.type(ItemTypeEnum.getItemType(itemRequest.getType()))
			.name(itemRequest.getName())
			.permissionGroup(permissionGroup)
			.build();
		
		if(Objects.nonNull(itemRequest.getParentItem()))
			item.setParentItem(getItemById(itemRequest.getParentItem().getId())); 
		
		item = itemRepository.save(item);
		
		return ItemResponse.buildResponse(item);
	}
	
	@Override
	public Item getItemById(Long itemId) throws FilesManagmentException {
		
		return itemRepository.findById(itemId)
				.orElseThrow(() -> new FilesManagmentException(FilesErrorEnum.ITEM_NOT_FOUNDED));
	}

	@Override
	@HasPermission
	public List<ItemResponse> findItemStructure(Long itemId) {
		
		List<Item> items = itemRepository.findItemStructure(itemId)
				.orElse(new ArrayList<>());
		
		return ItemResponse.buildResponse(items);
	}
}
