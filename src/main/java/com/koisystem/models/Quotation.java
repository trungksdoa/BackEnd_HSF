package com.koisystem.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "quotations")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String description;
    private String status;
    private LocalDateTime createdDate;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
