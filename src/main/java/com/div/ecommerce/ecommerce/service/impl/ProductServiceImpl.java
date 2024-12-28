package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.model.*;
import com.div.ecommerce.ecommerce.repository.*;
import com.div.ecommerce.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Value("${upload.path}") // Path where images will be saved (configured in application.properties)
    private String uploadPath;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product updatedProduct = getById(id);

        // Update fields
        updatedProduct.setCode(product.getCode());
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setSize(product.getSize());
        updatedProduct.setQuantity(product.getQuantity());
        updatedProduct.setImage(product.getImage());
        updatedProduct.setAddedToStock(product.getAddedToStock());
        updatedProduct.setStatus(product.getStatus());
        updatedProduct.setCreatedAt(product.getCreatedAt());

        // Update associated entities
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new RuntimeException("Category not found with id " + product.getCategory().getId()));
            updatedProduct.setCategory(category);
        }

        if (product.getBrand() != null && product.getBrand().getId() != null) {
            Brand brand = brandRepository.findById(product.getBrand().getId())
                    .orElseThrow(() -> new RuntimeException("Brand not found with id " + product.getBrand().getId()));
            updatedProduct.setBrand(brand);
        }

        if (product.getModel() != null && product.getModel().getId() != null) {
            Model model = modelRepository.findById(product.getModel().getId())
                    .orElseThrow(() -> new RuntimeException("Model not found with id " + product.getModel().getId()));
            updatedProduct.setModel(model);
        }

        if (product.getSupplier() != null && product.getSupplier().getId() != null) {
            Supplier supplier = supplierRepository.findById(product.getSupplier().getId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found with id " + product.getSupplier().getId()));
            updatedProduct.setSupplier(supplier);
        }

        if (product.getCreatedBy() != null && product.getCreatedBy().getId() != null) {
            User user = userRepository.findById(product.getCreatedBy().getId())
                    .orElseThrow(() -> new RuntimeException("User not found with id " + product.getCreatedBy().getId()));
            updatedProduct.setCreatedBy(user);
        }

        // Save updated product
        return productRepository.save(updatedProduct);
    }


    @Override
    public Product delete(Long id) {
        Product deleteProduct=getById(id);
        productRepository.delete(deleteProduct);
        return deleteProduct;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("ID not found "));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }


}
