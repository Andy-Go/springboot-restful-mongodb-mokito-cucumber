package com.accenture.standard.service.repository;


import com.accenture.standard.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
