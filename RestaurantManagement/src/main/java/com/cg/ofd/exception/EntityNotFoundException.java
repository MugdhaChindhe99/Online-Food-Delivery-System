package com.cg.ofd.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 2L;
	private String message;

	public EntityNotFoundException() {
		super();
		
	}

	public EntityNotFoundException(String message) {
		setMessage(message);
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
}
