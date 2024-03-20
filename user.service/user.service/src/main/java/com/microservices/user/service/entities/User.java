package com.microservices.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name=" ID")
    private String userId;
    @Column(name = "Name")
    private String name;
    private String email;
    private String about;
    //all user properties

    @Transient //it will not be stored in database
    private List<Rating> ratings = new ArrayList<>(); //will be handled by communication. It will come from another microservice.
}
