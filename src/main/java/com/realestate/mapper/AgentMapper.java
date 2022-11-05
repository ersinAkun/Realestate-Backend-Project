package com.realestate.mapper;

import java.util.List;

import org.mapstruct.Mapping;

import com.realestate.domain.Agent;
import com.realestate.dto.AgentDTO;
import com.realestate.dto.request.AgentRequestDTO;

public interface AgentMapper {

	//agent AgentDTO ya cevirme
	AgentDTO agentToAgentDTO(Agent agent);
	
	@Mapping(target="id", ignore=true)
	Agent agentDTOToAgent(AgentRequestDTO agentRequestDTO);
	
	List<AgentDTO> agentListToAgentDTOList(List<Agent>agentList);
	
}
