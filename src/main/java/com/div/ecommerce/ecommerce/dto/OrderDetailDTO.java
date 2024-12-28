package com.div.ecommerce.ecommerce.dto;

import com.div.ecommerce.ecommerce.model.Order;
import com.div.ecommerce.ecommerce.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDetailDTO {
    private Long id;
    private Order order;
    private Product product;
    private int quantity;
    private Double price;
    private Timestamp createAt;
}
