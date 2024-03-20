package com.microservices.rating.RatingService.Services;

import com.microservices.rating.RatingService.Entities.Rating;
import com.microservices.rating.RatingService.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsbyUserId(String userId) {

        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsbyHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);

    }
}
