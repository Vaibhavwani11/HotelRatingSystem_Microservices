package com.microservices.user.service.controllers;

import com.microservices.user.service.entities.User;
import com.microservices.user.service.repositories.UserRepository;
import com.microservices.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {


//    private Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User user1 = userService.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get single user
    @GetMapping("/{userId}")

    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
//    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public  ResponseEntity<User> getSingleUser(@PathVariable String userId){

        User user = userService.getUser(userId);
        return  ResponseEntity.ok(user);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
//        logger.info("Fallback is executed because service is down");
        ex.printStackTrace();

        User user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down")
                .userId("141234")
                .build();
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);

    }
        //get all users
    @GetMapping
//    public  ResponseEntity<List<User>> getAllUsers() {
    public  List<User> getAllUsers() {

        List<User> allUser = userService.getAllUsers();
//        return ResponseEntity.ok(allUser);
        return allUser;
    }

    //update user
    @PutMapping("/{id}")
    public ResponseEntity<User> UpdateUser(@PathVariable("id") String id, @RequestBody User user){

        User user1 = userRepository.save(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }
}
