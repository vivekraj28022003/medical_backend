package com.vivek.medical.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BloodPressureRequestDTO {
    private String userId;
    private LocalDateTime timestamp;
    private int systolic;
    private int diastolic;
    private int heartRate;

}