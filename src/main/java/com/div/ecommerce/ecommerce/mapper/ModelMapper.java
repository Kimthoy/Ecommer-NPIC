package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.BrandDTO;
import com.div.ecommerce.ecommerce.dto.ModelDTO;
import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
    Model toModelEntity(ModelDTO modelDTO);
    ModelDTO toModelDTOEntity(Model model);
}
