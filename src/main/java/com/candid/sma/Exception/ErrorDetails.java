package com.candid.sma.Exception;

import java.util.List;

public class ErrorDetails {
	private int errorCode;
	private String message;
	private List<String> details;

	public ErrorDetails() {
	}

	public ErrorDetails(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public ErrorDetails(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	public ErrorDetails(int errorCode, String message, List<String> details) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.details = details;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

}
