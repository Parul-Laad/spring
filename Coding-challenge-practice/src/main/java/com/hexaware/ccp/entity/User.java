package com.hexaware.ccp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


import java.util.Collection;
import java.util.Collections;

@Entity
public class User {

    @Id
    private String username;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role; 
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
}
