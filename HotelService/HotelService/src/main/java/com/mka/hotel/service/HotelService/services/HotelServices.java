package com.mka.hotel.service.HotelService.services;

import java.util.List;


import com.mka.hotel.service.HotelService.entities.Hotel;


public interface HotelServices {
	
	
	
	//create
	public Hotel createHotel(Hotel hotel);
	
	
	//getall
	
	public List<Hotel> getAllHotel();
	
	//getsingle
	
	public Hotel getHotelById(String hotelId);
}
