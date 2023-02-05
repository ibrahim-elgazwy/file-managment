package com.files.exception;

import java.io.Serializable;

import com.files.enums.FilesErrorEnum;

public class FilesManagmentException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9104774395299694560L;

	private String errorCode;
	private String errorDescription;
	private Long errorId;

	public FilesManagmentException(FilesErrorEnum filesErrorEnum) {
		this.errorCode = filesErrorEnum.getErrorCode();
		this.errorDescription = filesErrorEnum.getErrorDescription();
	}
	
	public FilesManagmentException(FilesErrorEnum filesErrorEnum, Long errorId) {
		this(filesErrorEnum);
		this.errorId = errorId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	private Long getErrorId() {
		return errorId;
	}

	private void setErrorId(Long errorId) {
		this.errorId = errorId;
	}
}
