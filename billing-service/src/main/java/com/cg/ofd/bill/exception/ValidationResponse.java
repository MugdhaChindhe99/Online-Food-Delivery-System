package com.cg.ofd.bill.exception;

public class ValidationResponse {
	 private long timestamp;
	  private String message;
	  private int status;

	  public ValidationResponse() {
		
	}
	  
	  public ValidationResponse(long timestamp, String message,int status) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	    this.status = status;
	  }

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	
}