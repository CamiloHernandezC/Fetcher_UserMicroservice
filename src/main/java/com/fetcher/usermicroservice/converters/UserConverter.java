package com.fetcher.usermicroservice.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fetcher.usermicroservice.DTO.UserDTO;
import com.fetcher.usermicroservice.entities.User;

@Service
public class UserConverter {

	public UserDTO toDTO(final User User) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(User, UserDTO.class);
	}
	
	public List<UserDTO> toDTO(final List<User> Users) {
		List<UserDTO> resultDTO = new ArrayList<>();
		final ModelMapper modelMapper = new ModelMapper();
		for (User User : Users) {
			resultDTO.add(modelMapper.map(User, UserDTO.class));
		}
		return resultDTO;
	}
	
	public User toEntity(final UserDTO dto) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, User.class);
	}
}
