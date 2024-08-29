package com.hexaware.hibernate.Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hexaware.hibernate.model.Product;

public class Connection {
	
	private static SessionFactory fac;
	
	public Connection() {
		fac = new Configuration().configure("hql.config.xml").addAnnotatedClass(Product.class).buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		Connection con = new Connection();
		return fac;
	}
}
