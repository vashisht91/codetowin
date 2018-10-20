package com.api.bank.exception;

import org.springframework.http.HttpStatus;

public class APIError {

	private HttpStatus httpStatus;
	private String message;
	
	public APIError(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "APIError [httpStatus=" + httpStatus + ", message=" + message + "]";
	}
	
	
	
}
