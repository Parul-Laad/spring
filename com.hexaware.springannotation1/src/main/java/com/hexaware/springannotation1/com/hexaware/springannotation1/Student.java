package com.hexaware.springannotation1.com.hexaware.springannotation1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
	int rollNo;
	String name;
	Double fee;
	
	@Autowired
	Result res;
	
	/*@Autowired
	@Qualifier("res1")
	Result res1;
	
	public Result getRes1() {
		return res1;
	}
	public void setRes1(Result res1) {
		this.res1 = res1;
	}*/
	public Student() {
		
	}
	public int getRollNo() {
		return rollNo;
	}
	public Result getRes() {
		return res;
	}
	public void setRes(Result res) {
		this.res = res;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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
	
	public Student(int rollNo, String name, Double fee) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", fee=" + fee + "]";
	}
	
	void init() {
		System.out.println("before object creation");
	}
	
	void destroy() {
		System.out.println("After finishing work");
	}
	

}
