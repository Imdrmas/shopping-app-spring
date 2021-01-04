package com.shoppingapp.dto;
import java.util.List;

public class ShoppingDto {
	
	private long id;

	private String name;
	
	private boolean expanded;
	
	private List<CategoryDto> categories;
	
	
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

	public List<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDto> categories) {
		this.categories = categories;
	}

}
