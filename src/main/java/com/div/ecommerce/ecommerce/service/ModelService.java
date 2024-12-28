package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Model;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {
    Model create(Model model);
    Model update(Long id,Model updateModel);
    Model delete(Long id);
    Model getById(Long id);
    List<Model>getAll();

}
