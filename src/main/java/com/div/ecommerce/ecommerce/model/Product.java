package com.div.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment for the id
    private Long id;

    @Column(name = "code", length = 255)
    private String code;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "price", length = 255)
    private String price;

    @Column(name = "size", length = 50)
    private String size;

    @Column(name = "quantity", length = 50)
    private String quantity;

    @Column(name = "image", length = 255)
    private String image;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "added_to_stock")
    private Timestamp addedToStock;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_category_id"))
    private Category category;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_brand_id"))
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_model_id"))
    private Model model;


    @ManyToOne
    @JoinColumn(name = "create_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_create_by"))
    private User createdBy;

    @Column(name = "create_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id",foreignKey = @ForeignKey (name = "fk_supplier_id"))
    private Supplier supplier;
}
