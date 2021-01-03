package com.shoppingapp.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
     @Column
     private boolean expanded;
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopping")
    private List<Category> categories;
    
    @ManyToOne
    private User user;

	public Shopping() {
		super();
	}

	public Shopping(boolean expanded, List<Category> categories, User user) {
		super();
		this.expanded = expanded;
		this.categories = categories;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	public void addCategoryToShopping(Category category) {
		if (getCategories() == null) {
			this.categories = new ArrayList<>();
		}
		getCategories().add(category);
		category.setShopping(this);
	}
	
    
}
