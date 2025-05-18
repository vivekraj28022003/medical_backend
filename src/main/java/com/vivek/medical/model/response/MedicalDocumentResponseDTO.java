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

public class MedicalDocumentResponseDTO {
    private String id;
    private String userId;
    private String title;
    private LocalDate dateUploaded;
    private String fileUrl;
    private String type;
}
