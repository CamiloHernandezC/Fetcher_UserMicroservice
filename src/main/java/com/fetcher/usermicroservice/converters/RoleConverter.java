package com.fetcher.usermicroservice.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fetcher.usermicroservice.DTO.RoleDTO;
import com.fetcher.usermicroservice.entities.Role;

@Service
public class RoleConverter {

	public RoleDTO toDTO(final Role Role) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Role, RoleDTO.class);
	}
	
	public List<RoleDTO> toDTO(final List<Role> Roles) {
		List<RoleDTO> resultDTO = new ArrayList<>();
		final ModelMapper modelMapper = new ModelMapper();
		for (Role Role : Roles) {
			resultDTO.add(modelMapper.map(Role, RoleDTO.class));
		}
		return resultDTO;
	}
	
	public Role toEntity(final RoleDTO dto) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Role.class);
	}
}
