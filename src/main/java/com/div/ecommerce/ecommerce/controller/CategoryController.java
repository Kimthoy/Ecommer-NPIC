package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.CategoryDTO;
import com.div.ecommerce.ecommerce.mapper.CategoryMapper;
import com.div.ecommerce.ecommerce.model.Category;
import com.div.ecommerce.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    private ResponseEntity<?>createCategory(@RequestBody CategoryDTO categoryDTO){
        Category savedCategory= CategoryMapper.INSTANCE.toCategoryEntity(categoryDTO);
        categoryService.create(savedCategory);
        return ResponseEntity.ok(CategoryMapper.INSTANCE.toCategoryDTOEntity(savedCategory));
    }
    @PutMapping("{id}")
    private ResponseEntity<?>updateCategory(@PathVariable("id") Long id,
                                            @RequestBody CategoryDTO categoryDTO)
    {
        Category updatedCategory=CategoryMapper.INSTANCE.toCategoryEntity(categoryDTO);
        categoryService.update(id,updatedCategory);
        return ResponseEntity.ok(CategoryMapper.INSTANCE.toCategoryDTOEntity(updatedCategory));
    }
    @DeleteMapping("{id}")
    private ResponseEntity<?>deleteCategory(@PathVariable("id")Long id){
        return ResponseEntity.ok(categoryService.delete(id));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok( categoryService.getAll());
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable("id")Long id){
        Category getById=categoryService.getById(id);
        return ResponseEntity.ok(getById);
    }
}
