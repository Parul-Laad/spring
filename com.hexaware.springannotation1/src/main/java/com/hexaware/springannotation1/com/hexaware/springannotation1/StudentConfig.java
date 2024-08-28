package com.hexaware.springannotation1.com.hexaware.springannotation1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class StudentConfig {
	
	@Bean(name="stud1", initMethod = "init", destroyMethod = "destroy")
	public Student getStuden1() {
		Student s1 = new Student();
		s1.setRollNo(101);
		s1.setName("Arti");
		s1.setFee(2000.9);
		
		return s1;
	}
	
	@Bean(name="stud2")
	public Student getStudent2() {
		Student s1 = new Student();
		s1.setRollNo(102);
		s1.setName("Parul");
		s1.setFee(5000.5);
		//s1.setRes(result);
		return s1;
	}
	
	@Bean(name = "res")
	public Result getResult() {
		Result r = new Result();
		r.setMarks(99);
		r.setRemarks("pass");
		return r;
	}
	
	/*@Bean(name = "res1")
	public Result getResult1() {
		Result r = new Result();
		r.setMarks(98);
		r.setRemarks("pass");
		return r;
	}*/
	
	
}
