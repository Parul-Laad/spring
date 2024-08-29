package com.hexaware.hibernate.dao;

import com.hexaware.hibernate.model.Product;

public interface DaoInterface {
	void addItem(int id, String name,int quantity,double price);
	int removeItem(int id);
	int updatePricebByCode(int id, double price);
	double calculateBill(Product p,int qty);
	Product checkItembyCode(int c);
	int updateQuantity(int a,int qty);
	

}
