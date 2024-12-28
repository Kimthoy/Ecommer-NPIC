package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.model.Category;
import com.div.ecommerce.ecommerce.repository.CategoryRepository;
import com.div.ecommerce.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Category updatedCategory=getById(id);
        updatedCategory.setName(category.getName());
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id not found!"));
    }

    @Override
    public Category delete(Long id) {
        Category deleteCategory=getById(id);
        categoryRepository.delete(deleteCategory);
        return deleteCategory;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
