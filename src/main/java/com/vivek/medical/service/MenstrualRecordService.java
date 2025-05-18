package com.vivek.medical.service;

import com.vivek.medical.model.request.MenstrualRecordRequestDTO;
import com.vivek.medical.model.response.MenstrualRecordResponseDTO;

import java.util.List;

public interface MenstrualRecordService {

    MenstrualRecordResponseDTO addRecord(MenstrualRecordRequestDTO dto);
    List<MenstrualRecordResponseDTO> getByUserId(String userId);

    MenstrualRecordResponseDTO getLatestByUserId(String userId);
}
