package com.hexaware.vis.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.vis.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
