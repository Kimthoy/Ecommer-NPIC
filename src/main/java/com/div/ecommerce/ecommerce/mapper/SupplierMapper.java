package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.SupplierDTO;
import com.div.ecommerce.ecommerce.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper {
    SupplierMapper INSTANCE= Mappers.getMapper(SupplierMapper.class);
    Supplier toSupplierEntity(SupplierDTO supplierDTO);
    SupplierDTO toSupplierDTOEntity(Supplier supplier);
}
