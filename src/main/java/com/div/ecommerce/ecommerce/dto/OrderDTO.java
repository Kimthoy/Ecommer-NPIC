package com.div.ecommerce.ecommerce.dto;

import com.div.ecommerce.ecommerce.model.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDTO {
    private Long id;
    private String status;
    private Timestamp orderDate;
    private Timestamp createAt;
    private Customer customer;
}
