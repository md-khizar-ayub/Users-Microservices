package com.mka.users.service.UserService.exception;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mka.users.service.UserService.payload.ApiResponse;

import lombok.Builder;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	ApiResponse build;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handler(ResourceNotFoundException ex){
		String message =ex.getMessage();
		build.setApiResponce(message, true ,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiResponse>(build,HttpStatus.NOT_FOUND);
		
	}

}
