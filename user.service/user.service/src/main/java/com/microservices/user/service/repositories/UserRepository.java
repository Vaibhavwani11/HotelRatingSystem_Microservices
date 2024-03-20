package com.microservices.user.service.repositories;

import com.microservices.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//class name and data type of the primary key(Id)
public interface UserRepository extends JpaRepository<User, String> {


}
