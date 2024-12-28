package com.div.ecommerce.ecommerce.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class BrandDTO {
    private Long id;
    private String brand_name;
    private Timestamp factory_date;
}
