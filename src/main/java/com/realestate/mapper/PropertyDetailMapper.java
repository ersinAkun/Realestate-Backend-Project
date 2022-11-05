package com.realestate.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.realestate.domain.PropertyDetail;
import com.realestate.dto.PropertyDetailDTO;
import com.realestate.dto.request.PropertyDetailRequestDTO;

@Mapper(componentModel = "spring") 
public interface PropertyDetailMapper {
	
	
	   PropertyDetailDTO propertyDetailToPropertyDetailDTO(PropertyDetail propertyDetail);
	   
	   @Mapping(target="id",ignore=true)
	   PropertyDetail propertyDetailDTOToPropertyDetail(PropertyDetailRequestDTO propertyDetailRequestDTO);
	   
	   List<PropertyDetailDTO> propertyDetailListPropertyDetailDTOList(List<PropertyDetail> propertyDetail);
}
