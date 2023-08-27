package com.mka.hotel.service.HotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mka.hotel.service.HotelService.Repository.HotelRepository;
import com.mka.hotel.service.HotelService.entities.Hotel;
import com.mka.hotel.service.HotelService.exception.ResourceNotFoundException;
@Service
public class HotelServicesImpl implements HotelServices{

	@Autowired
	private HotelRepository hotelRepository; 
	
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		System.out.println(hotel);
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		Hotel createdHotel = hotelRepository.save(hotel);
		return createdHotel;
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		
		return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Resource Not found Exception in hotel"));
	}

}
