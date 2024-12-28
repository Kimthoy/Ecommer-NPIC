package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.ModelDTO;
import com.div.ecommerce.ecommerce.mapper.ModelMapper;
import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Model;
import com.div.ecommerce.ecommerce.service.BrandService;
import com.div.ecommerce.ecommerce.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/model")
public class ModelController {
    @Autowired
    private ModelService modelService;
    private BrandService brandService;
    @PostMapping
    private ResponseEntity<?>createModel(@RequestBody ModelDTO modelDTO){
        Model createModel= ModelMapper.INSTANCE.toModelEntity(modelDTO);
        modelService.create(createModel);
        return ResponseEntity.ok(ModelMapper.INSTANCE.toModelDTOEntity(createModel));
    }
    @PutMapping("{id}")
    private ResponseEntity<?>updateModel(@PathVariable("id") Long id,@RequestBody ModelDTO modelDTO)
    {
       Model updatedModel=ModelMapper.INSTANCE.toModelEntity(modelDTO);
       modelService.update(id,updatedModel);
        return ResponseEntity.ok(ModelMapper.INSTANCE.toModelDTOEntity(updatedModel));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok(modelService.getAll());
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable("id") Long id){
        Model getModel=modelService.getById(id);
        return ResponseEntity.ok(getModel);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<?>deleteModel(@PathVariable("id") Long id){
        Model deleteModel=modelService.delete(id);
        return ResponseEntity.ok(deleteModel);
    }

}
