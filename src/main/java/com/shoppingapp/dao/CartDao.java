package com.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.modal.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {

}
