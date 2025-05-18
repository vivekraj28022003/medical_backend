package com.vivek.medical.service.impl;

import com.vivek.medical.model.SugarLevel;
import com.vivek.medical.model.request.SugarLevelRequestDTO;
import com.vivek.medical.model.response.SugarLevelResponseDTO;
import com.vivek.medical.repository.SugarLevelRepository;
import com.vivek.medical.service.SugarLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SugarLevelServiceImpl implements SugarLevelService {

    @Autowired
    private final SugarLevelRepository sugarRepo;

    public SugarLevelServiceImpl(SugarLevelRepository sugarRepo) {
        this.sugarRepo = sugarRepo;
    }

    @Override
    public SugarLevelResponseDTO addRecord(SugarLevelRequestDTO dto) {
        SugarLevel s = new SugarLevel(null, dto.getUserId(), dto.getTimestamp(), dto.getLevel(), dto.getCondition());
        s = sugarRepo.save(s);
        return mapToResponse(s);
    }


    @Override
    public List<SugarLevelResponseDTO> getByUserId(String userId) {
        return sugarRepo.findByUserId(userId).stream().map(this::mapToResponse).toList();
    }

    @Override
    public SugarLevelResponseDTO getLatestByUserId(String userId) {
        SugarLevel sugar = sugarRepo.findTopByUserIdOrderByTimestampDesc(userId)
                .orElseThrow(() -> new RuntimeException("No sugar data found for user " + userId));

        return toResponseDTO(sugar);
    }


    public SugarLevelResponseDTO toResponseDTO(SugarLevel sugar) {
        SugarLevelResponseDTO dto = new SugarLevelResponseDTO();
        dto.setId(sugar.getId());
        dto.setUserId(sugar.getUserId());
        dto.setTimestamp(sugar.getTimestamp());
        dto.setLevel(sugar.getLevel());

        // Set condition based on sugar level
        double level = sugar.getLevel();
        if (level < 70) {
            dto.setCondition("Low");
        } else if (level <= 140) {
            dto.setCondition("Normal");
        } else {
            dto.setCondition("High");
        }
        return dto;
    }



    private SugarLevelResponseDTO mapToResponse(SugarLevel s) {
        return new SugarLevelResponseDTO(s.getId(), s.getUserId(), s.getTimestamp(), s.getLevel(), s.getCondition());
    }


    public void deleteSugarLevel(String id) {
        if (!sugarRepo.existsById(id)) {
            throw new RuntimeException("Sugar level record not found with id: " + id);
        }
        sugarRepo.deleteById(id);
    }
}
