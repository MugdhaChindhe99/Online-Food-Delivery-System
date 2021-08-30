package com.cg.ofd.customer.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<CustomerErrorResponse> handleExceptions(CustomerNotFoundException exception,
			WebRequest webRequest) {
		CustomerErrorResponse response = new CustomerErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<CustomerErrorResponse>(response, HttpStatus.NOT_FOUND); // 404 Provides handling for standard Spring MVC exceptions.
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExceptions(Exception ex) {
		CustomerErrorResponse response = new CustomerErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setDateTime(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		return new ResponseEntity<CustomerErrorResponse>(response, HttpStatus.BAD_REQUEST); // 400
	}

	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ValidationResponse response = new ValidationResponse(System.currentTimeMillis(), "Validation Failed",
				ex.getBindingResult().toString());

		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}// Validations

}
