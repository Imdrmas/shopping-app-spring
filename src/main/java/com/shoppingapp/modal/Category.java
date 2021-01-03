package com.shoppingapp.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product> products;

	@ManyToOne
	private Shopping shopping;

	public Category() {
		super();
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Shopping getShopping() {
		return shopping;
	}

	public void setShopping(Shopping shopping) {
		this.shopping = shopping;
	}

	public Category(String name, List<Product> products, Shopping shopping) {
		super();
		this.name = name;
		this.products = products;
		this.shopping = shopping;
	}

	public void addProductToCategory(Product product) {
		if (getProducts() == null) {
			this.products = new ArrayList<>();
		}
		getProducts().add(product);
		product.setCategory(this);
	}

}
