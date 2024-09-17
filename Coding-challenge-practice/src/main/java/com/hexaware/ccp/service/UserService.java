package com.hexaware.ccp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.ccp.dao.UserRepository;
import com.hexaware.ccp.entity.User;


@Service
public class UserService implements UserDetailsService {

	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository  repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		   Optional<User> userDetail = repository.findById(username);

	        // Converting userDetail to UserDetails
	        return userDetail.map(UserDataDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
      
	}
	
	public String addUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
		return "User Added Successfully...";
	}

}