package com.fetcher.usermicroservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fetcher.usermicroservice.DTO.UserDTO;
import com.fetcher.usermicroservice.exceptions.UnauthorizedException;
import com.fetcher.usermicroservice.exceptions.UserNotFoundException;
import com.fetcher.usermicroservice.exceptions.UsernameTakenException;
import com.fetcher.usermicroservice.services.interfaces.UserServiceInterface;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class UserController {
	
	private final UserServiceInterface service;

	@GetMapping("/users") 
	List<UserDTO> all() {
		return (service.all());
	}
	
	@GetMapping("/users/{username}")  
	UserDTO getUser(@PathVariable("username") String username)   
	{  
		return service.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
		
	}
	
	@DeleteMapping("/users/{username}")  
	void deleteUser(@PathVariable("username") String username, @RequestHeader("username") String authenticatedUser)   
	{  
		if(authenticatedUser.equals(username)) {
			service.deleteUserByUsername(username);
			return;
		}
		throw new UnauthorizedException("because you are trying to delete a user that don't belongs to you");
	}
	
	@PutMapping("/register")
	UserDTO newUser(@RequestBody UserDTO newUser) {
		if(service.findUserByUsername(newUser.getUsername()).isPresent()) {
			throw new UsernameTakenException(newUser.getUsername());
		}
		return service.save(newUser);
	}
	
	@PostMapping("/users")
	UserDTO updateUser(@RequestBody UserDTO newUser, @RequestHeader("username") String authenticatedUser) {
		if(authenticatedUser.equals(newUser.getUsername())) {
			return service.update(newUser);
		}
		throw new UnauthorizedException("because you are trying to update a user that don't belongs to you");
		
	}
	
}
