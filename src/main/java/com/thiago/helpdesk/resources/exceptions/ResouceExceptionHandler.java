package com.thiago.helpdesk.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thiago.helpdesk.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResouceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError>objectNotFoundException(ObjectNotFoundException ex,HttpServletRequest request) {
		
	StandardError error = new StandardError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(),"Object Not Found",ex.getMessage(),request.getRequestURI());
	
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
