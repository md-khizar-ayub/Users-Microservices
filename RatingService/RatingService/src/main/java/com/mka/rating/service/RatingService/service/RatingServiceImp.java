package com.mka.rating.service.RatingService.service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mka.rating.service.RatingService.entities.Hotel;
import com.mka.rating.service.RatingService.entities.Rating;
import com.mka.rating.service.RatingService.exception.ResourceNotFoundException;
import com.mka.rating.service.RatingService.repository.RatingRapository;
@Service
public class RatingServiceImp implements RatingService{

	@Autowired
	RatingRapository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Rating craeteRating(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingID(ratingId);
		Rating createdRating = repository.save(rating);
		
		return createdRating;
	}

	@Override
	public List<Rating> getAllRating() {
		List<Rating> rating = repository.findAll();
		rating = rating.stream().map(r ->{
			try {
				//fetch from hotel 
				//http://HOTEL-SERVICE/gethotel/04d24a7c-c387-42c9-a81f-9e085eef0ee3
				Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotelservice/gethotel/"+r.getHotelID(), Hotel.class);
				r.setHotel(hotel);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return r;
		}).collect(Collectors.toList());
		return rating;
	}

	@Override
	public Rating getRatingById(String id) {
		return  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
	}

	@Override
	public List<Rating> getAllRatingbyUserId(String userId) {
		List<Rating> rating = repository.findByuserID(userId);
		
		rating = rating.stream().map(r ->{
			try {
				//fetch from hotel 
				//http://HOTEL-SERVICE/gethotel/04d24a7c-c387-42c9-a81f-9e085eef0ee3
				Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotelservice/gethotel/"+r.getHotelID(), Hotel.class);
				r.setHotel(hotel);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return r;
		}).collect(Collectors.toList());
		return rating;
	}

	@Override
	public List<Rating> getAllRatingbyHoteId(String hotelId) {
		
		return repository.findByhotelID(hotelId);
	}

}
