package com.cg.ofd.customer.exception;

public class CustomerNotFoundException extends RuntimeException { 

	
	String message;

	public CustomerNotFoundException(String message) {

		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
