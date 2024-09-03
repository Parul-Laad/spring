package hexaware2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
	
	int code;
	Double Price;
	String name;
	
	public Product()
	{
		
	}
	
	
	
	public Product(int code, Double price, String name) {
		super();
		this.code = code;
		Price = price;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", Price=" + Price + ", name=" + name + "]";
	}
	
	
}
 

public class StreamAPIExample {
	public static void main(String[] args) {
		
		List<String> users = new ArrayList();
		users.add("asha");
		users.add("pooja");
		users.add("kavita");
		users.add("ajay");
		users.add("parul");
		
		
		users.stream().forEach((t) -> System.out.println(t));
		
		System.out.println();
		System.out.println();
		
		users.stream().filter((t)->t.startsWith("as")).forEach((t)-> System.out.println(t));
		
		System.out.println();
		System.out.println();
		
		long c = users.stream().filter((t)-> t.length()>4).count();
		
		System.out.println(c);
		System.out.println();
		
		List<Integer> al= new ArrayList();
		al.add(2);
		al.add(22);
		al.add(42);

		al.add(28);
		
		al.stream().forEach((t) -> System.out.println(t));
		
		System.out.println();System.out.println();

		al.stream().filter((e)->e%2==0).forEach((t)->System.out.println(t));
		
		System.out.println();System.out.println();
		
		
		List <String>users1=new ArrayList<String>();
		
			users1.add("Asha sharma");
			users1.add("pooja gupta");
			users1.add("kavita gupta");
			users1.add("Ajay sharma");
			users1.add("deepa sharma");
			
			long c1=users1.stream().filter((temp)->temp.endsWith("sharma")).count();
			users1.stream().filter((temp)->temp.endsWith("sharma")).forEach((t)-> System.out.println(t) );
			System.out.println(c);
		
			System.out.println();System.out.println();
			
			List<Integer> monthlySalaries = new ArrayList();
			monthlySalaries.add(3000);
			monthlySalaries.add(7000);
			monthlySalaries.add(6000);
			monthlySalaries.add(4000);
			monthlySalaries.add(5000);
			
			List list = monthlySalaries.stream().map((t)-> t*12).collect(Collectors.toList());
			
			System.out.println(list);
			
			
			System.out.println();System.out.println();
		
		/*for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
		
		
		for(Integer i : al)
		{
			System.out.println(i);
		}*/
			
			
			List <Product>products=new ArrayList();
			
		       Product p1=new Product(101,200.9,"pen");
		       products.add(p1);
		       
		   	
		       Product p2=new Product(102,400.9,"notebook");
		       products.add(p2);
		   	
		       Product p3=new Product(106,800.9,"book");
		       products.add(p3);
		       
		       Product p4=new Product(107,900.9,"book");
		       products.add(p4);
		       
		       Product p5=new Product(108,800.9,"book");
		       products.add(p5);
		       
		       
		       products.stream().forEach((temp)-> System.out.println(temp.toString()));
		       System.out.println();
		       
		       products.stream().filter((t)-> t.getCode() == 102).forEach((temp)-> System.out.println(temp.toString()));
		       System.out.println();
		       
		       products.stream().filter((t)-> t.getName().equals("book")).forEach((temp)-> System.out.println(temp.toString()));
		       System.out.println();
		       
		       List p = products.stream().filter((t)-> t.getName().equals("book")).collect(Collectors.toList());
		       System.out.println(p);
		    
		
	}


}

/*
 * 
 * 
 * 
 * public class Product {
	
	int code;
	Double Price;
	String name;
	
	public Product()
	{
		
	}
	
	
	
	public Product(int code, Double price, String name) {
		super();
		this.code = code;
		Price = price;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", Price=" + Price + ", name=" + name + "]";
	}
	
	
	
	
 
}
 
import java.util.ArrayList; import java.... by Shalini Trainer (Unverified)
Shalini Trainer (Unverified)
3:47 PM
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
 
public class Main {
 
	public static void main(String[] args) {
 
 
       List <Product>products=new ArrayList();
		
       Product p1=new Product(101,200.9,"pen");
       products.add(p1);
       
   	
       Product p2=new Product(102,400.9,"notebook");
       products.add(p2);
   	
       Product p3=new Product(106,800.9,"book");
       products.add(p3);
       
       
       
       products.stream().forEach((temp)->System.out.println(temp.toString()) );
       
       
       
       
       /*for(Product p  : products)
       {
    	   System.out.println(p.toString());
       }
       
   	
 
 
		
		
		
		
		
		
 
 
 
		
		
		
		
     
		
		
		
 
 
		
		
	     	
		
		
	
 
	}
 
}
 
has context menu  
 * 
 * 
 * 
 */
