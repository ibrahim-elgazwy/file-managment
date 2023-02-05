package com.files.rest.response;

import java.io.Serializable;
import java.util.List;

import com.files.enums.FilesErrorEnum;
import com.files.enums.StatusEnum;
import com.files.exception.ValidationError;

import lombok.Data;

@Data
public class RestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6409809055025344148L;

	private StatusEnum status;
	private String errorCode;
	private String errorDescription;
	private Object body;

	public RestResponse() {
		this.status = StatusEnum.OK;
	}

	public RestResponse(Object body) {
		this();
		this.body = body;
	}
	
	public RestResponse(String errorMessage) {
		this.status = StatusEnum.ERROR;
		this.body = errorMessage;
	}
	
	public RestResponse(String errorCode, String errorDescription) {
		this.status = StatusEnum.ERROR;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public RestResponse(StatusEnum statusEnum, List<ValidationError> errorDetails, FilesErrorEnum filesErrorEnum) {
		this.status = statusEnum;
		this.errorCode = filesErrorEnum.getErrorCode();
		this.errorDescription = filesErrorEnum.getErrorDescription();
		this.setBody(errorDetails);
	}
}
