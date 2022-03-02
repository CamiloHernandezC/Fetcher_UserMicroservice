package com.fetcher.usermicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fetcher.usermicroservice.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
