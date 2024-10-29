package com.koisystem.services;

import com.koisystem.models.Order;
import com.koisystem.repositories.OrderRepository;
import com.koisystem.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    
    public Order createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("COMPLETED"); // Đơn hàng tự động hoàn thành
        return orderRepository.save(order);
    }
    
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new BusinessException("Order not found"));
    }
    
    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
    
    public Order updateOrder(Order order) {
        Order existingOrder = getOrderById(order.getId());
        existingOrder.setSpecialRequests(order.getSpecialRequests());
        return orderRepository.save(existingOrder);
    }
    
    /**
     * Lấy danh sách orders theo status
     * @param status trạng thái của order (PENDING, PROCESSING, COMPLETED, CANCELLED)
     * @return List<Order> danh sách các order có status tương ứng
     */
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }
}
