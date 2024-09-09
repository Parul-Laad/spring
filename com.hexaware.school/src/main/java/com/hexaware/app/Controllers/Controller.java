package com.hexaware.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.app.Entity.Student;
import com.hexaware.app.Service.StudentService;

import jakarta.validation.Valid;

@RestController
public class Controller {
	
	@Autowired
	StudentService studSer;
	
	/*
	@PostMapping("/saveStudent")
	Student saveStudent(@Valid @RequestBody Student s)
	{
		Student s2=studSer.saveSt(s);
		return s2;
		
	}
	
	*/
	
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student s) {
		int rn = s.getRoll();
		
		Student s1 = studSer.findByRollNumber(rn);
		
		if (s1==null) {
		
				Student s2 = studSer.saveSt(s);
				return new ResponseEntity<>(s2, HttpStatus.CREATED);
		}
	    else{
	        return new ResponseEntity<>( HttpStatus.CONFLICT);
	    }
	   
	}
	

	
	/*
	@GetMapping("/getStudents")
	public List <Student> getStudents(){
		List <Student> users = studSer.getStuds();
		return users;S
		
	}
	*/
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getStudents() {
	    List<Student> users = studSer.getStuds();
	    
	    if (users.isEmpty()) {  // Checking if the list is empty
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Return 204 No Content if list is empty
	    } else {
	        return new ResponseEntity<>(users, HttpStatus.OK);  // Return 200 OK with the list if not empty
	    }
	}

	
	
	
	@DeleteMapping("/removeStud/{rno}")
	public Student removeStud(@PathVariable int rno) {
		
		Student s = studSer.removeSd(rno);
		return s;
	}
	
	
	/*
	@PutMapping("/updateName/{rn}/{nm}")
	public String updateName(@PathVariable("nm") String nm, @PathVariable("rn") int rn) {
		String r = studSer.update(nm,rn);
		return r;
	}
	*/
	
	@PutMapping("/updateName/{rn}/{nm}")
	public ResponseEntity<String> updateName(@PathVariable("nm") String nm, @PathVariable("rn") int rn) {
	        String result = studSer.update(nm, rn);
	        
	        if ("Name updated".equals(result)) {
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } else if ("not found ".equals(result)) {
	            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	        } else {
	            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	   
	}


	
	
	/*
	@GetMapping("/findStudent/{rno}")
	public Student findStudByRNo(@PathVariable int rno) {
        Student s = studSer.findByRollNumber(rno);
		return s;
    }
    */
	
	@GetMapping("/findStudent/{rno}")
	public ResponseEntity<Student> findStudByRNo(@PathVariable int rno) {
	    try {
	        Student s = studSer.findByRollNumber(rno);
	        if (s == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // If student is not found
	        } else {
	            return new ResponseEntity<>(s, HttpStatus.OK); // If student is found
	        }
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Handle any unexpected runtime exception
	    }
	}


	
}

