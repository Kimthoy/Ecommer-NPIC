package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.OrderDTO;
import com.div.ecommerce.ecommerce.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);
    Order toOrderEntity(OrderDTO orderDTO);
    OrderDTO toOrderDTOEntity(Order order);
}
