package com.realestate.mapper;

import java.util.List;

import org.mapstruct.Mapping;

import com.realestate.domain.Like;
import com.realestate.dto.LikeDTO;

public interface LikeMapper {

     
	//Like pojoyu-->LikeDTO ya çevirme	
	LikeDTO likeToLikeDTO (Like like);
	
	//LikeDTO   yu   Like pojoya çevirme
	@Mapping(target="id",ignore=true)
	Like likeDTOToLike(LikeDTO likeDTO);
	
	//AgentImage List'i AgentImageDTOList'e çevirme
	//		List<AgentImageDTO> agentImageToAgentImageDTO(List<AgentImage> agentImage);	
	List<LikeDTO> likeToLikeDTOList(List<Like> like);
}
