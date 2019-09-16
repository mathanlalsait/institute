package com.candid.sma.Exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class MyCustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	    @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorDetails error = new ErrorDetails("Server Error", details);
	        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	    @ExceptionHandler(RecordNotFoundException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorDetails error = new ErrorDetails("Record Not Found", details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
	 
	    @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	            details.add(error.getDefaultMessage());
	        }
	        ErrorDetails error = new ErrorDetails("Validation Failed", details);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	    }
	    
	  
//	    @ExceptionHandler(SmaInputException.class)
//	    protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//	        List<String> details = new ArrayList<>();
//	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
//	            details.add(error.getDefaultMessage());
//	        }
//	        ErrorDetails error = new ErrorDetails("Validation Failed", details);
//	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
//	    }
	
}