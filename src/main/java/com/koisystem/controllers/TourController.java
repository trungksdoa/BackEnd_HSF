package com.koisystem.controllers;

import com.koisystem.dto.ApiResponse;
import com.koisystem.models.Tour;
import com.koisystem.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tours")
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;
    
    @GetMapping("/upcoming")
    public ResponseEntity<ApiResponse> getUpcomingTours() {
        return ResponseEntity.ok(ApiResponse.success("Upcoming tours retrieved successfully", 
            tourService.getUpcomingTours()));
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse> createTour(@RequestBody Tour tour) {
        return ResponseEntity.ok(ApiResponse.success("Tour created successfully", 
            tourService.saveTour(tour)));
    }
}
