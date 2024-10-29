package com.koisystem.controllers;

import com.koisystem.dto.ApiResponse;
import com.koisystem.models.Order;
import com.koisystem.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ApiResponse> getCustomerOrders(@PathVariable Long customerId) {
        List<Order> orders = orderService.getOrdersByCustomer(customerId);
        return ResponseEntity.ok(ApiResponse.success("Orders retrieved successfully", orders));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(ApiResponse.success("Order created successfully", savedOrder));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse> getOrdersByStatus(@PathVariable String status) {
        List<Order> orders = orderService.getOrdersByStatus(status);
        return ResponseEntity.ok(ApiResponse.success("Orders retrieved successfully", orders));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        Order updatedOrder = orderService.updateOrder(order);
        return ResponseEntity.ok(ApiResponse.success("Order updated successfully", updatedOrder));
    }

//    @GetMapping("/stats")
//    public ResponseEntity<Map<String, Object>> getDashboardStats() {
//        Map<String, Object> stats = orderService.getDashboardStats();
//        return ResponseEntity.ok(stats);
//    }
//
//    @GetMapping("/monthly-revenue")
//    public ResponseEntity<List<Map<String, Object>>> getMonthlyRevenue() {
//        List<Map<String, Object>> revenue = orderService.getMonthlyRevenue();
//        return ResponseEntity.ok(revenue);
//    }
}
