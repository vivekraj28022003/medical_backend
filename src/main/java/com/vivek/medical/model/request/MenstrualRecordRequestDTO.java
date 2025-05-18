package com.vivek.medical.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenstrualRecordRequestDTO {
    private String userId;
    private LocalDate startDate;
    private int duration;
    private String notes;
}
