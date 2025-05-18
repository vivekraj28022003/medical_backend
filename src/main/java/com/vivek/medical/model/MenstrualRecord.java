package com.vivek.medical.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "menstrual")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenstrualRecord {
    @Id
    private String id;
    private String userId;
    private LocalDate startDate;
    private int duration; // in days
    private String notes;
}
