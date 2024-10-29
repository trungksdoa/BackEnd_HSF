package com.koisystem.controllers;

import com.koisystem.dto.ApiResponse;
import com.koisystem.models.Feedback;
import com.koisystem.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<ApiResponse> getFeedbackByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(ApiResponse.success("Feedback retrieved successfully", 
            feedbackService.getFeedbackByOrder(orderId)));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ApiResponse> getFeedbackByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(ApiResponse.success("Feedback retrieved successfully", 
            feedbackService.getFeedbackByCustomer(customerId)));
    }

    @GetMapping("/rating/{minRating}")
    public ResponseEntity<ApiResponse> getHighRatedFeedback(@PathVariable Integer minRating) {
        return ResponseEntity.ok(ApiResponse.success("Feedback retrieved successfully", 
            feedbackService.getHighRatedFeedback(minRating)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createFeedback(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(ApiResponse.success("Feedback created successfully", 
            feedbackService.saveFeedback(feedback)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok(ApiResponse.success("Feedback deleted successfully", null));
    }
}
