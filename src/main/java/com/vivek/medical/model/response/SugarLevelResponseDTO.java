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
public class SugarLevelResponseDTO {
    private String id;
    private String userId;
    private LocalDateTime timestamp;
    private double level;
    private String condition;
}
