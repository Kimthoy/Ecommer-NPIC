package com.div.ecommerce.ecommerce.dto;

import com.div.ecommerce.ecommerce.model.Product;
import com.div.ecommerce.ecommerce.model.Supplier;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class StockDTO {
    private Long id;
    private Product product;
    private String location;
    private int quantity;
    private Double price;
    private Timestamp lastUpdated;
}
