package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product create(Product product) ;
    Product update(Long id,Product product);
    Product delete(Long id);
    Product getById(Long id);
    List<Product>getAll();
}
