package com.microservices.user.service;

import com.microservices.user.service.External.Services.RatingService;
import com.microservices.user.service.entities.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;
	void createRating(){

		//Using builder to directly create an object
		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using feign client").build();
		ratingService.createRating(rating);

		System.out.println(
				"New Rating Created"
		);
	}
}

