package com.div.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment for the id
    private Long id;

    @Column(name = "model_name", length = 255)
    private String model_name;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_brand_id"))
    private Brand brand;
}
