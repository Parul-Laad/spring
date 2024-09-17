package com.hexaware.ccp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ccp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
