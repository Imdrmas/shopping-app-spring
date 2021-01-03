package com.shoppingapp.dto;

import java.util.List;

public class UserDto {

	private long id;

	private String username;

	private String password;

	private boolean admin;

	private List<ShoppingDto> shoppings;

	private List<CartDto> carts;

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

	public List<ShoppingDto> getShoppings() {
		return shoppings;
	}

	public void setShoppings(List<ShoppingDto> shoppings) {
		this.shoppings = shoppings;
	}

	public List<CartDto> getCarts() {
		return carts;
	}

	public void setCarts(List<CartDto> carts) {
		this.carts = carts;
	}

}
