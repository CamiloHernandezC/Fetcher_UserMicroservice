package com.fetcher.usermicroservice.DTO;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDTO {
	
	private Long id;
	private String name;
	private String username;
	private String password;
	private Set<RoleDTO> roles = new HashSet<RoleDTO>();
	
	
	
	

}
