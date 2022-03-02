package com.fetcher.usermicroservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fetcher.usermicroservice.DTO.UserDTO;
import com.fetcher.usermicroservice.converters.UserConverter;
import com.fetcher.usermicroservice.repositories.UserRepository;
import com.fetcher.usermicroservice.services.interfaces.UserServiceInterface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface{

	private final UserRepository repository;
	private final UserConverter converter;
	
	@Override
	public List<UserDTO> all() {
		return converter.toDTO(repository.findAll());
	}

}
