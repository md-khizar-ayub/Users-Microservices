package com.mka.rating.service.RatingService.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mka.rating.service.RatingService.entities.Rating;

public interface RatingService {
	//create
	
	public Rating craeteRating(Rating rating);
	
	//getAll Rating
	public List<Rating> getAllRating();
	
	//getRatingby Id
	
	public Rating getRatingById(String id);
	
	public List<Rating> getAllRatingbyUserId(String userId);
	
	public List<Rating> getAllRatingbyHoteId(String HotelId);
}
