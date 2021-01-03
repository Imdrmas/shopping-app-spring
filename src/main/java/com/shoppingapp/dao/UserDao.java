package com.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapp.modal.User;

public interface UserDao extends JpaRepository<User, Long> {

}
