package com.microservices.user.service.controllers;

import com.microservices.user.service.entities.User;
import com.microservices.user.service.repositories.UserRepository;
import com.microservices.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

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
    public  ResponseEntity<User> getSingleUser(@PathVariable String userId){

        User user = userService.getUser(userId);
        return  ResponseEntity.ok(user);
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
