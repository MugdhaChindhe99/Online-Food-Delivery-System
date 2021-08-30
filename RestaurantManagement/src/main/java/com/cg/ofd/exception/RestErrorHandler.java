package com.cg.ofd.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestErrorHandler extends ResponseEntityExceptionHandler { //extend vala nhi tha yaha pe
    
	//Now add one class extending ResponseEntityExceptionHandler and annotate it with @ControllerAdvice annotation.
		//ResponseEntityExceptionHandler is a convenient base class for to provide centralized
		//exception handling across all @RequestMapping methods through @ExceptionHandler methods. 
		//@ControllerAdvice is more for enabling auto-scanning and configuration at application startup.
		
	
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EntityNotFoundException exception,WebRequest webrequest)
    {
        ErrorResponse response= new ErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());//404
        response.setMessage(exception.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
    }

 
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status,WebRequest request) {
    	 ValidationResponse response= new ValidationResponse(System.currentTimeMillis(), "Validation Failed",
    			 ex.getBindingResult().toString());
    	
      return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    } 
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception)
    {
        ErrorResponse response= new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value()); //400
        response.setMessage("BadRequest");
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
    }
 


}