package com.vivek.medical.service.impl;

import com.vivek.medical.model.MenstrualRecord;
import com.vivek.medical.model.request.MenstrualRecordRequestDTO;
import com.vivek.medical.model.response.MenstrualRecordResponseDTO;
import com.vivek.medical.repository.MenstrualRecordRepository;
import com.vivek.medical.service.MenstrualRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenstrualRecordServiceImpl implements MenstrualRecordService {

    @Autowired
    private final MenstrualRecordRepository menstrualRepo;

    public MenstrualRecordServiceImpl(MenstrualRecordRepository menstrualRepo) {
        this.menstrualRepo = menstrualRepo;
    }

    @Override
    public MenstrualRecordResponseDTO addRecord(MenstrualRecordRequestDTO dto) {
        MenstrualRecord m = new MenstrualRecord(null, dto.getUserId(), dto.getStartDate(), dto.getDuration(), dto.getNotes());
        m = menstrualRepo.save(m);
        return mapToResponse(m);
    }

    @Override
    public List<MenstrualRecordResponseDTO> getByUserId(String userId) {
        return menstrualRepo.findByUserId(userId).stream().map(this::mapToResponse).toList();
    }

    private MenstrualRecordResponseDTO mapToResponse(MenstrualRecord m) {
        return new MenstrualRecordResponseDTO(m.getId(), m.getUserId(), m.getStartDate(), m.getDuration(), m.getNotes());
    }

    @Override
    public MenstrualRecordResponseDTO getLatestByUserId(String userId) {
        MenstrualRecord latest = menstrualRepo
                .findTopByUserIdOrderByStartDateDesc(userId)
                .orElseThrow(() -> new RuntimeException("No menstrual records found for user " + userId));

        return mapToResponse(latest);
    }


}
