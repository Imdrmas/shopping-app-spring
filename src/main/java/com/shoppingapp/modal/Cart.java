package com.shoppingapp.modal;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;

	private int count;
	
	private double price;

	private double total;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date added;

	@ManyToOne
	private User user;

	public Cart() {
		super();
	}

	public Cart(String name, int count, double price, double total, Date added, User user) {
		super();
		this.name = name;
		this.count = count;
		this.price = price;
		this.total = total;
		this.added = added;
		this.user = user;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotal() {
		return total;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
