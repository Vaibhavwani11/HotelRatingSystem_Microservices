package com.microservices.user.service.services;

import com.microservices.user.service.External.Services.HotelService;
import com.microservices.user.service.entities.Hotel;
import com.microservices.user.service.entities.Rating;
import com.microservices.user.service.entities.User;
import com.microservices.user.service.exception.ResourceNotFoundException;
import com.microservices.user.service.repositories.UserRepository;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //Calling the Rating Service using 'RestTemplate' class
    @Autowired
    private RestTemplate restTemplate;

    private Logger logger;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {

        //generate unique userId
        //String randomUserId = UUID.randomUUID().toString();
//        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        //implement rating service call using RestTemplate class
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        //get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User with given Id is not found on the server: "+userId));

        //fetch rating of the above user from Rating Service
        //fetch from url: http://localhost:8092/Ratings/users/userId
        //Writing ArrayList as ratings are in arrayList format
        Rating[] ratingsOfUser =  restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
//        logger.info("{}",ratingsOfUsers);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        System.out.println(ratings);

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

//            System.out.println(rating.getHotelId());
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
//            Hotel hotel = forEntity.getBody();

    //IMPLEMENTING DECLARATIVE APPROACH USING FEIGN CLIENT
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            System.out.println("Response status Code :  "+forEntity.getStatusCode());

            rating.setHotel(hotel);
            return rating;

        }).collect(Collectors.toList());
        System.out.println(ratingList);

        user.setRatings(ratingList);

        return user;
    }
}
