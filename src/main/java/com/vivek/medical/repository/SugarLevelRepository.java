package com.vivek.medical.repository;

import com.mongodb.client.MongoIterable;
import com.vivek.medical.model.SugarLevel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SugarLevelRepository extends MongoRepository<SugarLevel, String> {
    List<SugarLevel> findByUserId(String userId);

    Optional<SugarLevel> findTopByUserIdOrderByTimestampDesc(String userId);

}
