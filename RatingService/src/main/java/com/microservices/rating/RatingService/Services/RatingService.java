package com.microservices.rating.RatingService.Services;

import com.microservices.rating.RatingService.Entities.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all ratings
    List<Rating>  getRatings();

    List<Rating> getRatingsbyUserId(String userId);

    List<Rating> getRatingsbyHotelId(String hotelId);
}
