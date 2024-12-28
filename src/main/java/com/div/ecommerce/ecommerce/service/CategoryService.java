package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category create(Category category);
    Category update(Long id, Category category);
    Category getById(Long id);
    Category delete(Long id);
    List<Category>getAll();
}
