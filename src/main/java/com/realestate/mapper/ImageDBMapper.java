package com.realestate.mapper;

import java.util.List;

import org.mapstruct.Mapping;

import com.realestate.domain.ImageDB;
import com.realestate.dto.ImageDBDTO;

public interface ImageDBMapper {

	//ImageDB pojoyu-->ImageDBDTO ya çevirme	
	ImageDBDTO imageDBToImageDBDTO (ImageDB imageDB);
	
	//ImageDBDTO   yu   ImageDB pojoya çevirme
	@Mapping(target="id",ignore=true)
	ImageDB imageDBDTOToImageDB(ImageDBDTO imageDBDTO);
	
	//ImageDB List'i ImageDBDTO List'e çevirme
	List<ImageDBDTO> imageDBToImageDBDTOList(List<ImageDB> imageDB);
}
