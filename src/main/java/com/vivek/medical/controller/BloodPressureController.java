package com.vivek.medical.controller;

import com.vivek.medical.model.request.BloodPressureRequestDTO;
import com.vivek.medical.model.response.BloodPressureResponseDTO;
import com.vivek.medical.service.BloodPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blood-pressure")
public class BloodPressureController {


    private final BloodPressureService bpService;

    public BloodPressureController(BloodPressureService bpService) {
        this.bpService = bpService;
    }

    @PostMapping
    public ResponseEntity<BloodPressureResponseDTO> addRecord(@RequestBody BloodPressureRequestDTO dto) {
        return ResponseEntity.ok(bpService.addRecord(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BloodPressureResponseDTO>> getUserHistory(@PathVariable String userId) {
        return ResponseEntity.ok(bpService.getByUserId(userId));
    }

    @GetMapping("/user/{userId}/latest")
    public ResponseEntity<BloodPressureResponseDTO> getLatestByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(bpService.getLatestByUserId(userId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodPressure(@PathVariable String id) {
        bpService.deleteBloodPressure(id);
        return ResponseEntity.noContent().build();
    }
}
