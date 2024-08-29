package com.hexaware.hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.hibernate.Connection.Connection;
import com.hexaware.hibernate.model.Product;

public class Dao implements DaoInterface{

	Transaction tx;
	SessionFactory fc;
	
	public Dao() {
		fc = Connection.getSessionFactory();
	}
	
	@Override
	public void addItem(int id, String name,int quantity,double price) {
		Session ses = fc.openSession();
		tx = ses.beginTransaction();
		
		Product p = new Product();
		p.setPid(id);
		p.setName(name);
		p.setQuantity(quantity);
		p.setPrice(price);
		ses.save(p);
		tx.commit();
		ses.close();
		
	}

	@Override
	public int removeItem(int id) {
		Session ses = fc.openSession();
		tx = ses.beginTransaction();
		String hql = "delete from Product where pid =: id";
		Query q = ses.createQuery(hql);
		q.setParameter("id", id);
		int update = q.executeUpdate();
		
		tx.commit();
		ses.close();
		return update;
		
	}

	@Override
	public int updatePricebByCode(int id, double price) {
		Session ses = fc.openSession();
		tx = ses.beginTransaction();
		String hql = "Update Product p set p.price = :price where p.pid = :id";
		Query q = ses.createQuery(hql);
		q.setParameter("price", price);
		q.setParameter("id", id);
		int update = q.executeUpdate();
		tx.commit();
		ses.close();
		return update;
		
	}

	@Override
	public double calculateBill(Product p,int qty) {
		Double billAmount = p.getPrice() *qty;
		return billAmount;
	}

	@Override
	public Product checkItembyCode(int c) {
		Session ses = fc.openSession();
		tx = ses.beginTransaction();
		String hql = "from Product where pid =: id";
		
		Query q = ses.createQuery(hql,Product.class);
		q.setParameter("id",c);
		List<Product> products = q.getResultList();
		Product p = null;
		if (!products.isEmpty()) {
		    p = products.get(0);  // Retrieve the first result if it exists
		}
		tx.commit();
		ses.close();
		return p;
		
		
	}

	@Override
	public int updateQuantity(int id,int qty) {
		Session ses = fc.openSession();
		tx = ses.beginTransaction();
		String hql = "Update Product p set p.quantity = :qty where p.id =: a";
		Query q = ses.createQuery(hql);
		q.setParameter("qty", qty);
		q.setParameter("a",id);
		int update = q.executeUpdate();
		tx.commit();
		ses.close();
		return update;
	}
	

}
