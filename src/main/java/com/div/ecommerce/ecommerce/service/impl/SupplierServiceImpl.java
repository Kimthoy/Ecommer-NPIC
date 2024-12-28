package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.div.ecommerce.ecommerce.model.Supplier;
import com.div.ecommerce.ecommerce.repository.SupplierRepository;
import com.div.ecommerce.ecommerce.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Long id, Supplier supplier) {
        Supplier updatedSupplier=getById(id);
        updatedSupplier.setName(supplier.getName());
        updatedSupplier.setPhone(supplier.getPhone());
        updatedSupplier.setAddress(supplier.getAddress());
        updatedSupplier.setEmail(supplier.getEmail());
        updatedSupplier.setCreateAt(supplier.getCreateAt());
        return supplierRepository.save(updatedSupplier);
    }

    @Override
    public Supplier getById(Long id) {
        return supplierRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ID not found! with id"+id));
    }

    @Override
    public Supplier delete(Long id) {
        Supplier deleteSupplier=getById(id);
        supplierRepository.delete(deleteSupplier);
        return deleteSupplier;
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }
}
