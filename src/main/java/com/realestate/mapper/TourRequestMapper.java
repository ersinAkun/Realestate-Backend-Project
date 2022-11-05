package com.realestate.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.realestate.domain.TourRequest;
import com.realestate.dto.TourRequestDTO;
import com.realestate.dto.request.TourRequestRequestDTO;

@Mapper(componentModel = "spring")
public interface TourRequestMapper {

	/*
	 * AgentDTO agentToAgentDTO(Agent agent);
	
	
	@Mapping(target="id",ignore=true) 
	Agent agentDTOToAgent(AgentRequestDTO agentRequestDTO);
	
	
	List<AgentDTO> agentListToAgentDTOList(List<Agent> agentList);
	 */
	
	TourRequestDTO tourRequestToTourRequestDTO(TourRequest tourRequest);
	
	
	@Mapping(target="id",ignore=true) 
	TourRequest tourRequestDTOtoTourRequest(TourRequestRequestDTO tourRequestRequestDTO);
	
	
	List<TourRequestDTO> tourRequestListToTourRequestDTOList(List<TourRequest> tourRequestsList);
	
	
}
