package com.div.ecommerce.ecommerce.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private Timestamp createAt;
}
