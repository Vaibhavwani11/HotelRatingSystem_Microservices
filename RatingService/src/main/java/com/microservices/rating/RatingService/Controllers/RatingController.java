package com.microservices.rating.RatingService.Controllers;

import com.microservices.rating.RatingService.Entities.Rating;
import com.microservices.rating.RatingService.Services.RatingService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor

@RestController //IMPORTANT ANNOTATION 
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //getall ratings of user
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){

        return ResponseEntity.ok(ratingService.getRatings());
    }

    //get Ratings with UserId
    @GetMapping("users/{UserId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("UserId") String UserId){

        System.out.println(ratingService.getRatingsbyUserId(UserId));
        return ResponseEntity.ok(ratingService.getRatingsbyUserId(UserId));
    }

    //getHotelId
    @GetMapping("hotels/{HotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String HotelId){

        return ResponseEntity.ok(ratingService.getRatingsbyHotelId(HotelId));
    }

}
