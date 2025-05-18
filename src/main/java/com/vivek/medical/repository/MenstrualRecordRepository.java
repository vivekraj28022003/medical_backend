package com.vivek.medical.repository;

import com.vivek.medical.model.MenstrualRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenstrualRecordRepository extends MongoRepository<MenstrualRecord, String> {
    List<MenstrualRecord> findByUserId(String userId);
    Optional<MenstrualRecord> findTopByUserIdOrderByStartDateDesc(String userId);

}
