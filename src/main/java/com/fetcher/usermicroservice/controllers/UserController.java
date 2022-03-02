package com.fetcher.usermicroservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fetcher.usermicroservice.DTO.UserDTO;
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
}
