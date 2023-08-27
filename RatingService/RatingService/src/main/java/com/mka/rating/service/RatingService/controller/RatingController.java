package com.mka.rating.service.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mka.rating.service.RatingService.entities.Rating;
import com.mka.rating.service.RatingService.service.RatingService;

@RestController
@RequestMapping("/ratingservice")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/createrating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		
		Rating createdRating = ratingService.craeteRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
		
	}
	@GetMapping("/getallrating")
	public ResponseEntity<List<Rating>> getAllHotel(){
		List<Rating> allRating = ratingService.getAllRating();
		return ResponseEntity.ok(allRating);
	}
	
	@GetMapping("/getrating/{id}")
	public ResponseEntity<Rating> getHotelById(@PathVariable String id){
		Rating rating = ratingService.getRatingById(id);
		return ResponseEntity.ok(rating);
	}
	@GetMapping("/getratingbyuserid/{id}")
	public ResponseEntity<List<Rating>> getHotelByUserId(@PathVariable String id){
		List<Rating> rating = ratingService.getAllRatingbyUserId(id);
		return ResponseEntity.ok(rating);
	}
	@GetMapping("/getrainghotelid/{id}")
	public ResponseEntity<List<Rating>> getHotelByHotelId(@PathVariable String id){
		List<Rating>  rating = ratingService.getAllRatingbyHoteId(id);
		return ResponseEntity.ok(rating);
	}

}
