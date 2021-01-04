package com.shoppingapp.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String username;

	private String password;

	private boolean admin;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Shopping> shoppings;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Cart> carts;

	public User() {
		super();
	}

	public User(String username, String password, boolean admin, List<Shopping> shoppings, List<Cart> carts) {
		super();
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.shoppings = shoppings;
		this.carts = carts;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Shopping> getShoppings() {
		return shoppings;
	}

	public void setShoppings(List<Shopping> shoppings) {
		this.shoppings = shoppings;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public void addCartToUser(Cart cart) {
		if (getCarts() == null) {
			this.carts = new ArrayList<>();
		}
		getCarts().add(cart);
		cart.setUser(this);
	}
	public void addShoppingToUser(Shopping shopping) {
		if (getShoppings()==null) {
			this.shoppings = new ArrayList<>();
		}
		getShoppings().add(shopping);
		shopping.setUser(this);
	}

}
