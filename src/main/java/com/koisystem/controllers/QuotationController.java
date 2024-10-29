package com.koisystem.controllers;

import com.koisystem.dto.ApiResponse;
import com.koisystem.models.Quotation;
import com.koisystem.services.QuotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quotations")
@RequiredArgsConstructor
public class QuotationController {
    private final QuotationService quotationService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<ApiResponse> getQuotationsByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(ApiResponse.success("Quotations retrieved successfully", 
            quotationService.getQuotationsByOrder(orderId)));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse> getQuotationsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(ApiResponse.success("Quotations retrieved successfully", 
            quotationService.getQuotationsByStatus(status)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createQuotation(@RequestBody Quotation quotation) {
        return ResponseEntity.ok(ApiResponse.success("Quotation created successfully", 
            quotationService.saveQuotation(quotation)));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse> updateQuotationStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(ApiResponse.success("Quotation status updated successfully", 
            quotationService.updateQuotationStatus(id, status)));
    }
}
