package com.vivek.medical.service;

import com.vivek.medical.model.request.MedicalDocumentRequestDTO;
import com.vivek.medical.model.response.MedicalDocumentResponseDTO;

import java.util.List;

public interface MedicalDocumentService {

    MedicalDocumentResponseDTO addDocument(MedicalDocumentRequestDTO dto);
    List<MedicalDocumentResponseDTO> getByUserId(String userId);
}
