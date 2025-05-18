package com.vivek.medical.controller;

import com.vivek.medical.model.request.SugarLevelRequestDTO;
import com.vivek.medical.model.response.SugarLevelResponseDTO;
import com.vivek.medical.service.SugarLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/sugar-level")
public class SugarLevelController {

    private final SugarLevelService sugarService;

    public SugarLevelController(SugarLevelService sugarService) {
        this.sugarService = sugarService;
    }

    @PostMapping
    public ResponseEntity<SugarLevelResponseDTO> addRecord(@RequestBody SugarLevelRequestDTO dto) {
        return ResponseEntity.ok(sugarService.addRecord(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SugarLevelResponseDTO>> getUserHistory(@PathVariable String userId) {
        return ResponseEntity.ok(sugarService.getByUserId(userId));
    }
    @GetMapping("/user/{userId}/latest")
    public ResponseEntity<SugarLevelResponseDTO> getLatestByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(sugarService.getLatestByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSugarLevel(@PathVariable String id) {
        sugarService.deleteSugarLevel(id);
        return ResponseEntity.noContent().build();
    }
}
