package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.OrderDetailDTO;
import com.div.ecommerce.ecommerce.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE= Mappers.getMapper(OrderDetailMapper.class);
    OrderDetail toOrderDetailEntity(OrderDetailDTO orderDetailDTO);
    OrderDetailDTO toOrderDetailDTOEntity(OrderDetail orderDetail);
}
