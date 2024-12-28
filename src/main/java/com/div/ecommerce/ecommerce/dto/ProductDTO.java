package com.div.ecommerce.ecommerce.dto;

import com.div.ecommerce.ecommerce.model.*;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class ProductDTO {
    private Long id;
    private String code;
    private String name;
    private String price;
    private String size;
    private String quantity;
    private String image;
    private String description;
    private Timestamp addedToStock;
    private Category category;
    private Boolean status;
    private Brand brand;
    private Model model;
    private User createdBy;
    private Timestamp createdAt;
    private Supplier supplier;
}

