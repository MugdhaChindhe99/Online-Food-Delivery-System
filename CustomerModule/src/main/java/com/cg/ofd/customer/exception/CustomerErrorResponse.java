package com.cg.ofd.customer.exception;

import java.time.LocalDateTime;

public class CustomerErrorResponse {

	private int status;
	private String message;
	private LocalDateTime dateTime;
	public CustomerErrorResponse() {
		
	}
	public CustomerErrorResponse(int status, String message, LocalDateTime dateTime) {
		super();
		this.status = status;
		this.message = message;
		this.dateTime = dateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	

}
