package com.files.rest.request;

import com.files.domain.Item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemRequest {

	private String type;
	
	private String name;
	
	private Item parentItem; 
}
