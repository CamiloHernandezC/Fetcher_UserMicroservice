package com.fetcher.usermicroservice.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.fetcher.usermicroservice.DTO.UserDTO;
import com.fetcher.usermicroservice.exceptions.UserNotFoundException;

public interface UserServiceInterface {

	List<UserDTO> all();

	Optional<UserDTO> findUserByUsername(String username) throws UserNotFoundException;

	void deleteUserByUsername(String username);

	UserDTO save(UserDTO newUser);

	UserDTO update(UserDTO newUser);
}
