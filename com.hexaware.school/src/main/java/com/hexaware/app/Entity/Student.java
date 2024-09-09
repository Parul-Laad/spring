package com.hexaware.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
	
	@Id
	int roll;
	
	@NotEmpty
	String name;
	
	@Min(value=18,message="Age cannot be less than 18")
	@Max(value=60,message="Age cannot be greater than 60")
	int age;
	
	// @Pattern(regexp = "^[0-9]{6}$") //can only be used on String
	Double fee;
	
	@Email
	String email;
	
	@Size(min=4,max=50)
	String address;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFee() {
		return fee;
	}
	
	
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Student(int roll, String name, Double fee) {
		super();
		this.roll = roll;
		this.name = name;
		this.fee = fee;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", age=" + age + ", fee=" + fee + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
	
	
	

}
