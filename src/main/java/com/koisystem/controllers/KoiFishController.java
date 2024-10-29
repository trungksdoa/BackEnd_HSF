package com.koisystem.controllers;

import com.koisystem.dto.ApiResponse;
import com.koisystem.models.KoiFish;
import com.koisystem.services.KoiFishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/koi-fish")
@RequiredArgsConstructor
public class KoiFishController {
    private final KoiFishService koiFishService;

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<ApiResponse> getKoiFishByFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(ApiResponse.success("Koi fish retrieved successfully", 
            koiFishService.getKoiFishByFarm(farmId)));
    }

    @GetMapping("/variety/{variety}")
    public ResponseEntity<ApiResponse> getKoiFishByVariety(@PathVariable String variety) {
        return ResponseEntity.ok(ApiResponse.success("Koi fish retrieved successfully", 
            koiFishService.getKoiFishByVariety(variety)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createKoiFish(@RequestBody KoiFish koiFish) {
        return ResponseEntity.ok(ApiResponse.success("Koi fish created successfully", 
            koiFishService.saveKoiFish(koiFish)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateKoiFish(@PathVariable Long id, @RequestBody KoiFish koiFish) {
        koiFish.setId(id);
        return ResponseEntity.ok(ApiResponse.success("Koi fish updated successfully", 
            koiFishService.saveKoiFish(koiFish)));
    }
}
