package com.hexaware.hibernate.com.hexaware.hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ITBook")
public class Book {
	
	@Id
	@GeneratedValue
	int bNo;
	
	@Column
	String name;
	
	@Column
	Double price;
	
	@Transient
	String subject;
	
	
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bNo=" + bNo + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
