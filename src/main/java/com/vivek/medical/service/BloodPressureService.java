package com.vivek.medical.service;

import com.vivek.medical.model.request.BloodPressureRequestDTO;
import com.vivek.medical.model.response.BloodPressureResponseDTO;

import java.util.List;

public interface BloodPressureService {
    BloodPressureResponseDTO addRecord(BloodPressureRequestDTO dto);
    List<BloodPressureResponseDTO> getByUserId(String userId);

    BloodPressureResponseDTO getLatestByUserId(String userId);

    void deleteBloodPressure(String id);
}
