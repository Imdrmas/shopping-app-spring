package com.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.modal.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
