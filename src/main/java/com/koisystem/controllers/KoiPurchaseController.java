package com.koisystem.controllers;

import com.koisystem.dto.ApiResponse;
import com.koisystem.models.KoiPurchase;
import com.koisystem.services.KoiPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
public class KoiPurchaseController {
    private final KoiPurchaseService koiPurchaseService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<ApiResponse> getPurchasesByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(ApiResponse.success("Purchases retrieved successfully", 
            koiPurchaseService.getPurchasesByOrder(orderId)));
    }

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<ApiResponse> getPurchasesByFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(ApiResponse.success("Purchases retrieved successfully", 
            koiPurchaseService.getPurchasesByFarm(farmId)));
    }

    @GetMapping("/koi/{koiFishId}")
    public ResponseEntity<ApiResponse> getPurchasesByKoiFish(@PathVariable Long koiFishId) {
        return ResponseEntity.ok(ApiResponse.success("Purchases retrieved successfully", 
            koiPurchaseService.getPurchasesByKoiFish(koiFishId)));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse> getPurchasesByStatus(@PathVariable String status) {
        return ResponseEntity.ok(ApiResponse.success("Purchases retrieved successfully", 
            koiPurchaseService.getPurchasesByStatus(status)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createPurchase(@RequestBody KoiPurchase purchase) {
        return ResponseEntity.ok(ApiResponse.success("Purchase created successfully", 
            koiPurchaseService.savePurchase(purchase)));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse> updatePurchaseStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(ApiResponse.success("Purchase status updated successfully", 
            koiPurchaseService.updatePurchaseStatus(id, status)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePurchase(@PathVariable Long id) {
        koiPurchaseService.deletePurchase(id);
        return ResponseEntity.ok(ApiResponse.success("Purchase deleted successfully", null));
    }
}
