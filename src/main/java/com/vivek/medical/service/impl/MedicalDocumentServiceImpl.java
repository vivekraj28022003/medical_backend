package com.vivek.medical.service.impl;

import com.vivek.medical.model.MedicalDocument;
import com.vivek.medical.model.request.MedicalDocumentRequestDTO;
import com.vivek.medical.model.response.MedicalDocumentResponseDTO;
import com.vivek.medical.repository.MedicalDocumentRepository;
import com.vivek.medical.service.MedicalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDocumentServiceImpl implements MedicalDocumentService {


    @Autowired
    private final MedicalDocumentRepository docRepo;

    public MedicalDocumentServiceImpl(MedicalDocumentRepository docRepo) {
        this.docRepo = docRepo;
    }

    @Override
    public MedicalDocumentResponseDTO addDocument(MedicalDocumentRequestDTO dto) {
        MedicalDocument doc = new MedicalDocument(null, dto.getUserId(), dto.getTitle(),
                dto.getDateUploaded(), dto.getFileUrl(), dto.getType());
        doc = docRepo.save(doc);
        return mapToResponse(doc);
    }

    @Override
    public List<MedicalDocumentResponseDTO> getByUserId(String userId) {
        return docRepo.findByUserId(userId).stream().map(this::mapToResponse).toList();
    }

    private MedicalDocumentResponseDTO mapToResponse(MedicalDocument doc) {
        return new MedicalDocumentResponseDTO(doc.getId(), doc.getUserId(), doc.getTitle(),
                doc.getDateUploaded(), doc.getFileUrl(), doc.getType());
    }
}
