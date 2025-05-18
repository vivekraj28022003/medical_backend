package com.vivek.medical.controller;

import com.vivek.medical.model.request.MedicalDocumentRequestDTO;
import com.vivek.medical.model.response.MedicalDocumentResponseDTO;
import com.vivek.medical.service.MedicalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/medical-documents")
public class MedicalDocumentController {


    private final MedicalDocumentService docService;

    public MedicalDocumentController(MedicalDocumentService docService) {
        this.docService = docService;
    }

    @PostMapping
    public ResponseEntity<MedicalDocumentResponseDTO> addDocument(@RequestBody MedicalDocumentRequestDTO dto) {
        return ResponseEntity.ok(docService.addDocument(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MedicalDocumentResponseDTO>> getUserDocuments(@PathVariable String userId) {
        return ResponseEntity.ok(docService.getByUserId(userId));
    }
}
