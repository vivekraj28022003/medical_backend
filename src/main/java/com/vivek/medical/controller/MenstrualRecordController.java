package com.vivek.medical.controller;

import com.vivek.medical.model.request.MenstrualRecordRequestDTO;
import com.vivek.medical.model.response.MenstrualRecordResponseDTO;
import com.vivek.medical.service.MenstrualRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@RequestMapping("/api/menstrual")
public class MenstrualRecordController {


    private final MenstrualRecordService menstrualService;

    public MenstrualRecordController(MenstrualRecordService menstrualService) {
        this.menstrualService = menstrualService;
    }

    @PostMapping
    public ResponseEntity<MenstrualRecordResponseDTO> addRecord(@RequestBody MenstrualRecordRequestDTO dto) {
        return ResponseEntity.ok(menstrualService.addRecord(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MenstrualRecordResponseDTO>> getUserHistory(@PathVariable String userId) {
        return ResponseEntity.ok(menstrualService.getByUserId(userId));
    }

    @GetMapping("/user/{userId}/latest")
    public ResponseEntity<MenstrualRecordResponseDTO> getLatestByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(menstrualService.getLatestByUserId(userId));
    }

}
