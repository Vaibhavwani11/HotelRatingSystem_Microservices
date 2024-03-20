package com.microservices.rating.RatingService.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.repository.NoRepositoryBean;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ratings")  //MongoDB mdhe @Document(collectionName) detat instead of @Table(name = "micro_users") in JPA
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
