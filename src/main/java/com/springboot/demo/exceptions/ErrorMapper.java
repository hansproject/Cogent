package com.springboot.demo.exceptions;

import java.util.Date;

public class ErrorMapper {

	private String errorMessage;
	private String errorCode;
	private Date timeStamp;
	
	public ErrorMapper() {super();}

	public ErrorMapper(String errorMessage, String errorCode, Date timeStamp) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
