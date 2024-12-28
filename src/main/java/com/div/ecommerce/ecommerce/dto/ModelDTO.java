package com.div.ecommerce.ecommerce.dto;

import com.div.ecommerce.ecommerce.model.Brand;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ModelDTO {
    private Long id;
    private String model_name;
    private Brand brand;
}
