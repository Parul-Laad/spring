package com.hexaware.hibernate.com.hexaware.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


 
public class App {
	
	SessionFactory fac;
	Session ses;
	 Transaction tx;
	 Scanner sc;
	 
	 App(){
		 fac=new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
	    	
	     ses=fac.openSession();
	     
	     sc =new Scanner(System.in);
	    	
	 }
	 
	
	
	   void insertBook()
	    {
	    	 tx=ses.beginTransaction();
	         
	         Book b= new Book();
	        // b.setbNo(105);
	         b.setName("c++");
	         b.setPrice(80.9);
	         
	         ses.save(b);
	         tx.commit();
	    }
	   
	   void RemoveByBNo()
	    {
		    System.out.println("Enter the book id to remove.");
	    	int bn=sc.nextInt();
	    	tx=ses.beginTransaction();
	    	Book b= ses.find(Book.class,bn);
	    	if(b!=null)
	    	{
	    		ses.delete(b);
	    		tx.commit();
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Not Found");
	    	}
	    }
	   
	   
	   void UpdateBkPriceByBNo()
	    {
		   System.out.println("Enter the book id to update price.");
	    	int bn=sc.nextInt();
	    	
	    	
	    	
	    	tx=ses.beginTransaction();
	    	
	    	
	    	Book b= ses.find(Book.class,bn);
	    	if(b!=null)
	    	{
	    		System.out.println("Enter updated price.");
		    	Double b1=sc.nextDouble();
	    		
	    		b.setPrice(b1);
	    		ses.update(b);
	    		tx.commit();
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Not Found");
	    	}

	    	
	    	
	    	
	    	
	    }
	   
	   void searchByBookNo() {
		   System.out.println("Enter the book id to search");
	    	int bn=sc.nextInt();
	    	
	    	tx=ses.beginTransaction();
	    	
	    	Book b= ses.find(Book.class,bn);
	    	
	    	if(b!=null) {
	    		System.out.println(b.getName());
	    		tx.commit();
	    	}
	    	else
	    	{
	    		System.out.println("Not Found");
	    	}
	    	
	   }
	    
	   void showAll()
	    {
	    	
	    	 tx=ses.beginTransaction();
	    	
	    	 Query q=ses.createQuery("from Book ");
	    	 List <Book>books= q.list();
	    	 tx.commit();
	    	
	    	 for(Book b : books)
	    	 {
	    		 System.out.println(b.toString());
	    		
	    	 }
	    	
	    	

	    }
	   
	   //Using hql query which is used to write custom queries
	   void showData()
	    {
	    	 tx=ses.beginTransaction();
	    	 
	    	 //String hql="from Book B where B.price>:p "; 
	    	 String hql="from Book B where B.price>:p and B.name=:nm";
	    	 Query q =ses.createQuery(hql,Book.class);
	    	 q.setParameter("p", 100.0);
	    	 q.setParameter("nm", "dsa");
	    	 List <Book> books=q.list();
	    	 tx.commit();
	    	
	    	 System.out.println(books);
	    	
	    	

	    	
	    }
	   
	   void updatebyBookNo()
	    {
	    	 tx=ses.beginTransaction();
	    	
	    	 String hql="UPDATE Book B set B.name=:nm where B.bNo=:bn ";
	    	
	    	 Query q =ses.createQuery(hql);
	    	
	    	 q.setParameter("bn", 2);
	    	 q.setParameter("nm", "EXpress ");

			  int a=-1;
			  q.executeUpdate();
			  tx.commit();
			  if(a==-1)
			  {
				   System.out.println("update");
			  }
			  else
			  {
				   System.out.println("name updated");
			  }
	    	
	    	
			  

	    	
	    }
	   
	   void removeHQL()
	    {
	    	 tx=ses.beginTransaction();
	    	
	    	 String hql="delete from Book B where B.bNo=:bn ";
	    	
	    	 Query q =ses.createQuery(hql);
	    	
	    	 q.setParameter("bn", 102);
	    	

		  int a=-1;
		  q.executeUpdate();
		  if(a==-1)
		  {
			   System.out.println("Removed");
		  }
		  else
		  {
			   System.out.println("not  remove");
		  }
		  tx.commit();
			
	
	    }
	    
	    



	   
   public static void main(String[] args) {

   	App app= new App();
    app.insertBook();
    /*app.RemoveByBNo();
    app.UpdateBkPriceByBNo();
   	app.searchByBookNo();
   	app.showAll();*/
   	//app.showData();
   	//app.updatebyBookNo();
    app.removeHQL();
    }
}
