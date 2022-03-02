package com.fetcher.usermicroservice.services.interfaces;

import java.util.List;

import com.fetcher.usermicroservice.DTO.UserDTO;

public interface UserServiceInterface {

	List<UserDTO> all();
}
