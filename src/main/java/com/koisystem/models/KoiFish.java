package com.koisystem.models;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "koi_fishes")
public class KoiFish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String variety;
    private String size;
    private BigDecimal price;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;
}
