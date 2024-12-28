package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    Brand create(Brand createBrand);
    Brand update(Long id, Brand updateBrand);
    List<Brand>getAll();
    Brand delete(Long id);
    Brand getById(Long id);
}
