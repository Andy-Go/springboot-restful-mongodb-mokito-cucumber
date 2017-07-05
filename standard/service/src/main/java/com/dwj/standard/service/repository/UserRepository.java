package com.dwj.standard.service.repository;


import com.dwj.standard.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
