package com.hexaware.ccp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hexaware.ccp.dto.AuthRequest;
import com.hexaware.ccp.entity.User;
import com.hexaware.ccp.service.JwtService;
import com.hexaware.ccp.service.UserService;

public class LoginController {
	
	 @Autowired
	    private UserService service;

	    @Autowired
	    private JwtService jwtService;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @GetMapping("/welcome")
	    public String welcome() {
	        return "Welcome this endpoint is not secure";
	    }

	    @PostMapping("/addNewUser")
	    public String addNewUser(@RequestBody User user) {
	        return service.addUser(user);
	    }

	    @GetMapping("/user/userProfile")
	  //  @PreAuthorize("hasAuthority('ROLE_USER')")
	    @PreAuthorize("hasAuthority('User')")
	    public String userProfile() {
	        return "Welcome to User Profile";
	    }

	    @GetMapping("/admin/adminProfile")
	  //  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    @PreAuthorize("hasAuthority('Admin')")
	    public String adminProfile() {
	        return "Welcome to Admin Profile";
	    }

	    @PostMapping("/generateToken")
	    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(authRequest.getUsername());
	        } else { 
	            throw new UsernameNotFoundException("invalid user request !");
	        }
	    }


}
