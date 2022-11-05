package com.realestate.mapper;

import java.util.List;

import org.mapstruct.Mapping;

import com.realestate.domain.AgentImage;
import com.realestate.dto.AgentImageDTO;

public interface AgentImageMapper {

	
		//AgentImage pojoyu-->AgentImageDTO ya çevirme	
		AgentImageDTO agentImageToAgentImageDTO (AgentImage agentImage);
	
		//AgentImageDTO   yu   AgentImage pojoya çevirme
		@Mapping(target="id",ignore=true)
		AgentImage agentImageDTOToAgentImage (AgentImageDTO agentImageDTO);
	
		//AgentImage List'i AgentImageDTOList'e çevirme
		List<AgentImageDTO> agentImageToAgentImageDTOList(List<AgentImage> agentImage);	

}
