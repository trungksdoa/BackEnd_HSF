package com.koisystem.models;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "koi_purchases")
public class KoiPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime purchaseDate;
    private BigDecimal price;
    private BigDecimal depositAmount;
    private LocalDateTime expectedDeliveryDate;
    private String status; // ORDERED, IN_TRANSIT, DELIVERED
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "koi_fish_id")
    private KoiFish koiFish;
    
    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;
}
