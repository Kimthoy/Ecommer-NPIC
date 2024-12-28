package com.div.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand_name", length = 255)
    private String brand_name;

    @Column(name = "factory_date")
    private Timestamp factory_date;
}
