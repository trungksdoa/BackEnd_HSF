package com.koisystem.models;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String orderNumber;
    private LocalDateTime orderDate;
    @Column(nullable = false)
    private String status; // Possible values: PENDING, PROCESSING, COMPLETED, CANCELLED
    private BigDecimal totalAmount;
    private String specialRequests;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserInfo customer;
    
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<KoiPurchase> koiPurchases;
    
    /**
     * List of feedbacks for this order.
     * Feedbacks can only be added when order status is COMPLETED.
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    /**
     * Adds a feedback to the order if the order is completed.
     * @param feedback The feedback to add
     * @throws IllegalStateException if order is not completed
     */
    public void addFeedback(Feedback feedback) {
        if (!"COMPLETED".equals(this.status)) {
            throw new IllegalStateException("Cannot add feedback to non-completed order");
        }
        feedback.setOrder(this);
        this.feedbacks.add(feedback);
    }
}
