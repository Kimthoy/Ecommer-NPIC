package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Model;
import com.div.ecommerce.ecommerce.repository.BrandRepository;
import com.div.ecommerce.ecommerce.repository.ModelRepository;
import com.div.ecommerce.ecommerce.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }
    @Override
    public Model create(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model update(Long id, Model updateModel) {
        // Fetch the existing model by ID
        Model model = getById(id);

        // Update the model name
        model.setModel_name(updateModel.getModel_name());

        // Check if a new Brand is provided in the update request
        if (updateModel.getBrand() != null && updateModel.getBrand().getId() != null) {
            Brand brand = brandRepository.findById(updateModel.getBrand().getId())
                    .orElseThrow(() -> new RuntimeException("Brand not found with id " + updateModel.getBrand().getId()));
            model.setBrand(brand);
        }

        // Save and return the updated model
        return modelRepository.save(model);
    }

    @Override
    public Model delete(Long id) {
        Model deleteModel=modelRepository.findById(id).orElseThrow(()->new RuntimeException("ID not found!"));
        modelRepository.delete(deleteModel);
        return deleteModel;
    }

    @Override
    public Model getById(Long id) {
        Model getModel=modelRepository.findById(id).orElseThrow(()->new RuntimeException("ID not found!"));
        return getModel;
    }

    @Override
    public List<Model> getAll() {
        if (modelRepository == null) {
            throw new IllegalStateException("Model repository is not initialized.");
        }
        return modelRepository.findAll();
    }

}
