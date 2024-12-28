package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.BrandDTO;
import com.div.ecommerce.ecommerce.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    Brand toBrandEntity(BrandDTO brandDTO);
    BrandDTO toBrandDTO(Brand brand);
}
