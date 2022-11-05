package com.realestate.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.realestate.domain.Property;
import com.realestate.dto.PropertyDTO;
import com.realestate.dto.request.PropertyRequestDTO;

@Mapper(componentModel = "spring") 
public interface PropertyMapper {
	
	
	
	   PropertyDTO propertyToPropertyDTO(Property property);
	   
	   @Mapping(target="id",ignore=true)
	   Property propertyDTOToProperty(PropertyRequestDTO propertyRequestDTO);
	   
	   List<PropertyDTO> propertyListPropertyDTOList(List<Property> property);
}
