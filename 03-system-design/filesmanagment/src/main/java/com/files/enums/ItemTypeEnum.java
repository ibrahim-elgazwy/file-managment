package com.files.enums;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ItemTypeEnum {
	
	SPACE("SPACE"), 
	FOLDER("FOLDER"), 
	FILE("FILE");
	
	private String type;
	
	public static String getItemType(String type) throws Exception {
		
		return Stream.of(ItemTypeEnum.values())
				.filter(item -> item.getType().equalsIgnoreCase(type))
				.map(item -> item.getType())
				.findFirst()
				.orElseThrow(() -> new Exception("Invlid Item Type!!"));
	}

	private String getType() {
		return type;
	}
}
