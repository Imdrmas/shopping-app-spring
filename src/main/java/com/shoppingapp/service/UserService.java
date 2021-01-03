package com.shoppingapp.service;

import org.springframework.stereotype.Service;

import com.shoppingapp.modal.User;

@Service
public interface UserService {
 
	User addUser(User user);
	
	User editUser(User user, User existsUser);
}
