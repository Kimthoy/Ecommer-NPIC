package com.div.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "stocks")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment for the id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_product_id"))
    private Product product;
    @Column(name = "location")
    private String location;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_supplier_id"))
    private Supplier supplier;

    @Column(name = "last_updated")
    private Timestamp lastUpdated;

}
