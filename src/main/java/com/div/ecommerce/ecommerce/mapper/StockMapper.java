package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.StockDTO;
import com.div.ecommerce.ecommerce.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper {
    StockMapper INSTANCE= Mappers.getMapper(StockMapper.class);
    Stock toStockEntity(StockDTO stockDTO);
    StockDTO toStockDTOEntity(Stock stock);
}
