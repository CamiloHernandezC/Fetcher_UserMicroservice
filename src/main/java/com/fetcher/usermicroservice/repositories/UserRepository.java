package com.fetcher.usermicroservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fetcher.usermicroservice.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);

}
