package com.hexaware.vis.dto;


import com.hexaware.vis.enums.Gender;
import com.hexaware.vis.enums.Role;

import java.time.LocalDate;

public class UserDTO {
    private String name;
    private String password;
   // private Role role;
    private String contactNumber;
    private String email;
    private String aadharNumber;
    private String pan;
    private String licenseNumber;
    private LocalDate licenseValidity;
    private Gender gender;
 

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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getLicenseValidity() {
        return licenseValidity;
    }

    public void setLicenseValidity(LocalDate licenseValidity) {
        this.licenseValidity = licenseValidity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public UserDTO(String name, String password, String contactNumber, String email, String aadharNumber, String pan,
			String licenseNumber, LocalDate licenseValidity, Gender gender) {
		super();
		this.name = name;
		this.password = password;
		this.contactNumber = contactNumber;
		this.email = email;
		this.aadharNumber = aadharNumber;
		this.pan = pan;
		this.licenseNumber = licenseNumber;
		this.licenseValidity = licenseValidity;
		this.gender = gender;
	}

    
    
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", password=" + password + ", contactNumber=" + contactNumber + ", email="
				+ email + ", aadharNumber=" + aadharNumber + ", pan=" + pan + ", licenseNumber=" + licenseNumber
				+ ", licenseValidity=" + licenseValidity + ", gender=" + gender + "]";
	}

	public UserDTO() {
    	
    }
    
}



