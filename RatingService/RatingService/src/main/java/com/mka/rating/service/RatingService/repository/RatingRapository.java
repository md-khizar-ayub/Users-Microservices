package com.mka.rating.service.RatingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mka.rating.service.RatingService.entities.Rating;

@Repository
public interface RatingRapository extends JpaRepository<Rating, String> {

		List<Rating> findByuserID(String userID);
		List<Rating> findByhotelID(String hotelID);
	
}
