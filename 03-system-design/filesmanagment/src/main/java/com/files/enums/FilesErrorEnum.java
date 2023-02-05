package com.files.enums;

public enum FilesErrorEnum {

	INVALID_PERMISSION("INVALID_PERMISSION", "Invalid Permissions!!"),
	ITEM_NOT_FOUNDED("ITEM_NOT_FOUNDED", "Item Not Founded!!"),
	FILE_NOT_FOUNDED("FILE_NOT_FOUNDED", "File Not Founded!!"),
	INVALID_FIELDS("INVALID_FIELDS", "invalid body fields"),
	INVALID_GROUP_NAME("INVALID_GROUP_NAME", "invalid group name!!");
	
	private String errorCode;
	private String errorDescription;
	
	private FilesErrorEnum(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
}
