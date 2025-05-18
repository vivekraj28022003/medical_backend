package com.vivek.medical.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "bp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BloodPressure {
    @Id
    private String id;
    private String userId;
    private LocalDateTime timestamp;
    private int systolic;
    private int diastolic;
    private int heartRate;
}
