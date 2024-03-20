package com.microservices.user.service.services;

import com.microservices.user.service.entities.User;

import java.util.List;

public interface UserService {

    //create
    User saveUser(User user);

    //get All Users

    List<User> getAllUsers();

    //get single user of given userId
    User getUser(String userId);

    //TODO:
    //delete

    //update
}
