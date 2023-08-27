package com.mka.hotel.service.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		super("Resource not foung Exception");
	}
	public ResourceNotFoundException(String s) {
		super(s);
	}
}
