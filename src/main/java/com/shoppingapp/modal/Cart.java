package com.shoppingapp.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;

	private int count;

	private double total;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date added;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private List<Product> products;
	
	@ManyToOne
	private User user;

	public Cart() {
		super();
	}

	public Cart(String name, int count, double total, Date added, List<Product> products, User user) {
		super();
		this.name = name;
		this.count = count;
		this.total = total;
		this.added = added;
		this.products = products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProductToCart(Product product) {
		if (getProducts()==null) {
			this.products =  new ArrayList<>();
		}
		getProducts().add(product);
		product.setCart(this);
	}
}
