package com.example.tangthu_app_be.repo.mongorepo;

import com.example.tangthu_app_be.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
