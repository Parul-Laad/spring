package com.hexaware.springannotation1.com.hexaware.springannotation1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext anno=new AnnotationConfigApplicationContext(StudentConfig.class);
    	
    	Student s=(Student)anno.getBean("stud1");
        System.out.println(s.toString());
        
        Result r = s.getRes();
        System.out.println(r.toString());
        
        Student s2 = (Student) anno.getBean("stud2");
        System.out.println(s2.toString());

        Result r1 = s2.getRes();
        System.out.println(r1.toString());
        
        anno.close();
        
        
    }
}
