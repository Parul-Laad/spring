package com.hexaware.ccp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.ccp.entity.User;

public class UserDataDetails implements UserDetails {

	 private String name;
	    private String password;
	    private List<GrantedAuthority> authorities;

	    public UserDataDetails(User user) {
	        this.name = user.getUsername();
	        this.password = user.getPassword();
	     //   this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
	        this.authorities = List.of(new SimpleGrantedAuthority(user.getRole().name()));
	    }
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return name;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
}
