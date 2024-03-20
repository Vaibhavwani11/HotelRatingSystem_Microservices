package com.microservices.hotel.HotelService.services;

import com.microservices.hotel.HotelService.Exceptions.ResourceNotFoundException;
import com.microservices.hotel.HotelService.entities.Hotel;
import com.microservices.hotel.HotelService.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component // @Component | @Service annotation to use this class with @Autowired annotation
public class HotelServiceImpl implements  HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {

        String hotelId = UUID.randomUUID().toString();
//        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {

        System.out.println("In get method");
        System.out.println("ID ="+hotelRepository.findById(id)
        );
                                                                //This is custom Exception class created
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }
}
