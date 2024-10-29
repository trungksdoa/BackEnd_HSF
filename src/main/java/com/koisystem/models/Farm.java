package com.koisystem.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String description;
    
    @OneToMany(mappedBy = "farm")
    private List<KoiFish> koiFishes;
    
    @OneToMany(mappedBy = "farm")
    private List<Tour> tours;
}
