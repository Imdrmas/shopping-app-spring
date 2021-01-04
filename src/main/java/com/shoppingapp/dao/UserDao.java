package com.shoppingapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.modal.User;

public interface UserDao extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username); 
}
