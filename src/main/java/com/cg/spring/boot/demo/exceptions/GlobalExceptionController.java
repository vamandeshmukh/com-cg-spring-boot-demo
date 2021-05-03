package com.cg.spring.boot.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
//	public class ExceptionController { // Global Exception Controller 

	@ExceptionHandler(value = EmployeeNotfoundException.class)

	public ResponseEntity<Object> EmpNfEx(EmployeeNotfoundException exception) {
		// public ResponseEntity<Object> EmpNfEx() {

		String response = "This Employee does not exist.";

//		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response, 
				HttpStatus.valueOf(400));
	}

	// create other exception handlers
}
