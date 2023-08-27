package com.mka.hotel.service.HotelService.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloableExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> notFoundException(ResourceNotFoundException ex){
		Map map = new HashMap<>();
		map.put("message",ex.getMessage());
		map.put("success", false);
		map.put("Status", HttpStatus.NOT_FOUND);
		return (ResponseEntity<Map<String, Object>>) map;
		
	}

}
