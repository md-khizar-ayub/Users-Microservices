package com.mka.hotel.service.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mka.hotel.service.HotelService.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{

}
