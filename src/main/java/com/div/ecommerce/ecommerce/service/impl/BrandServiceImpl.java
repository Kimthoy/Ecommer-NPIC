package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.repository.BrandRepository;
import com.div.ecommerce.ecommerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(Brand createBrand) {
        return brandRepository.save(createBrand);
    }

    @Override
    public Brand update(Long id, Brand updateBrand) {
        Brand brand=getById(id);
        brand.setId(updateBrand.getId());
        brand.setBrand_name(updateBrand.getBrand_name());
        brand.setFactory_date(updateBrand.getFactory_date());
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand delete(Long id) {
        Brand deleteBrand=getById(id);
        brandRepository.delete(deleteBrand);
        return deleteBrand;
    }

    @Override
    public Brand getById(Long id) {
        Brand brand=brandRepository.findById(id).orElseThrow(()->new RuntimeException("ID not found!"));
        return brand;
    }
}
