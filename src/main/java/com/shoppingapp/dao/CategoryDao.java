package com.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.modal.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
