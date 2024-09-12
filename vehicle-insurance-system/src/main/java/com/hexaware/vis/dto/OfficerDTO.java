package com.hexaware.vis.dto;


import com.hexaware.vis.enums.Gender;
import com.hexaware.vis.enums.Role;

import java.time.LocalDate;

public class OfficerDTO {
    private String name;
    private String password;
 //   private Role role;
    private String contactNumber;
    private String email;
    private String aadharNumber;
    private String pan;
    private Gender gender;
    private LocalDate dateOfJoining;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/*
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
*/
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }


    
    
    public OfficerDTO(String name, String password, String contactNumber, String email, String aadharNumber, String pan,
			Gender gender, LocalDate dateOfJoining) {
		super();
		this.name = name;
		this.password = password;
		this.contactNumber = contactNumber;
		this.email = email;
		this.aadharNumber = aadharNumber;
		this.pan = pan;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "OfficerDTO [name=" + name + ", password=" + password + ", contactNumber=" + contactNumber + ", email="
				+ email + ", aadharNumber=" + aadharNumber + ", pan=" + pan + ", gender=" + gender + ", dateOfJoining="
				+ dateOfJoining + "]";
	}

	public OfficerDTO() {
    	
    }
    
    
    
}
