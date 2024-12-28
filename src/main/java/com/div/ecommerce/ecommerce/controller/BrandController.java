package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.BrandDTO;
import com.div.ecommerce.ecommerce.mapper.BrandMapper;
import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    private ResponseEntity<?>saveBrand(@RequestBody BrandDTO brandDTO){
        Brand savedBrand= BrandMapper.INSTANCE.toBrandEntity(brandDTO);
        brandService.create(savedBrand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(savedBrand));
    }
    @PutMapping("{id}")
    private ResponseEntity<?>updateBrand(@PathVariable("id") Long id,@RequestBody BrandDTO brandDTO){
        Brand updateBrand=BrandMapper.INSTANCE.toBrandEntity(brandDTO);
        brandService.update(id,updateBrand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updateBrand));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok( brandService.getAll());
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable("id") Long id){
        Brand searchBrand=brandService.getById(id);
        return ResponseEntity.ok(searchBrand);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<?>deleteBrand(@PathVariable("id") Long id){
        Brand deleteBrand=brandService.delete(id);
        return ResponseEntity.ok(deleteBrand);
    }

}
