package com.hexaware.vis.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.vis.dao.UserRepository;
import com.hexaware.vis.dto.OfficerDTO;
import com.hexaware.vis.dto.UserDTO;
import com.hexaware.vis.entities.User;
import com.hexaware.vis.enums.Role;
import com.hexaware.vis.exception.UserAlreadyExistsException;
//import com.hexaware.vis.exception.UserNotFoundException;
import com.hexaware.vis.security.UserDetailsImpl;

@Service
public class UserService implements UserDetailsService{

	   @Autowired
	    private PasswordEncoder encoder;

	    @Autowired
	    private UserRepository repository;
	    
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userDetail = repository.findByEmail(email);

        // Converting userDetail to UserDetails
        return userDetail.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
	}
	/*
	 public String addUser(User user) {
	        user.setPassword(encoder.encode(user.getPassword()));
	        repository.save(user);
	        return "User Added Successfully...";
	    }
	    */
	
	
	public User saveUser(UserDTO userDTO) {
        if (repository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists with email: " + userDTO.getEmail());
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setRole(Role.USER);
        user.setContactNumber(userDTO.getContactNumber());
        user.setEmail(userDTO.getEmail());
        user.setAadharNumber(userDTO.getAadharNumber());
        user.setPan(userDTO.getPan());
        user.setLicenseNumber(userDTO.getLicenseNumber());
        user.setLicenseValidity(userDTO.getLicenseValidity());
        user.setGender(userDTO.getGender());

        return repository.save(user);
    }

    public User saveUser(OfficerDTO officerDTO) {
        if (repository.findByEmail(officerDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists with email: " + officerDTO.getEmail());
        }

        User user = new User();
        user.setName(officerDTO.getName());
        user.setPassword(encoder.encode(officerDTO.getPassword()));
        user.setRole(Role.OFFICER);
        user.setContactNumber(officerDTO.getContactNumber());
        user.setEmail(officerDTO.getEmail());
        user.setAadharNumber(officerDTO.getAadharNumber());
        user.setPan(officerDTO.getPan());
        user.setGender(officerDTO.getGender());
        user.setDateOfJoining(officerDTO.getDateOfJoining());

        return repository.save(user);
    }
	
	

}
