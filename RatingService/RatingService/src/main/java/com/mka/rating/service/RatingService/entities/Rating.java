package com.mka.rating.service.RatingService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "micro_ratings")
public class Rating {
	@Id
	private String ratingID;
	private String userID;
	private String hotelID;
	private int rating;
	private String feedbak;
	@Transient
	private Hotel hotel;
	
	public Rating() {
		super();
	}

	public Rating(String ratingID, String userID, String hotelID, int rating, String feedbak, Hotel hotel) {
		super();
		this.ratingID = ratingID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.rating = rating;
		this.feedbak = feedbak;
		this.hotel = hotel;
	}

	public String getRatingID() {
		return ratingID;
	}

	public void setRatingID(String ratingID) {
		this.ratingID = ratingID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedbak() {
		return feedbak;
	}

	public void setFeedbak(String feedbak) {
		this.feedbak = feedbak;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	

}
