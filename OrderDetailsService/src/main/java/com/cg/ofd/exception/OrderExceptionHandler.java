package com.cg.ofd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<OrderErrorResponse> handleException(OrderNotFoundException exception,
			WebRequest webRequest) {
		OrderErrorResponse errorResponse = new OrderErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<OrderErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(Exception ex) {
		OrderErrorResponse errorResponse = new OrderErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("Record not found");
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<OrderErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
