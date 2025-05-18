package com.vivek.medical.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "medical_documents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalDocument {
    @Id
    private String id;
    private String userId;
    private String title;
    private LocalDate dateUploaded;
    private String fileUrl;
    private String type; // lab report, prescription, etc.
}
