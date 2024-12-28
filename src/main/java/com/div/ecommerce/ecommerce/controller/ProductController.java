package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.ProductDTO;
import com.div.ecommerce.ecommerce.mapper.ProductMapper;
import com.div.ecommerce.ecommerce.model.Product;
import com.div.ecommerce.ecommerce.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
   private ResponseEntity<?>savedProduct(@RequestBody ProductDTO productDTO){
        Product savedProduct=ProductMapper.INSTANCE.toProductEntity(productDTO);
        productService.create(savedProduct);
        return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTOEntity(savedProduct));
   }
   @PutMapping("{id}")
    private ResponseEntity<?>update(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        Product updatedProduct=ProductMapper.INSTANCE.toProductEntity(productDTO);
        productService.update(id,updatedProduct);
        return ResponseEntity.ok(ProductMapper.INSTANCE.toProductDTOEntity(updatedProduct));
   }
   @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable Long id){
        Product getById=productService.getById(id);
        return ResponseEntity.ok(getById);
   }
   @GetMapping("/")
    private ResponseEntity<?>getAll(){
        List<Product> getAll=productService.getAll();
        return ResponseEntity.ok(getAll);
   }
   @DeleteMapping("{id}")
    private ResponseEntity<?>delete(@PathVariable Long id){
        Product deletedProduct=productService.delete(id);
        return ResponseEntity.ok(deletedProduct);
   }



}
