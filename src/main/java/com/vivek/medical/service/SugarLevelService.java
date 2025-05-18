package com.vivek.medical.service;

import com.vivek.medical.model.request.SugarLevelRequestDTO;
import com.vivek.medical.model.response.SugarLevelResponseDTO;

import java.util.List;

public interface SugarLevelService {

    SugarLevelResponseDTO addRecord(SugarLevelRequestDTO dto);
    List<SugarLevelResponseDTO> getByUserId(String userId);

    SugarLevelResponseDTO getLatestByUserId(String userId);

    void deleteSugarLevel(String id);
}
