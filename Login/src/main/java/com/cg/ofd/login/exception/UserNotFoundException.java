package com.cg.ofd.login.exception;

public class UserNotFoundException extends RuntimeException {
	String message;

	public UserNotFoundException(String message) {
		setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
