package com.vivek.medical.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class BloodPressureResponseDTO {
    private String id;
    private String userId;
    private LocalDateTime timestamp;
    private int systolic;
    private int diastolic;
    private int heartRate;
}
