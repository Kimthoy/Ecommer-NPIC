package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.CustomerDTO;
import com.div.ecommerce.ecommerce.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    Customer toCustomerEntity(CustomerDTO customerDTO);
    CustomerDTO toCustomerDTOEntity(Customer customer);
}
