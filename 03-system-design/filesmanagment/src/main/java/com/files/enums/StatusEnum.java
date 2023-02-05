package com.files.enums;

public enum StatusEnum {

	OK("OK"), ERROR("ERROR");

	private final String statusTxt;

	private StatusEnum(String statusTxt) {
		this.statusTxt = statusTxt;
	}

	@Override
	public String toString() {
		return statusTxt;
	}
}
