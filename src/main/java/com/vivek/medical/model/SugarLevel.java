package com.vivek.medical.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "sugar")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SugarLevel {
    @Id
    private String id;
    private String userId;
    private LocalDateTime timestamp;
    private double level; // in mg/dL or mmol/L
    private String condition; // fasting, post-meal, etc.
}
