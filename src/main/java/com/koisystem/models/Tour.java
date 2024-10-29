package com.koisystem.models;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private Integer maxParticipants;
    private String imageUrl;
    private String status; // SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED
    private String guide;  // Tour guide name
    private String itinerary; // Detailed tour schedule

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;
}
