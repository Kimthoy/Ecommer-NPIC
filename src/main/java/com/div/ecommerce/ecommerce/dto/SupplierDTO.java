package com.div.ecommerce.ecommerce.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class SupplierDTO {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private Timestamp createAt;
}
