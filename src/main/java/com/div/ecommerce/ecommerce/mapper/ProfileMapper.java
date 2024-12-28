package com.div.ecommerce.ecommerce.mapper;

import com.div.ecommerce.ecommerce.dto.BrandDTO;
import com.div.ecommerce.ecommerce.dto.ProfileDTO;
import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);
    Profile toProfileEntity(ProfileDTO profileDTO);
    ProfileDTO toProfileDTOEntity(Profile profile);
}
