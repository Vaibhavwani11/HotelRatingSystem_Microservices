package com.microservices.hotel.HotelService.repositories;

import com.microservices.hotel.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//CrudRepository<Type, ID type> || JpaRepository<Type, ID type>
public interface HotelRepository extends JpaRepository<Hotel,String> {


}
