package com.vivek.medical.repository;

import com.vivek.medical.model.BloodPressure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BloodPressureRepository extends MongoRepository<BloodPressure, String> {
    List<BloodPressure> findByUserId(String userId);
    Optional<BloodPressure> findTopByUserIdOrderByTimestampDesc(String userId);

}
