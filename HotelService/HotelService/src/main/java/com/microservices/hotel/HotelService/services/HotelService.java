package com.microservices.hotel.HotelService.services;

import com.microservices.hotel.HotelService.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getAll();

    //getSingle
    Hotel get(String id);
}
