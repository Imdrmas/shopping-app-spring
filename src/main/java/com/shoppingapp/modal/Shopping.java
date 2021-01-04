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
public class Shopping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	
	private boolean expanded;
	
	@ManyToOne
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shopping")
	private List<Category> categories;
	
	public Shopping() {
		super();
	}

	public Shopping(String name, boolean expanded, User user, List<Category> categories) {
		super();
		this.name = name;
		this.expanded = expanded;
		this.user = user;
		this.categories = categories;
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

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addCategoryToShopping(Category category) {
		if (getCategories() == null) {
			this.categories = new ArrayList<>();
		}
		getCategories().add(category);
		category.setShopping(this);
	}

}
