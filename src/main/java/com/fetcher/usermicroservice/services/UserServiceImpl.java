package com.fetcher.usermicroservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fetcher.usermicroservice.DTO.UserDTO;
import com.fetcher.usermicroservice.converters.UserConverter;
import com.fetcher.usermicroservice.entities.User;
import com.fetcher.usermicroservice.exceptions.UserNotFoundException;
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

	@Override
	public Optional<UserDTO> findUserByUsername(String username) {
		Optional<User> user = repository.findByUsername(username);
		if(user.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(converter.toDTO(user.get()));
	}

	@Override
	public void deleteUserByUsername(String username) {
		repository.findByUsername(username).ifPresent(user -> repository.delete(user));
	}

	@Override
	public UserDTO save(UserDTO newUser) {
		return converter.toDTO(repository.save(converter.toEntity(newUser)));
	}

	@Override
	public UserDTO update(UserDTO newUser) {
		Optional<User> optionalUser = repository.findByUsername(newUser.getUsername());
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setPassword(newUser.getPassword());
			user.setName(newUser.getName());
			user.setAuthorPseudonym(newUser.getAuthorPseudonym());
			return converter.toDTO(repository.save(user));
		}
		throw new UserNotFoundException(newUser.getUsername());
	}

}
