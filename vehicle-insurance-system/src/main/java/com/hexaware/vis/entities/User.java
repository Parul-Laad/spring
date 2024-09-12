package com.hexaware.vis.entities;

import java.time.LocalDate;

import com.hexaware.vis.enums.Gender;
import com.hexaware.vis.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotNull(message = "Role is mandatory")
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be a valid 10-digit number")
    private String contactNumber;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Aadhar number is mandatory")
    @Pattern(regexp = "\\d{12}", message = "Aadhar number must be 12 digits")
    private String aadharNumber;

    @Size(max = 10, message = "PAN number should be at most 10 characters")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "PAN number should be in the format XXXXX1234X")
    private String pan;

    @Pattern(regexp = "[A-Z]{2}[0-9]{2}\\s[0-9]{11}", message = "License number should follow the format XX00 00000000000")
    private String licenseNumber; // Only for User role

    private LocalDate licenseValidity; // Only for User role

    @NotNull(message = "Gender is mandatory")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfJoining; // Only for Officer role

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

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

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + ", contactNumber="
				+ contactNumber + ", email=" + email + ", aadharNumber=" + aadharNumber + ", pan=" + pan
				+ ", licenseNumber=" + licenseNumber + ", licenseValidity=" + licenseValidity + ", gender=" + gender
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}

	public User(Long id, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Password is mandatory") String password,
			@NotNull(message = "Role is mandatory") Role role,
			@NotBlank(message = "Contact number is mandatory") @Pattern(regexp = "^\\d{10}$", message = "Contact number must be a valid 10-digit number") String contactNumber,
			@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email,
			@NotBlank(message = "Aadhar number is mandatory") @Pattern(regexp = "\\d{12}", message = "Aadhar number must be 12 digits") String aadharNumber,
			@Size(max = 10, message = "PAN number should be at most 10 characters") @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "PAN number should be in the format XXXXX1234X") String pan,
			@Pattern(regexp = "[A-Z]{2}[0-9]{2}\\s[0-9]{11}", message = "License number should follow the format XX00 00000000000") String licenseNumber,
			LocalDate licenseValidity, @NotNull(message = "Gender is mandatory") Gender gender,
			LocalDate dateOfJoining) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.contactNumber = contactNumber;
		this.email = email;
		this.aadharNumber = aadharNumber;
		this.pan = pan;
		this.licenseNumber = licenseNumber;
		this.licenseValidity = licenseValidity;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
}
