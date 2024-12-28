package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.ProductDTO;
import com.div.ecommerce.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product toProductEntity(ProductDTO productDTO);
    ProductDTO toProductDTOEntity(Product product);
}
