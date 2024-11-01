package com.koisystem.services;

import com.koisystem.dto.ServiceResponse;
import com.koisystem.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManagementService {
    private final OrderService orderService;

    public ServiceResponse<List<Order>> getCustomerOrders(Long customerId) {
        try {
            List<Order> orders = orderService.getOrdersByCustomer(customerId);
            return ServiceResponse.success("Orders retrieved successfully", orders);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Order> createOrder(Order order) {
        try {
            Order savedOrder = orderService.createOrder(order);
            return ServiceResponse.success("Order created successfully", savedOrder);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<List<Order>> getOrdersByStatus(String status) {
        try {
            List<Order> orders = orderService.getOrdersByStatus(status);
            return ServiceResponse.success("Orders retrieved successfully", orders);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Order> updateOrder(Long id, Order order) {
        try {
            order.setId(id);
            Order updatedOrder = orderService.updateOrder(order);
            return ServiceResponse.success("Order updated successfully", updatedOrder);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }
} 