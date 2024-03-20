package com.microservices.rating.RatingService.Repository;

import com.microservices.rating.RatingService.Entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//IMPORTANT w.r.t DB
//No-SQL Database mdhe intead of CRUDRepository | JPARepository, we need to use "MongoRepository<T,ID>"
public interface RatingRepository extends MongoRepository<Rating, String> {

    //Custom Finder methods
    //aplya requirement nusar:

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
