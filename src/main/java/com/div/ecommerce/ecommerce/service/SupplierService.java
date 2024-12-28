package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    Supplier create(Supplier supplier);
    Supplier update(Long id, Supplier supplier);
    Supplier getById(Long id);
    Supplier delete(Long id);
    List<Supplier>getAll();
}
