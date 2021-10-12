package com.gco.studentService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;



@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<String> queryHandler(NoSuchUserException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
