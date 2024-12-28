package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.BrandDTO;
import com.div.ecommerce.ecommerce.dto.CategoryDTO;
import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category toCategoryEntity(CategoryDTO categoryDTO);
    CategoryDTO toCategoryDTOEntity(Category category);
}
