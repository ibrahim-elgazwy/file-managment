package com.files.rest.response;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.files.domain.Item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemResponse {

	private Long id;
	
	private String type;
	
	private String name;
	
	private Long parentId;
	
	public static ItemResponse buildResponse(Item item) {
		
		Long parentId = Objects.nonNull(item.getParentItem()) 
				? item.getParentItem().getId()
				: null;
		
		return ItemResponse.builder()
						.id(item.getId())
						.type(item.getType())
						.name(item.getName())
						.parentId(parentId)
						.build();
	}
	
	public static List<ItemResponse> buildResponse(List<Item> items) {
		
		return items.stream()
				.map(ItemResponse::buildResponse)
				.collect(Collectors.toList());
	}
}
