package com.vivek.medical.repository;

import com.vivek.medical.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Add custom queries if needed, e.g.:
    User findByEmail(String email);
}
