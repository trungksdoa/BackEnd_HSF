package com.koisystem.controllers;

import com.koisystem.dto.ApiResponse;
import com.koisystem.models.Farm;
import com.koisystem.models.KoiFish;
import com.koisystem.models.Tour;
import com.koisystem.services.FarmService;
import com.koisystem.services.KoiFishService;
import com.koisystem.services.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;
    private final KoiFishService koiFishService;
    private final TourService tourService;
    
    @GetMapping
    public ResponseEntity<ApiResponse> getAllFarms() {
        return ResponseEntity.ok(ApiResponse.success("Farms retrieved successfully", 
            farmService.getAllFarms()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getFarmById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Farm retrieved successfully", 
            farmService.getFarmById(id)));
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse> createFarm(@RequestBody Farm farm) {
        return ResponseEntity.ok(ApiResponse.success("Farm created successfully", 
            farmService.saveFarm(farm)));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateFarm(@PathVariable Long id, @RequestBody Farm farm) {
        farm.setId(id);
        return ResponseEntity.ok(ApiResponse.success("Farm updated successfully", 
            farmService.saveFarm(farm)));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteFarm(@PathVariable Long id) {
        farmService.deleteFarm(id);
        return ResponseEntity.ok(ApiResponse.success("Farm deleted successfully", null));
    }

    @GetMapping("/{id}/koi-fish")
    public ResponseEntity<ApiResponse> getKoiFishByFarm(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Koi fish retrieved successfully", 
            koiFishService.getKoiFishByFarm(id)));
    }

    @GetMapping("/{id}/tours") 
    public ResponseEntity<ApiResponse> getToursByFarm(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Tours retrieved successfully", 
            tourService.getToursByFarm(id)));
    }
}
