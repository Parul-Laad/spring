package com.hexaware.hibernate.Service;

import java.util.Scanner;

import com.hexaware.hibernate.dao.Dao;
import com.hexaware.hibernate.dao.DaoInterface;
import com.hexaware.hibernate.model.Product;

public class Service {
	
	 Scanner sc = new Scanner(System.in);
	DaoInterface di = new Dao();
	
	public void addItem() {
		System.out.println("Enter the product details to add ");
		System.out.println("Enter product id");
		int id = sc.nextInt();
		sc.nextLine();
		Product p = di.checkItembyCode(id);
		if(p!=null) {
			System.out.println("Item already present");
			System.out.println("Item name is " + p.getName()+ " having quantity " + p.getQuantity() );
			System.out.println("Do you want to update quantity? \n Type yes to update quantity.");
			String ans = sc.nextLine();
			//sc.nextLine();
			if(ans.equalsIgnoreCase("yes")) {
				System.out.println("Enter the quantity.");
				int qty = sc.nextInt();
				sc.nextLine();
				int result = di.updateQuantity(p.getPid(),qty);
				if(result==1) {
					System.out.println("Updated");
				}
				else {
					System.out.println("Not updated");
				}
			}
			else {
				System.out.println("No change.");
			}
		}
		else{
			
			System.out.println("Enter name");
			String name = sc.nextLine();
			System.out.println("Enter quantity.");
			int qty = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter price with decimal");
			Double price = sc.nextDouble();
			sc.nextLine();
			di.addItem(id,name,qty,price);
			System.out.println("Insertion done");
			
		}
		
		
	}

	
	public void removeItem() {
		System.out.println("Enter the id of the Product to remove");
		int id = sc.nextInt();
		Product p = di.checkItembyCode(id);
		if(p!=null) {
			int result = di.removeItem(id);
			if(result!=0) {
				System.out.println("Item removed");
			}
			else
				System.out.println("Could not remove item");
		}
		else {
			System.out.println("Product not found so cannot delete");
		}
		
	}

	
	public void updatePricebByCode() {
		System.out.println("Enter the id of the Product to update price");
		int id = sc.nextInt();
		Product p = di.checkItembyCode(id);
		if(p!=null) {
				System.out.println("The price for the product id "+ id+ " is "+ p.getPrice());
				System.out.println("Enter the price to update");
				double price = sc.nextDouble();
				int result = di.updatePricebByCode(id,price);
				if(result!=0) {
					System.out.println("Price updated");
				}
				else
					System.out.println("Could not update price.");
		}
		else {
			System.out.println("Product with product id "+ id+" not found");
		}
	}

	
	public void calculateBill() {
		System.out.println("Enter the id of the Product to calculate bill");
		int id = sc.nextInt();		
		Product p = di.checkItembyCode(id);
		if(p!=null) {
				System.out.println("The price for one item with product id "+ id + " is "+ p.getPrice());
				System.out.println("Enter the quantity to buy.");
				int qty = sc.nextInt();
				if(qty<=p.getQuantity()) {
						double result = di.calculateBill(p,qty);
						System.out.println("The total bill for product id " + p.getPid() + " having price for singe item "
								+ p.getPrice() + " with quantity " + qty +" is " + result);
				}  
				else {
					System.out.println("Insufficient quantity.");
				}
		}
		else {
			System.out.println("Product with product id "+ id+" not found");
		}
	}

	

}
