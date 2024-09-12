package com.hexaware.vis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.hexaware.vis.dto.AuthRequest;
import com.hexaware.vis.dto.OfficerDTO;
import com.hexaware.vis.dto.UserDTO;
import com.hexaware.vis.entities.User;
import com.hexaware.vis.exception.UserAlreadyExistsException;
//import com.hexaware.vis.exception.InvalidCredentialsException;
import com.hexaware.vis.security.JwtService;
import com.hexaware.vis.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/home")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome, this endpoint is not secure";
    }

    
    @PostMapping("/user/signup")
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDTO user) {
        try {
            User createdUser = userService.saveUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/officer/signup")
    public ResponseEntity<User> addOfficer(@Valid @RequestBody OfficerDTO officer) {
        try {
            User createdUser = userService.saveUser(officer);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    

    @GetMapping("/user/login")
    @PreAuthorize("hasRole('USER')")
    public String userProfile() {
        return "Logged in as user";
    }

    @GetMapping("/officer/login")
    @PreAuthorize("hasRole('OFFICER')")
    public String adminProfile() {
        return "Logged in as officer";
    }
    
    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        return jwtService.generateToken(authRequest.getEmail());
        
/*
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail());
        } else {
        	throw new InvalidCredentialsException("Invalid email or password");        }
    
    */
    } 

}
