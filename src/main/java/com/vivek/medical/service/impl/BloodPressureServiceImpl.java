package com.vivek.medical.service.impl;

import com.vivek.medical.model.BloodPressure;
import com.vivek.medical.model.request.BloodPressureRequestDTO;
import com.vivek.medical.model.response.BloodPressureResponseDTO;
import com.vivek.medical.repository.BloodPressureRepository;
import com.vivek.medical.service.BloodPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodPressureServiceImpl implements BloodPressureService {

    @Autowired

    private final BloodPressureRepository bpRepo;

    public BloodPressureServiceImpl(BloodPressureRepository bpRepo) {
        this.bpRepo = bpRepo;
    }

    @Override
    public BloodPressureResponseDTO addRecord(BloodPressureRequestDTO dto) {
        BloodPressure bp = new BloodPressure(null, dto.getUserId(), dto.getTimestamp(),
                dto.getSystolic(), dto.getDiastolic(), dto.getHeartRate());
        bp = bpRepo.save(bp);
        return mapToResponse(bp);
    }

    @Override
    public List<BloodPressureResponseDTO> getByUserId(String userId) {
        return bpRepo.findByUserId(userId).stream().map(this::mapToResponse).toList();
    }


    public BloodPressureResponseDTO getLatestByUserId(String userId) {
        Optional<BloodPressure> bpOpt = bpRepo.findTopByUserIdOrderByTimestampDesc(userId);
        if (bpOpt.isPresent()) {
            BloodPressure bp = bpOpt.get();
            return new BloodPressureResponseDTO(
                    bp.getId(),
                    bp.getUserId(),
                    bp.getTimestamp(),
                    bp.getSystolic(),
                    bp.getDiastolic(),
                    bp.getHeartRate()
            );
        }
        return null; // or throw an exception or return empty DTO as per your app logic
    }

    private BloodPressureResponseDTO mapToResponse(BloodPressure bp) {
        return new BloodPressureResponseDTO(bp.getId(), bp.getUserId(), bp.getTimestamp(),
                bp.getSystolic(), bp.getDiastolic(), bp.getHeartRate());
    }

    public void deleteBloodPressure(String id) {
        if (!bpRepo.existsById(id)) {
            throw new RuntimeException("Blood pressure record not found with id: " + id);
        }
        bpRepo.deleteById(id);
    }
}
