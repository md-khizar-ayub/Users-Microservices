package com.mka.hotel.service.HotelService.controller;

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

import com.mka.hotel.service.HotelService.entities.Hotel;
import com.mka.hotel.service.HotelService.services.HotelServices;

@RestController
@RequestMapping("/hotelservice")
public class HotelController {
	
	@Autowired
	private HotelServices hotelServices;
	
	//create
	@PostMapping("/createhotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		System.out.println(hotel);
		Hotel createdHotel = hotelServices.createHotel(hotel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
		
	}
	@GetMapping("/getallhotel")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> allHotel = hotelServices.getAllHotel();
		return ResponseEntity.ok(allHotel);
	}
	
	@GetMapping("/gethotel/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
		Hotel Hotel = hotelServices.getHotelById(id);
		return ResponseEntity.ok(Hotel);
	}
	

}
