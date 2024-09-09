package com.hexaware.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hexaware.app.Dao.RepStudent;
import com.hexaware.app.Entity.Student;
import com.hexaware.app.Exception.IdNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	RepStudent repSt;
	
    public Student  saveSt(Student s)
	
	{
		Student s2=repSt.save(s);
		return s2;
	}

	public List<Student> getStuds() {
		List l = (List)repSt.findAll();
		return l;
	}

	
	/*
	public Student removeSd(int rno) {
		
			
		    
		    Student s=	repSt.findById(rno).orElse(null);
		  //Student s=	repSt.findById(rno).orElseThrow(()-> new Exception("not found" + rno));
		
			if(s==null)
			{
				return null;
			}
				
			else
			{
				
				repSt.delete(s);
		}
			
			return s;
				
			}
	*/
	
	
	//implemented with exception
	public Student removeSd(int rno) {
	    Student s = null;
	   try {
	        s = repSt.findById(rno).orElseThrow(() -> new Exception("Student not found with roll number: " + rno));
	        repSt.delete(s);
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	        return null; // Or you can handle this by returning a custom error message
	    }
	    return s;
	}

	
	public String update(String nm, int rn) {

		Student s=	repSt.findById(rn).orElse(null);
		if(s==null)
		{
			return "not found ";
		}
			
		else
		{
			s.setName(nm);
			
			repSt.save(s);
			return "Name updated";
		}
		
		
	}
	

	/*
	public String update(String nm, int rn) {
	    Student s = repSt.findById(rn).orElseThrow(() -> new IdNotFoundException("Student with roll number " + rn + " not found"));
	    
	    s.setName(nm);
	    repSt.save(s);
	    
	    return "Name updated";
	}
	*/

	
	public Student findByRollNumber(int rollNo) {
		Student s =  repSt.findById(rollNo).orElse(null);
		return s;
	}
	

}
