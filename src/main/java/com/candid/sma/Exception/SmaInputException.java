package com.candid.sma.Exception;

import org.springframework.web.bind.MethodArgumentNotValidException;

public class SmaInputException extends Exception{
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public SmaInputException(String errorMessage) {
	//	super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public SmaInputException() {
		super();
	}
}
