package com.cg.ofd.bill.exception;

public class BillNotFoundException extends RuntimeException {
	
	String message;

	public BillNotFoundException(String message) {
		
		setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * public BillNotFoundException(String message, Throwable cause) {
	 * super(message, cause); }
	 * 
	 * public BillNotFoundException(Throwable cause) { super(cause); }
	 */

	
}
