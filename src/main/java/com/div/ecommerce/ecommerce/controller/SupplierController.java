package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.SupplierDTO;
import com.div.ecommerce.ecommerce.mapper.SupplierMapper;
import com.div.ecommerce.ecommerce.model.Supplier;
import com.div.ecommerce.ecommerce.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @PostMapping
    private ResponseEntity<?>savedSupplier(@RequestBody SupplierDTO supplierDTO){
        Supplier savedSupplier= SupplierMapper.INSTANCE.toSupplierEntity(supplierDTO);
        supplierService.create(savedSupplier);
        return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTOEntity(savedSupplier));
    }
    @PutMapping("{id}")
    private ResponseEntity<?>updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO){
        Supplier updatedSupplier=SupplierMapper.INSTANCE.toSupplierEntity(supplierDTO);
        supplierService.update(id,updatedSupplier);
        return ResponseEntity.ok(SupplierMapper.INSTANCE.toSupplierDTOEntity(updatedSupplier));
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable Long id){
        return ResponseEntity.ok( supplierService.getById(id));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok(supplierService.getAll());
    }
    @DeleteMapping("{id}")
    private ResponseEntity<?>deleteSupplier(@PathVariable Long id){
        return ResponseEntity.ok(supplierService.delete(id));
    }
}
