package com.vivek.medical.repository;

import com.vivek.medical.model.MedicalDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalDocumentRepository extends MongoRepository<MedicalDocument, String> {
    List<MedicalDocument> findByUserId(String userId);
}
