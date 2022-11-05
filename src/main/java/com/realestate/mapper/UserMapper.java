package com.realestate.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.realestate.domain.User;
import com.realestate.dto.UserDTO;
import com.realestate.dto.request.UserRequestDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	// User pojo yu UserDTO' ya cevirme
	UserDTO userToUserDTO(User user);
	
	//userRequestDTO  yu User  pojo'ya cevirme
	@Mapping(target="id", ignore=true)
	User userRequestDTOToUser(UserRequestDTO userRequestDTO);
	
	//UsrList' i userDTOList' e cevirme
	List<UserDTO> userListToUserDTOList(List<User> userList);
	
}
