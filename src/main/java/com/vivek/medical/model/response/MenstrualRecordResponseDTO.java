package com.vivek.medical.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MenstrualRecordResponseDTO {
    private String id;
    private String userId;
    private LocalDate startDate;
    private int duration;
    private String notes;
}
