package com.hexaware.hibernate.AssignmentOnHQL;

import java.util.Scanner;

import com.hexaware.hibernate.Service.Service;

/**
 * Hello world!
 *
 */
public class App 
{
	 
	
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        Service ser = new Service();
        
        System.out.println("1. Add or Update Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Update Price");
        System.out.println("4. Calculate Bill");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int c = sc.nextInt();
        
        switch(c) {
        	case 1: 
        		ser.addItem();
        		break;
        	case 2: 
        		ser.removeItem();;
        		break;
        	case 3: 
        		ser.updatePricebByCode();;
        		break;
        	case 4: 
        		ser.calculateBill();
        		break;
        	case 5: 
        		System.out.println("Exit");
        		break;
        }
    }
}
