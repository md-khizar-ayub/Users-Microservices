package com.mka.rating.service.RatingService.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String s) {
		super(s);
	}
	public ResourceNotFoundException() {
		super("Responce Not Fount Exception");
	}

}
